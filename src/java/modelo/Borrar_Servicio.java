
package modelo;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Rodrigo
 */
public class Borrar_Servicio extends Conexion{
    
     public int eliminarServicio (String rut){
        super.query = "DELETE FROM servicio WHERE rut_2usuario = '"+rut+"' ";
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