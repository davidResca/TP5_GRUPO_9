package datosImpl;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;


import datos.ClienteDao;
import entidad.Cliente;

public class ClienteDaoImpl implements ClienteDao {
	private Conexion cn;
	
	@Override
	public List<Cliente> obtenerTodos() throws Exception {
		
		cn = new Conexion();
		List<Cliente> list = new ArrayList<Cliente>();
		
		String query = "SELECT id_cliente, dni, cuil, nombre, apellido, sexo, fecha_nacimiento, direccion, nacionalidad, localidad, provincia, correo_electronico, telefono "
					+ "	FROM clientes";
		
		try (
				Connection conn = cn.getConnection();
				PreparedStatement pst = conn.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
			) {
				
			
			while(rs.next()) {
				Cliente cl = new Cliente();
				
				cl.setIdCliente(rs.getInt("id_cliente"));
				cl.setDni(rs.getString("dni"));
				cl.setCuil(rs.getString("cuil"));
				cl.setNombre(rs.getString("nombre"));
				cl.setApellido(rs.getString("apellido"));
				cl.setSexo(rs.getString("sexo"));
				cl.setFechaNacimiento(rs.getString("fecha_nacimiento"));
				cl.setDireccion(rs.getString("direccion"));
				cl.setNacionalidad(rs.getString("nacionalidad"));
				cl.setLocalidad(rs.getString("localidad"));
				cl.setProvincia(rs.getString("provincia"));
				cl.setCorreoElectronico(rs.getString("correo_electronico"));
				cl.setTelefono(rs.getString("telefono"));
				
				list.add(cl);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Cliente obtenerUno(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertar(Cliente cliente)  throws Exception {
		
		cn = new Conexion();
		String query = "INSERT INTO clientes (dni, cuil, nombre, apellido, sexo, fecha_nacimiento, direccion, nacionalidad, localidad, provincia, correo_electronico, telefono) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int filas = 0;
		
		try (
			Connection conn = cn.getConnection();
			PreparedStatement pst = conn.prepareStatement(query);
		){
		
			pst.setString(1, cliente.getDni());
	        pst.setString(2, cliente.getCuil());
	        pst.setString(3, cliente.getNombre());
	        pst.setString(4, cliente.getApellido());
	        pst.setString(5, cliente.getSexo());
	        pst.setString(6, cliente.getFechaNacimiento());
	        pst.setString(7, cliente.getDireccion());
	        pst.setString(8, cliente.getNacionalidad());
	        pst.setString(9, cliente.getLocalidad());
	        pst.setString(10, cliente.getProvincia());
	        pst.setString(11, cliente.getCorreoElectronico());
	        pst.setString(12, cliente.getTelefono());
	        
	        filas = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int editar(Cliente cliente) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int borrar(int id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
}
