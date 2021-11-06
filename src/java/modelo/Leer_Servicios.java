package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Rodrigo
 */
public class Leer_Servicios extends Conexion {

    public ResultSet listarDatosUsuario(){
        
        try {
            super.query = "SELECT * FROM servicio";

            super.st = (Statement) conectar().createStatement();
            super.rs = st.executeQuery(query);

                
            } catch (SQLException ex) {
            return null;

        }
        return rs;
    
    }
}
    
    
    
    
    
    
    
    
    
    
    
    

