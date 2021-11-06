
package modelo;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Rodrigo
 */
public class Borrar_Administrador extends Conexion{
    
    public int eliminarUsuario (String rut){
        super.query = "DELETE FROM usuario WHERE rut = '"+rut+"' ";
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