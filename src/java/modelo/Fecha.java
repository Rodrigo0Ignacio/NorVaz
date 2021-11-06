
package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Rodrigo
 */
public class Fecha {
    public static String fechaActual(){
        
        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
        
        return formato.format(fecha);  
    } 
    
}
