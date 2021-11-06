package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Email;
import modelo.Leer_Email;

/**
 *
 * @author Rodrigo
 */
public class Servlet_Email extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        ArrayList listaErrores = new ArrayList();
        Leer_Email verificaEmail = new Leer_Email();

        String correoReceptor = request.getParameter("email");
        String boton = request.getParameter("enviarCorreo");

        // GENERAR CLAVE ALEATORIA
        String claveAleatoria = UUID.randomUUID().toString().toUpperCase().substring(0, 15);

        // CONTENIDO DEL CORREO
        String asunto = "NorVaz - Restablecer contraseña";
        String contenido = "Tu clave es: " + claveAleatoria + "\n-------------------------------------------\n"
                + "Recomendamos al iniciar sesion cambiarla."
                + "\nSaludos cordiales.\n" + "\n-------------------------------------------\n"
                + "NorVaz Tu lo imaginas, nosotros lo creamos :)";

        // PREGUNTAMOS SI LAS VARIABLES ESTAN VACIAS
        if (boton != null) {
            if (correoReceptor != null) {
                if (verificaEmail.ComprobarCorreo(correoReceptor) == 1) {

                    verificaEmail.ModificarCorreo(correoReceptor, claveAleatoria);
                    
                    // creamos una instancia de la clase Email para enviar el correo
                    Email correo = new Email();
                    correo.EnviarEmail(correoReceptor, asunto, contenido);
                }
                

                response.sendRedirect("index.jsp");

            } else {
                response.sendRedirect("index.jsp");
            }
        } else {
            listaErrores.add("ingrese su email");
            response.sendRedirect("index.jsp");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Servlet_Email.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Servlet_Email.class.getName()).log(Level.SEVERE, null, ex);
        }
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
