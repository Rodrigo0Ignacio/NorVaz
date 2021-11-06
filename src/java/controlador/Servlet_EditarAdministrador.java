package controlador;

import Entidad.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Actualizar_Administrador;
import modelo.Borrar_Administrador;
import modelo.Leer_Administrador;

/**
 *
 * @author Rodrigo
 */
public class Servlet_EditarAdministrador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        ArrayList listaErrores = new ArrayList();
        Leer_Administrador buscaradmin = new Leer_Administrador();
        Actualizar_Administrador actualizaAdmin = new Actualizar_Administrador();
        Borrar_Administrador borrarAdmin = new Borrar_Administrador();

        Usuario usuario1 = new Usuario();
        int telefonoI = 0;
        int idI = 0;
        
        String buscarRut = request.getParameter("txt_rut");
        String buscar = request.getParameter("btn_buscar");

        String id = request.getParameter("id");
        String rut = request.getParameter("txt_rutM");
        String nombre = request.getParameter("txt_nombreM");
        String apellidos = request.getParameter("txt_apellidoM");
        String email = request.getParameter("txt_emailM");
        String telefono = request.getParameter("txt_telefonoM");

        String editar = request.getParameter("btn_editar");
        String eliminar = request.getParameter("btn_eliminar");

        // ACCIONES DE BOTON BUSCAR UN RUT
        if (buscar != null) {
            if (buscarRut == null || buscarRut.equalsIgnoreCase("")) {
                listaErrores.add("Ingrese un rut valido");
            }
            if (listaErrores.isEmpty()) {
                ArrayList<Usuario> lista = buscaradmin.listarDatos(buscarRut);

                boolean ocultarForm = true;

                request.setAttribute("lista", lista);
                request.setAttribute("ocultarForm", ocultarForm);
                request.getRequestDispatcher("editar-cuenta-administrador.jsp").forward(request, response);

            }

        }
        // ACCIONES DE BOTON EDITAR
        if (editar != null) {
            if (id == null || id.equalsIgnoreCase("")) {
                listaErrores.add("id envialido");
            }
            if (rut == null || rut.equalsIgnoreCase("")) {
                listaErrores.add("Ingrese un rut valido");
            }
            if (nombre == null || nombre.equalsIgnoreCase("")) {
                listaErrores.add("Ingrese un nombre valido");
            }
            if (apellidos == null || apellidos.equalsIgnoreCase("")) {
                listaErrores.add("Ingrese Apellidos valido");
            }
            if (email == null || email.equalsIgnoreCase("")) {
                listaErrores.add("Ingrese un email valido");
            }
            if (telefono == null || telefono.equalsIgnoreCase("")) {
                listaErrores.add("Ingrese un telefono valido");
            }
            try {
                telefonoI = Integer.parseInt(telefono);

            } catch (NumberFormatException e) {
                listaErrores.add("Solo se admiten datos numericos");

            }
            if (listaErrores.isEmpty()) {
                idI = Integer.parseInt(id);

                usuario1.setId_usuario(idI);
                usuario1.setRut(rut);
                usuario1.setNombre(nombre);
                usuario1.setApellidos(apellidos);
                usuario1.setEmail(email);
                usuario1.setTelefono(telefono);

                if (actualizaAdmin.ActualizarDatosAdmin(usuario1) == 1) {

                    response.sendRedirect("editar-cuenta-administrador.jsp?value=true");
                } else {
                    response.sendRedirect("editar-cuenta-administrador.jsp?value=false");
                }

            }

        }
        // ACCIONES DE BOTON ELIMINAR

        if (eliminar != null) {
            if (rut == null || rut.equalsIgnoreCase("")) {
                listaErrores.add("Ingrese un rut valido");
            }
            if (listaErrores.isEmpty()) {

                if (borrarAdmin.eliminarUsuario(rut) == 1) {
                    response.sendRedirect("editar-cuenta-administrador.jsp?value=true");
                } else {
                    response.sendRedirect("editar-cuenta-administrador.jsp?value=false");
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
