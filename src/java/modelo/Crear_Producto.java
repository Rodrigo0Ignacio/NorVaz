
package modelo;

import Entidad.Producto;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Rodrigo
 */
public class Crear_Producto extends Conexion{
    
    
     public int ingresarProducto(Producto producto){
        super.query ="INSERT INTO producto VALUES('"+producto.getCodigo()+"',"
                + "'"+producto.getNombre()+"',"+producto.getStock()+","+producto.getPrecio()+
                ",'"+producto.getPeso()+"','"+producto.getCategoria()+
                "','"+producto.getDescripcion()+"','"+producto.getUrl()+"')" ;
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
}
    
