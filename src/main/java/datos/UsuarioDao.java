package datos;

import entidad.Usuario;

public interface UsuarioDao {
	
	public Usuario obtenerUsuario(String nombreUsuario, String contrasena)
			throws Exception; 

}
