package controlador;

import Entidad.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Actualizar_Usuario;

/**
 *
 * @author Rodrigo
 */
public class Servlet_usuario_Editar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Usuario usuario1 = new Usuario();
        Actualizar_Usuario actualiza = new Actualizar_Usuario();
        ArrayList listaErrores = new ArrayList();
        int telefono = 0;
        int verifica = 0;
        String mensaje = null;

        //CAPTURAMOS los datos de restablecer password
        String restablecerPass = request.getParameter("btn_restablecer");
        String contrasena1 = request.getParameter("txt_password1");
        String contrasena2 = request.getParameter("txt_password2");
        String correo = request.getParameter("txt_correo");

        // capturamos los datos de editar datos
        String restablecerDatos = request.getParameter("btn_Registrar");
        String nombre = request.getParameter("txt_camNombre");
        String apellido = request.getParameter("txt_camApellido");
        String email1 = request.getParameter("txt_camEmail1");
        String email2 = request.getParameter("txt_camEmail2");
        String rut = request.getParameter("rut");

        // cambiar contraseña
        if (restablecerPass != null) {

            if (listaErrores.isEmpty()) {
                // pasamos los datos al beans
                usuario1.setContrasena(contrasena1);
                usuario1.setEmail(correo);

                // capturamos lo que arroja el metodo 
                verifica = actualiza.actualizarPassword(usuario1);

                if (verifica == 1) {
                   response.sendRedirect("usuario-Editar.jsp?value=1");

                } else {
                    response.sendRedirect("usuario-Editar.jsp?value=0");
                }

            }

        }

        // datos para editar
        if (restablecerDatos != null) {

            // valida si el telefono es numerico
            try {
                telefono = Integer.parseInt(request.getParameter("txt_camTelefono"));

            } catch (NumberFormatException e) {
                listaErrores.add("Solo se admiten valores numericos");
            }

            if (nombre == null) {
                listaErrores.add("Ingrese su nombre");
            }
            if (apellido == null) {
                listaErrores.add("Ingrese sus apellios ");

            }
            if (email1 == null && email2 == null) {
                listaErrores.add("Ingrese un Email");

            }
            if (!email1.equalsIgnoreCase(email2)) {
                listaErrores.add("El Email no coincide");
            }
            if (String.valueOf(telefono) == null) {
                listaErrores.add("Ingrese un numero celular");
            }
            
            String telefonocambiado = String.valueOf(telefono).trim();

            if (listaErrores.isEmpty()) {
                usuario1.setRut(rut);
                usuario1.setNombre(nombre);
                usuario1.setApellidos(apellido);
                usuario1.setEmail(email2);
                usuario1.setTelefono(telefonocambiado);
                
                // capturamos lo que arroja el metodo al actualizar los datos
                verifica = actualiza.ActualizarDatos(usuario1);
                
                if (verifica == 1) {
                    response.sendRedirect("usuario-Editar.jsp?verifica=1");
                   
                } else {
                  response.sendRedirect("usuario-Editar.jsp?verifica=0");
                    

                    /* codigo de metodos*/
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
