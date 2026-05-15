package negocioImpl;

import datos.UsuarioDao;
import datosImpl.UsuarioDaoImpl;
import entidad.Usuario;
import negocio.UsuarioNeg;

public class UsuarioNegImpl implements UsuarioNeg{
	
	private UsuarioDao usuDao = new UsuarioDaoImpl();
	
	
	public UsuarioNegImpl(UsuarioDao usuDao) {
		
		this.usuDao=usuDao;
		
	}
	
	public UsuarioNegImpl() {
		
	}
	
	public Usuario obtenerUno(String usuario,String contrasena) throws Exception {
		
		try {

	        return usuDao.obtenerUsuario(usuario, contrasena);

	    } catch (Exception e) {

	        e.printStackTrace();
	    }

	    return null;
	}

}
	