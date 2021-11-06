
package Entidad;

/**
 *
 * @author Rodrigo
 */
public class Usuario {
    
    private int id_usuario;
    private String rut;
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    private String contrasena;

    public Usuario() {
    }
    
    public Usuario(String rut, String nombre, String apellidos, String email, String telefono, String contrasena) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.contrasena = contrasena;
    }

    public Usuario(int id_usuario, String rut, String nombre, String apellidos, String email, String telefono) {
        this.id_usuario = id_usuario;
        this.rut = rut;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
    }
    

    public Usuario(String nombre, String apellidos, String email, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
    }
    
    
    
    //Getters
    
    public int getId_usuario() {
        return id_usuario;
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getContrasena() {
        return contrasena;
    }
    
    //Setter

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    
    
}
