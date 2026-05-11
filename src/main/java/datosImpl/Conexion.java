package datosImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "sistema_clientes";

protected Connection connection;
	
	public Connection Open()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(host+dbName, user, pass);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return this.connection;
	}
	
	public ResultSet query(String query, Object... params)
	{
		PreparedStatement pst;
		ResultSet rs = null;
		try
		{
			pst = connection.prepareStatement(query);
			
			for (int i = 0; i < params.length; i++) {
				pst.setObject(i + 1, params[i]);
			}
			
			rs = pst.executeQuery();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	public boolean execute(String query, Object... params)
	{
		PreparedStatement pst;
		boolean save = true;
		try {
			pst = connection.prepareStatement(query);
			
			for (int i = 0; i < params.length; i++) {
				pst.setObject(i + 1, params[i]);
			}
			
		    pst.executeUpdate();
		}
		catch(SQLException e)
		{
			save = false;
			e.printStackTrace();
		}
		return save;
	}
	
	public boolean close()
	{
		boolean ok=true;
		try {
			connection.close();
		}
		catch(Exception e)
		{
			ok= false;
			e.printStackTrace();
		}
		return ok;
	}
	
}
