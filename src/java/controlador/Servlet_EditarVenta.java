/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Crud_Venta;

/**
 *
 * @author felip
 */
@WebServlet(name = "Servlet_EditarVenta", urlPatterns = {"/Servlet_EditarVenta"})
public class Servlet_EditarVenta extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Crud_Venta crud = new Crud_Venta();
        
        String id = request.getParameter("id");
        String rut = request.getParameter("rut");
        String estado = request.getParameter("estadoe");
        String btn_editar = request.getParameter("editar");
        String btn_eliminar = request.getParameter("eliminar");
        String btn_detallesVenta = request.getParameter("detalles");
        
        
        if(btn_editar != null){
            crud.CambiarEstado(id, estado);
            response.sendRedirect("ver-estado.jsp");
        }
        if(btn_eliminar != null){
            crud.EliminarEstado(rut, id);
            response.sendRedirect("ver-estado.jsp");
        }
        if(btn_detallesVenta != null){
          response.sendRedirect("DetallesDeVenta.jsp?dato="+id);
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet_EditarVenta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet_EditarVenta at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
