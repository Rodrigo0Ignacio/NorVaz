
package modelo;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class Conexion {
    public Connection con = null;
    public Statement st = null;
    public ResultSet rs = null;
    public String query = null;
    public int resultado = 0;
    public boolean errorDesconeccion = false;

    public Conexion() {
    }
    

 public Connection conectar() {
       try {
            Class.forName("com.mysql.jdbc.Driver");
            
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/norvaz?zeroDateTimeBehavior=convertToNull","root","");
                
            } catch (ClassNotFoundException | SQLException ex ) { 
               errorDesconeccion = true;
            }        
            return con; 
  }
 
 protected void desconectar(){   
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
 }

    
}

