package negocio;

import entidad.Usuario;

public interface UsuarioNeg {
	
	
	public Usuario obtenerUno(String usuario,String contrasena) throws Exception;

}
