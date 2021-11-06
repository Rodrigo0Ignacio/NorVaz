
package modelo;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */

public class Leer_Email extends Conexion{
    
    // Comprueba si existe un correo en la base de datos.
    public int ComprobarCorreo(String correo){
        String verificaConsulta = "";
        
        super.query = "SELECT email FROM usuario WHERE email = '"+correo+"'";
        try {
            super.st = (Statement) conectar().createStatement();
            super.rs = st.executeQuery(query);

            if (rs.next()) {
                verificaConsulta = rs.getString("email");
            }

        } catch (SQLException ex) {    
           return 0; 
        }
        try {
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(Leer_Email.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(verificaConsulta.equalsIgnoreCase("")){
        return 0;
        
        } else{
            return 1;
        }
      
       
    }
       
       // SI EL CORREO COINCIDE SE MODIFICARA EL PASSWROD
       public int ModificarCorreo(String correo, String password){
           super.query = "update usuario set contraseNa = '"+password+"' where email ='"+correo+"'";
           
           try {
               super.st = (Statement) conectar().createStatement();
               super.resultado = st.executeUpdate(query);

           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "error al moodificar correo");
           }
        try {
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(Leer_Email.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           // si encuenta el correo arojara 1 y posteriormente crearemos la contraseña de numeros
          
           if (resultado == 1) {

                return 1;
               }
            else {
               return 0;
           }
        }
      
    
}
