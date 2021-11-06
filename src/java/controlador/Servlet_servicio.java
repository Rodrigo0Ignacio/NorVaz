
package controlador;

import Entidad.Servicio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Crear_Servicio;
import modelo.Email;

/**
 *
 * @author Rodrigo
 */
public class Servlet_servicio extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            ArrayList listaErrores = new ArrayList();
            Crear_Servicio creaServicio = new Crear_Servicio();
            Email correo = new Email();
            Servicio servi = new Servicio();
            int telefono = 0;
            String notificaCorreo = null;

            // capturamos los datos del formulario
            String rut = request.getParameter("rut");
            String servicio = request.getParameter("op_servicios");
            String poblacionVilla = request.getParameter("txt_poblacion_villa");
            String calle = request.getParameter("txt_calle");
            String nCasaDepartamento = request.getParameter("txt_NCasa");
            String descripcion = request.getParameter("textA_requerimiento");
            String emailReceptor = request.getParameter("email");
            String botonSolicitar = request.getParameter("btn_solicitar");
        
            
            // datos de correo
            String asunto = "Solicitud de Servicio recibida";
            String mensaje = "en un periodo maximo de 10 hrs, nos contactaremos con contigo";

            if (botonSolicitar != null) {

                if (poblacionVilla == null) {
                    listaErrores.add("Poblacion o villa es obligatorio");

                }
                if (calle == null) {
                    listaErrores.add("Calle es obligatorio");

                }
                if (nCasaDepartamento == null) {
                    listaErrores.add("N° de casa o deto, es obligatorio");

                }
                if (request.getParameter("txt_telefono") == null) {
                    listaErrores.add("Telefono es obligatorio");

                }
                // validamos que sea un numero de telefono, es decir un numero entero
                try {
                    telefono = Integer.parseInt(request.getParameter("txt_telefono"));
                } catch (NumberFormatException e) {
                    listaErrores.add("Solo se admiten valores numericos");
                }
                if (descripcion == null) {
                    listaErrores.add("es oblogatorio ingresar una descripcion");

                }
                if (listaErrores.isEmpty()) {

                    // pasamos el telefono a string
                    String cell = String.valueOf(telefono);

                    servi.setRut(rut);
                    servi.setTipo(servicio);
                    servi.setPoblacion(poblacionVilla);
                    servi.setCalle(calle);
                    servi.setNroHome(nCasaDepartamento);
                    servi.setTelefono(cell);
                    servi.setDescripcion(descripcion);

                    creaServicio.registrarServicio(servi);
                    
                    // enviamos el correo de confirmacion
                    notificaCorreo = correo.EnviarEmail(emailReceptor,asunto,mensaje);

                    response.sendRedirect("usuario-servicios.jsp");

                } else{
                    
                    response.sendRedirect("usuario-servicios?error.jsp");
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
