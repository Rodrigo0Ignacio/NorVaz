
package controlador;
import Entidad.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Crear_Usuario;
import modelo.Leer_Usuario;

/**
 *
 * @author Rodrigo
 */
public class Servlet_InicioSesion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int advertencia = 0;
        ArrayList listaErrores = new ArrayList();
        Usuario usuario1 = new Usuario();
        Crear_Usuario valida = new Crear_Usuario();
        Leer_Usuario validaRoles = new Leer_Usuario();
        // SESION
        HttpSession sesion = request.getSession();

        //DATOS PARA REGISTRAR
        String nombre = request.getParameter("txt_regisNombre");
        String apellidos = request.getParameter("txt_regisApellido");
        String email = request.getParameter("txt_regisEmail");
        String rut = request.getParameter("txt_regisRut");
        String telefono = request.getParameter("txt_regisTelefono");
        String contrasena = request.getParameter("txt_regisConfirmaContrasena");
        String contrasena2 = request.getParameter("txt_regisContrasena");
        String botonRegistrar = request.getParameter("btn_Registrar");

        // DATOS PARA VALIDAR LA SESION
        String usuario = request.getParameter("txt_verificarUsuario");
        String contrasenau = request.getParameter("txt_verificarPassword");
        String botonIngresar = request.getParameter("btn_Validar");

        if (botonRegistrar != null) {

            
            if (listaErrores.isEmpty()) {

                usuario1.setNombre(nombre);
                usuario1.setApellidos(apellidos);
                usuario1.setEmail(email);
                usuario1.setRut(rut);
                usuario1.setTelefono(telefono);
                usuario1.setContrasena(contrasena);

                advertencia = valida.RegistrarUsuario(usuario1);
                response.sendRedirect("InicioSesion.jsp?validador=" + advertencia);
            }
        }
        
        if (botonIngresar != null) {

                if (usuario == null || contrasenau == null ) {
                    listaErrores.add("La contraseña o el usuario son incorrectos");
                    
                    request.setAttribute("listaErrores", listaErrores);
                    request.getRequestDispatcher("InicioSesion.jsp").forward(request, response);
                    
                }
               
                
                if (listaErrores.isEmpty()) {

                    usuario1.setEmail(usuario);
                    usuario1.setContrasena(contrasenau);

                    // llamamos a un metodo para capturar el nombre y el rut
                    validaRoles.listaRut(usuario1);

                    int rol = validaRoles.validarUsuarios(usuario1);

                    switch (rol) {
                        case 1:
                            // SESSIONES
                            sesion.setAttribute("usuario", usuario);
                            sesion.setAttribute("nombre", usuario1.getNombre());
                            sesion.setAttribute("rut", usuario1.getRut());
                            sesion.setAttribute("rol", rol);
                            response.sendRedirect("index.jsp");
                            break;

                        case 2:
                            sesion.setAttribute("usuario", usuario);
                            sesion.setAttribute("nombre", usuario1.getNombre());
                            sesion.setAttribute("rut", usuario1.getRut());
                            sesion.setAttribute("rol", rol);
                            response.sendRedirect("index.jsp");
                            break;

                        default:
                            listaErrores.add("Usuario no encontrado");
                           

                    }
                    
                }
            }
      

        
      
        
      
        
        
        
 
        
        
       
       
                
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
