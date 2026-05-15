package datosImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import datos.UsuarioDao;
import entidad.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

    @Override
    public Usuario obtenerUsuario(String nombreUsuario, String contrasena) throws Exception {
        
        Usuario usuarioEncontrado = null;
        Conexion cn = new Conexion();
        
        String query = "SELECT id_usuario, usuario, contrasena FROM usuarios WHERE usuario = ? AND contrasena = ?";
        
        try (Connection conn = cn.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
            
            pst.setString(1, nombreUsuario);
            pst.setString(2, contrasena);
            
            try (ResultSet rs = pst.executeQuery()) {
                

                if (rs.next()) {
                    usuarioEncontrado = new Usuario();
                    usuarioEncontrado.setIdUsuario(rs.getInt("id_usuario"));
                    usuarioEncontrado.setNombreUsuario(rs.getString("usuario"));
                    usuarioEncontrado.setContrasena(rs.getString("contrasena"));
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        
        return usuarioEncontrado; 
    }

}