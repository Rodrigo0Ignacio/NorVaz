
package modelo;

import Entidad.Usuario;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Rodrigo
 */
public class Crear_Administrador extends Conexion{
    
    public int RegistrarAdministrador(Usuario usuario){
        super.query = "INSERT INTO usuario VALUES(NULL,'"+usuario.getRut()+"','"+usuario.getNombre()+"','"
                +usuario.getApellidos()+"','"+usuario.getEmail()+"','"+usuario.getTelefono()+"','"+
                usuario.getContrasena()+"',2)";
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
