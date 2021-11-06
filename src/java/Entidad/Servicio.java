
package Entidad;

public class Servicio {
    private String rut;
    private String tipo;
    private String poblacion;
    private String calle;
    private String nroHome;
    private String telefono;
    private String descripcion;

    public Servicio() {
    }

    public Servicio(String rut, String tipo, String poblacion, String calle, String nroHome, String telefono, String descripcion) {
        this.rut = rut;
        this.tipo = tipo;
        this.poblacion = poblacion;
        this.calle = calle;
        this.nroHome = nroHome;
        this.telefono = telefono;
        this.descripcion = descripcion;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNroHome() {
        return nroHome;
    }

    public void setNroHome(String nroHome) {
        this.nroHome = nroHome;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
   
}
