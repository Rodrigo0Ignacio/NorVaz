/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Entidad.Producto;
import Entidad.Venta;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author felip
 */
public class Crud_Producto extends Conexion{
    
    public ArrayList productosAll() {

        ArrayList<Producto> lista;
        lista = new ArrayList();
        try {
            super.query = "SELECT * FROM producto";
            super.st = (Statement) conectar().createStatement();
            super.rs = st.executeQuery(query);

            while (rs.next()) {
                lista.add(new Producto(
                        rs.getString("id_pro"),
                        rs.getString("nombre_pro"),
                        rs.getInt("precio_pro"),
                        rs.getInt("stock_pro"),
                        rs.getString("categoria_pro"),
                        rs.getString("descripcion_pro"),
                        rs.getString("peso_pro"),
                        rs.getString("url"))
                );
            }
            return lista;
        } catch (SQLException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    
    
    public ArrayList buscarCategoria(String categoria) {

        ArrayList<Producto> lista;
        lista = new ArrayList();
        try {
            super.query = "SELECT * FROM producto where categoria_pro='"+categoria+"'";
            super.st = (Statement) conectar().createStatement();
            super.rs = st.executeQuery(query);

            while (rs.next()) {
                lista.add(new Producto(
                        rs.getString("id_pro"),
                        rs.getString("nombre_pro"),
                        rs.getInt("precio_pro"),
                        rs.getInt("stock_pro"),
                        rs.getString("categoria_pro"),
                        rs.getString("descripcion_pro"),
                        rs.getString("peso_pro"),
                        rs.getString("url"))
                );
            }
            return lista;
        } catch (SQLException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    
    public ArrayList listarcomentados() {

        ArrayList<Producto> lista;
        lista = new ArrayList();
        try {
            super.query = "SELECT id_pro,nombre_pro,categoria_pro,descripcion_pro,peso_pro,precio_pro,stock_pro,oferta_pro,url FROM producto,valoracion where id_pro=id_pro2";
            super.st = (Statement) conectar().createStatement();
            super.rs = st.executeQuery(query);

            while (rs.next()) {
                lista.add(new Producto(
                        rs.getString("id_pro"),
                        rs.getString("nombre_pro"),
                        rs.getInt("precio_pro"),
                        rs.getInt("stock_pro"),
                        rs.getString("categoria_pro"),
                        rs.getString("descripcion_pro"),
                        rs.getString("peso_pro"),
                        rs.getString("url"))
                );
            }
            return lista;
        } catch (SQLException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    
    
    public ArrayList ListarCategoria() {

        ArrayList<Producto> lista;
        lista = new ArrayList();
        try {
            super.query = "SELECT DISTINCT categoria_pro FROM producto";
            super.st = (Statement) conectar().createStatement();
            super.rs = st.executeQuery(query);

            while (rs.next()) {
                lista.add(new Producto(
                        rs.getString("categoria_pro"))
                );
            }
            return lista;
        } catch (SQLException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    
    public Producto buscarProducto(String id) {

        Producto lista;
        lista = new Producto();
        try {
            super.query = "SELECT * FROM producto where id_pro='"+id+"'";
            super.st = (Statement) conectar().createStatement();
            super.rs = st.executeQuery(query);

            while (rs.next()) {
                lista.setCodigo(rs.getString("id_pro"));
                lista.setNombre(rs.getString("nombre_pro"));
                lista.setCategoria(rs.getString("categoria_pro"));
                lista.setDescripcion(rs.getString("descripcion_pro"));
                lista.setPeso(rs.getString("peso_pro"));
                lista.setPrecio(rs.getInt("precio_pro"));
                lista.setStock(rs.getInt("stock_pro"));
                lista.setUrl(rs.getString("url"));
            }
            return lista;
        } catch (SQLException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    
    public ArrayList buscarcomentarios(String id) {

        ArrayList lista;
        lista = new ArrayList();
        try {
            super.query = "SELECT * FROM valoracion where id_2pro='"+id+"' ORDER BY id_2pro ";
            super.st = (Statement) conectar().createStatement();
            super.rs = st.executeQuery(query);

            while (rs.next()) {
                lista.add(rs.getString("comentario"));
            }
            return lista;
        } catch (SQLException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    
    
    public Producto ProductoCarrito(String id) {

        Producto lista;
        lista = new Producto();
        try {
            super.query = "SELECT * FROM producto where id_pro='"+id+"'";
            super.st = (Statement) conectar().createStatement();
            super.rs = st.executeQuery(query);

            while (rs.next()) {
                lista.setCodigo(rs.getString("id_pro"));
                lista.setNombre(rs.getString("nombre_pro"));
                lista.setCategoria(rs.getString("categoria_pro"));
                lista.setDescripcion(rs.getString("descripcion_pro"));
                lista.setPeso(rs.getString("peso_pro"));
                lista.setPrecio(rs.getInt("precio_pro"));
                lista.setStock(rs.getInt("stock_pro"));
                lista.setUrl(rs.getString("url"));
            }
            return lista;
        } catch (SQLException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean confirmarstock(String id,int cantidad){
        
        try {
            super.query = "SELECT * FROM producto where id_pro='"+id+"'";
            super.st = (Statement) conectar().createStatement();
            super.rs = st.executeQuery(query);
            
            rs.next();
            return cantidad<=rs.getInt("stock_pro");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Crud_Producto.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public int venta(int total,String rut){
        
        try {
            super.query ="INSERT INTO venta VALUES (null,"+total+",'"+rut+"',CURDATE(),'pendiente','"+rut+"');";
            super.st = (Statement) conectar().createStatement();
            int i = st.executeUpdate(query,Statement.RETURN_GENERATED_KEYS);
            
            if(i==1){
            rs=st.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
            }
            
            return 0;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Crud_Producto.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    public int ProductoVenta(int venta,String codigo,int cantidad,int precio){
        
        super.query ="INSERT INTO detalle_venta VALUES ("+venta+", '"+codigo+"',"+cantidad+","+precio+")" ;
        try {
            super.st = (Statement) conectar().createStatement();
            super.resultado = st.executeUpdate(query);

        } catch (SQLException ex) {
            return 0;
        }
        
        if(resultado == 1){
            return 1;
            
        } else{
            return 0;
        }
     }
    
    public ArrayList<Venta> buscarPedido(String rut) {

        ArrayList<Venta> lista;
        lista = new ArrayList();
        try {
            super.query = "SELECT * FROM venta WHERE rut_2usuario='"+rut+"'";
            super.st = (Statement) conectar().createStatement();
            super.rs = st.executeQuery(query);

            while (rs.next()) {
                lista.add(new Venta(
                rs.getInt("id_venta"),
                rs.getInt("totales_venta"),
                rs.getString("cod_seguimiento"),
                rs.getString("fecha_venta"),
                rs.getString("estado"),
                rs.getString("rut_2usuario")));
            }
            return lista;
        } catch (SQLException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    public ArrayList<Producto> buscarPedidoProducto(int id_venta) {

        ArrayList<Producto> lista;
        lista = new ArrayList();
        try {
            super.query = "SELECT * FROM detalle_venta WHERE id_2venta="+id_venta+"";
            super.st = (Statement) conectar().createStatement();
            super.rs = st.executeQuery(query);

            while (rs.next()) {
                lista.add(new Producto(
                rs.getString("id_2pro"),
                rs.getInt("cantidad"),
                rs.getInt("precio")));
            }
            return lista;
        } catch (SQLException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
