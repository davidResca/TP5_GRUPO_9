package datos;

import java.util.List;
import entidad.Cliente;


public interface ClienteDao {
	public List<Cliente> obtenerTodos() throws Exception;
	public Cliente obtenerUno(int id) throws Exception;
	public int insertar(Cliente cliente) throws Exception;
	public int editar(Cliente cliente) throws Exception;
	public int borrar(int id) throws Exception;

}
