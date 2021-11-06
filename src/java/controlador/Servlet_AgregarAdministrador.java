
package controlador;

import Entidad.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Crear_Administrador;

/**
 *
 * @author Rodrigo
 */
public class Servlet_AgregarAdministrador extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        ArrayList listaErrores = new ArrayList();
        Crear_Administrador admin = new Crear_Administrador();
        Usuario usuario1 = new Usuario();
        
        String rut = request.getParameter("txt_rut");
        String nombre = request.getParameter("txt_nombre");
        String apellidos = request.getParameter("txt_apellido");
        String email = request.getParameter("txt_email");
        String telefono = request.getParameter("txt_telefono");
        String pass1 = request.getParameter("txt_contrasena1");
        String pass2 = request.getParameter("txt_contrasena2");
        String boton = request.getParameter("btn_Registrar");
        
        
        if (boton != null) {

            if (rut == null || rut.equalsIgnoreCase("")) {
                listaErrores.add("El rut es obligatorio");
            }
            if (nombre == null || nombre.equalsIgnoreCase("")) {
                listaErrores.add("El nombre es obligatorio");
            }
            if (apellidos == null || apellidos.equalsIgnoreCase("")) {
                listaErrores.add("los apellidos son obligatorio");
            }
            if (email == null || email.equalsIgnoreCase("")) {
                listaErrores.add("El email es obligatorio");
            }
            if (telefono == null || telefono.equalsIgnoreCase("")) {
                listaErrores.add("El rut es obligatorio");
            }
            try {
                int converTelefono = Integer.parseInt(telefono);

            } catch (NumberFormatException e) {
                listaErrores.add("Solo se admiten valores numericos");
            }
            if (pass1 == null || pass1.equalsIgnoreCase("")) {
                listaErrores.add("Ingrese una contraseña");
            }
            if (pass2 == null || pass2.equalsIgnoreCase("")) {
                listaErrores.add("confirme contraseña");
            }
            if (!pass1.equalsIgnoreCase(pass2)) {
                listaErrores.add("La contraseña no coincide");
            }
            if (listaErrores.isEmpty()) {
                usuario1.setRut(rut);
                usuario1.setNombre(nombre);
                usuario1.setApellidos(apellidos);
                usuario1.setEmail(email);
                usuario1.setTelefono(telefono);
                usuario1.setContrasena(pass1);
                
                if(admin.RegistrarAdministrador(usuario1) == 1){
                    response.sendRedirect("Agregar-Administrador.jsp?value=1");
                }else{
                    response.sendRedirect("Agregar-Administrador.jsp?value=0");
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
