
package modelo;


import Entidad.Producto;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class Actualizar_Producto extends Conexion{
    
     public int ActualizarProducto(Producto pro) {

        super.query = "update producto SET id_pro = '"+pro.getCodigo()+"', nombre_pro = '"+pro.getNombre()+"',"
                + " stock_pro = "+pro.getStock()+" , precio_pro = "+pro.getPrecio()+","
                + " peso_pro = '"+pro.getPeso()+"', categoria_pro = '"+pro.getCategoria()+"',"
                + " descripcion_pro = '"+pro.getDescripcion()+"', url = '"+pro.getUrl()+"'"
                + " WHERE id_pro = '"+pro.getCodigo()+"'";
        try {
            super.st = (Statement) conectar().createStatement();
            st.executeUpdate(query);
            
            st.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al actualizar los datos");
            return 0;
        }
        return 1;

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
