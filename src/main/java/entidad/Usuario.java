package entidad;

import java.io.Serializable;

public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    private int idUsuario;
    private String nombreUsuario;
    private String contrasena;

    // Constructor vacío 
    public Usuario() {}

    // Constructor completo
    public Usuario(int id, String usuario, String pass) {
        this.idUsuario = id;
        this.nombreUsuario = usuario;
        this.contrasena = pass;
    }

    //Getters y Setters
    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public String toString() {
        return "Usuario [id=" + idUsuario + ", nombre=" + nombreUsuario + "]";
    }
}