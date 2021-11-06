package modelo;

import Entidad.Direccion;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class crud_Direccion extends Conexion {

    public int RegistrarDireccion(Direccion dir) {

        super.query = "INSERT INTO direccion VALUES('" + dir.getRegion()
                + "','" + dir.getComuna() + "','" + dir.getCalle() + "','"
                + dir.getNroCalle() + "','" + dir.getNroCasa() + "','" + dir.getRut() + "')";
        try {
            super.st = (Statement) conectar().createStatement();
            super.resultado = st.executeUpdate(query);

        } catch (SQLException ex) {
            return 0;
        }

        desconectar();

        if (resultado == 1) {
            return 1;

        } else {
            return 0;
        }

    }

    public int EditarDireccion(Direccion dir) {

        super.query = "UPDATE direccion SET region = '" + dir.getRegion()
                + "', comuna = '" + dir.getComuna() + "'"
                + ", calle = '" + dir.getCalle() + "', nroCalle = '" + dir.getNroCalle()
                + "', nro_casaODepa = '" + dir.getNroCasa() + "'"
                + " WHERE rut_2usuarioD = '" + dir.getRut() + "'";
        try {
            super.st = (Statement) conectar().createStatement();
            super.resultado = st.executeUpdate(query);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar un servicio");
        }

        desconectar();

        if (resultado == 1) {
            return 1;

        } else {
            return 0;
        }

    }

    public ArrayList<Direccion> VerificarDireccion(String rut) {

        ArrayList<Direccion> listaDatos = new ArrayList();
        super.query = "SELECT * FROM direccion WHERE rut_2usuarioD ='" + rut + "'";
        try {
            super.st = (Statement) conectar().createStatement();
            super.rs = st.executeQuery(query);

            while (rs.next()) {
                listaDatos.add(new Direccion(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)));

            }
            st.close();
            desconectar();

        } catch (SQLException ex) {
            return null;
        }
        return listaDatos;

    }

    public int eliminarDireccion(String rut) {
        super.query = "DELETE FROM direccion WHERE rut_2usuarioD ='" + rut + "'";
        try {
            super.st = (Statement) conectar().createStatement();
            super.resultado = st.executeUpdate(query);

            desconectar();
            st.close();
        } catch (SQLException ex) {
            return 0;
        }
        if (resultado == 1) {
            return 1;

        } else {
            return 0;
        }

    }


    
    
    
    
    
    
    
    
    
    
    
    
    


}
