package datosImpl;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private String host = "jdbc:mysql://localhost:3306/";
    private String user = "root";
    private String pass = "root";
    private String dbName = "sistema_clientes";

    public Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(host + dbName, user, pass);
    }
}
