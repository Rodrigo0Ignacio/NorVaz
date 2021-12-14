
package modelo;

import Entidad.Servicio;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class Crear_Servicio extends Conexion{
    
    
   public int registrarServicio(Servicio servicio){
       String fechaActual = Fecha.fechaActual(); // retorna la fecha actual
       
        super.query = "INSERT INTO servicio VALUES('"+ servicio.getRut()+"','"+ servicio.getTipo()+"','"
                +servicio.getPoblacion()+"','"+servicio.getCalle()+
                "','"+servicio.getNroHome()+"','"+servicio.getTelefono()+"','"+fechaActual+"','"+servicio.getDescripcion()+"')";
        try {
            super.st = (Statement) conectar().createStatement();
            super.resultado = st.executeUpdate(query);

        } catch (SQLException ex) {
           return 0;
        }
        
        //desconectar();
        
        if(resultado == 1){
            return 1;
            
        } else{
            return 0;
        }
    
    }
    
    
    
}
