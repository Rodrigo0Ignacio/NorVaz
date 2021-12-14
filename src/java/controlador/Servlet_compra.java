/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Entidad.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Crud_Producto;

/**
 *
 * @author felip
 */
@WebServlet(name = "Servlet_compra", urlPatterns = {"/Servlet_compra"})
public class Servlet_compra extends HttpServlet {

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
        if(request.getSession().getAttribute("rut")==null){
            request.setAttribute("error","Debe iniciar sesion para realizar un pedido");
            request.getRequestDispatcher("Carrito.jsp").forward(request, response);
        }
        Crud_Producto conex=new Crud_Producto();
        
        ArrayList<Producto> carrito=(ArrayList) request.getSession().getAttribute("carrito");
        
        for(int i=0;i<carrito.size();i++){
            if(conex.confirmarstock(carrito.get(i).getCodigo(), Integer.parseInt(request.getParameter("cantidad"+i+"")))){
                
            }else{
                request.setAttribute("error","Stock insuficiente de "+carrito.get(i).getNombre());
                request.getRequestDispatcher("Carrito.jsp").forward(request, response);
            }
            
        }
        int codigoventa=conex.venta(Integer.parseInt(request.getParameter("total")),
                (String)request.getSession().getAttribute("rut"));
        
        if(0<codigoventa){
            int confirmacion=0;
            for(int i=0;i<carrito.size();i++){
            
            confirmacion=conex.ProductoVenta(
                    codigoventa,
                    carrito.get(i).getCodigo(),
                    Integer.parseInt(request.getParameter("cantidad"+i+"")),
                    Integer.parseInt(request.getParameter("precio"+i+"")));
                if(confirmacion==0){
                    request.setAttribute("error","Pedido defectuoso, porfavor intentelo mas tarde ");
                    request.getRequestDispatcher("Carrito.jsp").forward(request, response);
                }
            }
            request.setAttribute("error","Su pedido a sido recibido");
            request.getRequestDispatcher("Ver_pedido.jsp").forward(request, response);
            
        }else{
           request.setAttribute("error","No se pudo concretar la venta, intentelo mas tarde");
                    request.getRequestDispatcher("Carrito.jsp").forward(request, response);
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet_compra</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet_compra at </h1>");
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
