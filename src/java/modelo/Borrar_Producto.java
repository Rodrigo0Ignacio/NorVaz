
package modelo;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Rodrigo
 */
public class Borrar_Producto extends Conexion{
    
      public int eliminarProduco (String codigo){
        super.query = "DELETE FROM producto WHERE id_pro = '"+codigo+"' ";
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
