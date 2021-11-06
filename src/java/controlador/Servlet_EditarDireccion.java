package controlador;

import Entidad.Direccion;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.crud_Direccion;

/**
 *
 * @author Rodrigo
 */
@WebServlet(name = "Servlet_EditarDireccion", urlPatterns = {"/Servlet_EditarDireccion"})
public class Servlet_EditarDireccion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        ArrayList listaErrores = new ArrayList();
        crud_Direccion direccion = new crud_Direccion();
        Direccion direc1 = new Direccion();

        String region = request.getParameter("region");
        String comuna = request.getParameter("txt_comuna");
        String calle = request.getParameter("calle");
        String nrocalle = request.getParameter("nrocalle");
        String nrocasa = request.getParameter("nrocasa");
        String btn_agregar = request.getParameter("agregar");
        String btn_editar = request.getParameter("editar");
        String btn_eliminar = request.getParameter("eliminar");
        String rut = request.getParameter("rut");

        if (btn_agregar != null) {
            if (region == null || region.equalsIgnoreCase("Seleccione una region")) {
                listaErrores.add("Seleccione una region");
            }
            if (comuna == null || comuna.equalsIgnoreCase("")) {
                listaErrores.add("Ingrese una comuna");
            }
            if (calle == null || calle.equalsIgnoreCase("")) {
                listaErrores.add("Ingrese una calle");
            }
            if (nrocalle == null || nrocalle.equalsIgnoreCase("")) {
                listaErrores.add("Ingrese un Nro de calle");
            }
            if (nrocasa == null || nrocasa.equalsIgnoreCase("")) {
                listaErrores.add("Ingrese un Nro de casa o departamento");
            }
            if (listaErrores.isEmpty()) {
                direc1.setRegion(region);
                direc1.setComuna(comuna);
                direc1.setCalle(calle);
                direc1.setNroCalle(nrocalle);
                direc1.setNroCasa(nrocasa);
                direc1.setRut(rut);

                if (direccion.RegistrarDireccion(direc1) == 1) {
                    response.sendRedirect("agregar-direccion.jsp?value=true");
                } else {
                    response.sendRedirect("agregar-direccion.jsp?value=false");
                }

            } else {
                request.setAttribute("listaErrores", listaErrores);
                request.getRequestDispatcher("editar-direccion.jsp").forward(request, response);
            }

        }
        
        // CODIGO DE LA VISTA VER_DIRECCION.JSP
        if (btn_editar != null) {
            if (region == null || region.equalsIgnoreCase("Seleccione una region")) {
                listaErrores.add("Seleccione una region");
            }
            if (comuna == null || comuna.equalsIgnoreCase("")) {
                listaErrores.add("Ingrese una comuna");
            }
            if (calle == null || calle.equalsIgnoreCase("")) {
                listaErrores.add("Ingrese una calle");
            }
            if (nrocalle == null || nrocalle.equalsIgnoreCase("")) {
                listaErrores.add("Ingrese un Nro de calle");
            }
            if (nrocasa == null || nrocasa.equalsIgnoreCase("")) {
                listaErrores.add("Ingrese un Nro de casa o departamento");
            }
            if (listaErrores.isEmpty()) {
                direc1.setRegion(region);
                direc1.setComuna(comuna);
                direc1.setCalle(calle);
                direc1.setNroCalle(nrocalle);
                direc1.setNroCasa(nrocasa);
                direc1.setRut(rut);

                if (direccion.EditarDireccion(direc1) == 1) {
                    response.sendRedirect("ver_direccion.jsp?value=true");
                } else {
                    response.sendRedirect("ver_direccion.jsp.jsp?value=false");
                }

            } else {
                request.setAttribute("listaErrores", listaErrores);
                request.getRequestDispatcher("ver_direccion.jsp").forward(request, response);
            }
        }
            
            if (btn_eliminar != null) {
               if(direccion.eliminarDireccion(rut) == 1){
                   response.sendRedirect("ver_direccion.jsp?value=true");
               }else{
                   response.sendRedirect("ver_direccion.jsp?value=false");
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

