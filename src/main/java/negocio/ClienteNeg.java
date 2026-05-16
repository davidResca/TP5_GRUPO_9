package negocio;

import java.util.List;
import entidad.Cliente;

public interface ClienteNeg {
	public List<Cliente> obtenerTodos() throws Exception;
	public int insertar(Cliente cliente) throws Exception;
}
