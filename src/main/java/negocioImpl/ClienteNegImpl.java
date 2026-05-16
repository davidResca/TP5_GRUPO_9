package negocioImpl;

import java.util.List;
import entidad.Cliente;
import negocio.ClienteNeg;
import datos.ClienteDao;
import datosImpl.ClienteDaoImpl;



public class ClienteNegImpl implements ClienteNeg{
	
	private ClienteDao clienteDao = new ClienteDaoImpl();

	@Override
	public List<Cliente> obtenerTodos() throws Exception {
		return clienteDao.obtenerTodos();
	}

	@Override
	public int insertar(Cliente cliente) throws Exception {
		return clienteDao.insertar(cliente);
	}
}
