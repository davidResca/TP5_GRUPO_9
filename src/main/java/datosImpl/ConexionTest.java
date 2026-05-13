package datosImpl;

import java.sql.Connection;
import java.sql.ResultSet;

public class ConexionTest {
    
    public static void main(String[] args) {
        testOpen();
        testClose();
        testQuery();
        testExecute();
    }
    
    public static void testOpen() {
        System.out.println("\n--- Test: Abrir Conexión ---");
        try {
            Conexion conn = new Conexion();
            Connection resultado = conn.Open();
            
            if (resultado != null) {
                System.out.println("✓ PASS: La conexión se abrió correctamente");
            } else {
                System.out.println("✗ FAIL: La conexión es nula");
            }
        } catch (Exception e) {
            System.out.println("✗ ERROR: " + e.getMessage());
        }
    }
    
    public static void testClose() {
        System.out.println("\n--- Test: Cerrar Conexión ---");
        try {
            Conexion conn = new Conexion();
            conn.Open();
            boolean resultado = conn.close();
            
            if (resultado) {
                System.out.println("✓ PASS: La conexión se cerró correctamente");
            } else {
                System.out.println("✗ FAIL: No se pudo cerrar la conexión");
            }
        } catch (Exception e) {
            System.out.println("✗ ERROR: " + e.getMessage());
        }
    }
    
    public static void testQuery() {
        System.out.println("\n--- Test: Ejecutar Query (SELECT) ---");
        try {
            Conexion conn = new Conexion();
            conn.Open();
            
            // Modifica esta consulta según tu BD
            String sql = "SELECT 1";
            ResultSet resultado = conn.query(sql);
            
            if (resultado != null) {
                System.out.println("PASS: La query se ejecutó correctamente");
            } else {
                System.out.println("FAIL: El ResultSet es nulo");
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    
    public static void testExecute() {
        System.out.println("\n--- Test: Ejecutar Insert/Update/Delete ---");
        try {
            Conexion conn = new Conexion();
            conn.Open();
            
            
            String sql = "INSERT INTO clientes (dni, cuil, nombre, apellido, sexo, fecha_nacimiento, direccion, nacionalidad, localidad, provincia, correo_electronico, telefono) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            boolean resultado = conn.execute(sql, "32245687", "20322456879", "Juan", "Pérez", "M", "1990-05-15", "Calle Principal 123", "Argentina", "Buenos Aires", "Buenos Aires", "juan@test.com", "1234567890");

            if (resultado) {
                System.out.println("El execute se ejecutó correctamente");
            } else {
                System.out.println("El execute falló");
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}