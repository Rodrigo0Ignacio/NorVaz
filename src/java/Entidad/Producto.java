
package Entidad;

/**
 *
 * @author Rodrigo
 */
public class Producto {
    
    private String codigo;
    private String nombre;
    private String categoria;
    private String descripcion;
    private String peso;
    private int precio;
    private int stock;
    private String url;

    public Producto() {
    }

    public Producto(String categoria) {
        this.categoria = categoria;
    }

    public Producto(String codigo, String nombre, int precio,
            int stock, String categoria, String descripcion, String peso, String url) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.peso = peso;
        this.precio = precio;
        this.stock = stock;
        this.url = url;
    }
    
    public Producto(String codigo,int stock,int precio) {
        this.codigo = codigo;
        this.precio = precio;
        this.stock = stock;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
    
}
