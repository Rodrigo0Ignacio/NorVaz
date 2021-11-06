
package modelo;

import Entidad.Usuario;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class Actualizar_Usuario extends Conexion {

    public int actualizarPassword(Usuario usuario) {
        super.query = "update usuario set contraseNa = '" + usuario.getContrasena()
                + "' where email ='" + usuario.getEmail() + "'";

        try {
            super.st = (Statement) conectar().createStatement();
            st.executeUpdate(query);
            
            st.close();

        } catch (SQLException ex) {
            return 0;
        }
        return 1;
    }

    public int ActualizarDatos(Usuario usuario) {

        super.query = "update usuario set nombre = '" + usuario.getNombre()+
                "' ,apellidos = '" + usuario.getApellidos()+
                "', email = '" + usuario.getEmail() + "', telefono = '" +
                usuario.getTelefono()+ "' WHERE rut = '" + usuario.getRut() + "'";
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
