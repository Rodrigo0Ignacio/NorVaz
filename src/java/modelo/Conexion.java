
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
    /*CONEXION*/
    private String punto_de_enlace = "jdbc:mysql://localhost:3306/norvas";
    private String user = "root";
    private String password = "";

    public Conexion() {
    }
    

 public Connection conectar() {
       try {
            Class.forName("com.mysql.jdbc.Driver");
            
                con = DriverManager.getConnection(punto_de_enlace,user,password);
                
            } catch (ClassNotFoundException | SQLException ex ) { 
               /*JOptionPane.showMessageDialog(null,"Error al conectar la BD: "+ex);*/
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

