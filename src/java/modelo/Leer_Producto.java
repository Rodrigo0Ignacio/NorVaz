
package modelo;

import Entidad.Producto;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Rodrigo
 */
public class Leer_Producto extends Conexion{
    
     public ArrayList<Producto> listarDatos(String codigo){
        ArrayList<Producto> lista = new ArrayList();
        
        try {
            super.query = "SELECT * FROM producto"
                    + " WHERE id_pro = '"+codigo+"'";

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
                        rs.getString("url")
                        
                ));
            }
            
         
        } catch (SQLException ex) {
            return null;

        }
        return lista;
    }
    
}
