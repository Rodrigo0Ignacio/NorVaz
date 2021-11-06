
package modelo;

import Entidad.Usuario;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class Actualizar_Administrador extends Conexion{
    
    
    public int ActualizarDatosAdmin(Usuario usuario) {

        super.query = "UPDATE usuario SET rut = '" + usuario.getRut() + "', nombre = '" + usuario.getNombre() + "',"
                + " apellidos = '" + usuario.getApellidos() + "',"
                + " email = '" + usuario.getEmail() + "', telefono = '" + usuario.getTelefono()
                + "' WHERE id_Usuario = " + usuario.getId_usuario() + "";
        try {
            super.st = (Statement) conectar().createStatement();
            st.executeUpdate(query);

            st.close();
            desconectar();

        } catch (SQLException ex) {
         
           return 0;
        }
        return 1;

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
