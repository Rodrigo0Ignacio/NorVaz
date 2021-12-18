
package modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Rodrigo
 */
public class Crud_Venta extends Conexion{
    
    public ResultSet listarVentas(){
        try {
            super.query = "SELECT * FROM venta";

            super.st = (Statement) conectar().createStatement();
            rs = st.executeQuery(query);

         
        } catch (SQLException ex) {
            return null;

        }
        return rs;

}
    public int CambiarEstado(String id, String estado) {
        try {
            super.query = "UPDATE venta SET estado = '" + estado + "' WHERE id_venta = " + id + "";

            super.st = (Statement) conectar().createStatement();
            st.executeUpdate(query);

        } catch (SQLException ex) {
            return 0;

        }
        return 0;

}
    
     public int EliminarEstado(String rut, String id) {
        try {
            super.query = "DELETE FROM venta WHERE rut_2usuario = '"+rut+"' AND id_venta ="+id+"";

            super.st = (Statement) conectar().createStatement();
            st.executeUpdate(query);

            st.close();
            desconectar();
        } catch (SQLException ex) {
            return 0;

        }
        return 0;

}
     
     // DETALLES DE LA VENTA
     
     
       public ResultSet listarDetalles(String id){
        try {
            super.query = "select * from detalle_venta "
                    + "INNER JOIN producto ON detalle_venta.id_2pro = producto.id_pro"
                    + " WHERE detalle_venta.id_2venta = "+id+"";

            super.st = (Statement) conectar().createStatement();
            rs = st.executeQuery(query);

         
        } catch (SQLException ex) {
            return null;

        }
        return rs;

}
    public String listarEmail(String rut) {
        String email = null;
        try {
            super.query = "select email from usuario WHERE rut = '" + rut + "'";

            super.st = (Statement) conectar().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                email = rs.getString("email");

            }

        } catch (SQLException ex) {
            return null;

        }
        return email;

}
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}