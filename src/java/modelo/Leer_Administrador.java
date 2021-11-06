
package modelo;

import Entidad.Usuario;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Rodrigo
 */
public class Leer_Administrador extends Conexion{
    
    public ArrayList<Usuario> listarDatos(String rut){
        ArrayList<Usuario> lista = new ArrayList();
        
        try {
            super.query = "SELECT * FROM usuario"
                    + " WHERE rut = '"+rut+"'";

            super.st = (Statement) conectar().createStatement();
            super.rs = st.executeQuery(query);

            while (rs.next()) {
                lista.add(new Usuario(
                        rs.getInt("id_Usuario"),
                        rs.getString("rut"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("email"),
                        rs.getString("telefono")
                ));
            }
            
         
        } catch (SQLException ex) {
            return null;

        }
        return lista;
    }
    
}
