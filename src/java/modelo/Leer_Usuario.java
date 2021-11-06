
package modelo;

import Entidad.Servicio;
import Entidad.Usuario;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author Rodrigo
 */
public class Leer_Usuario extends Conexion{
   
    // SI RETORNA UN 0 ES POR QUE NO SE ENCONTRO NINGUN NIVEL POR ENDE
    // EL USUARIO NO EXISTE
    public int validarUsuarios(Usuario usuario){
        int verificaConsulta = 0;
        
        try {
            super.query = "SELECT id_2roles FROM usuario WHERE email ='" + usuario.getEmail()
                    + "' AND contraseNa = '" + usuario.getContrasena() + "'";

            super.st = (Statement) conectar().createStatement();
            super.rs = st.executeQuery(query);

            if (rs.next()) {
                verificaConsulta = rs.getInt("id_2roles");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error verificaUsuario");
        }

        return verificaConsulta;

    }

    public int listarDatosUsuario(Usuario usuario){
        try {
            super.query = "SELECT * FROM usuario"
                    + " WHERE email = '" + usuario.getEmail() + "'";

            super.st = (Statement) conectar().createStatement();
            super.rs = st.executeQuery(query);

            while (rs.next()) {
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setEmail(rs.getString("email"));
                usuario.setTelefono(rs.getString("telefono"));
            }
            
         
        } catch (SQLException ex) {
            return 0;

        }
        return 1;
    }
    
    // este metodo cirve para obtener el nombre y el rut del usuario
    public int listaRut(Usuario usuario){
        try {
            super.query = "SELECT * FROM usuario"
                    + " WHERE email = '" + usuario.getEmail() + "'";

            super.st = (Statement) conectar().createStatement();
            super.rs = st.executeQuery(query);

            while (rs.next()) {
                usuario.setNombre(rs.getString("nombre"));
                usuario.setRut(rs.getString("rut"));
            }
        } catch (SQLException ex) {
            return 0;

        }
        return 1;
    }

  
}
