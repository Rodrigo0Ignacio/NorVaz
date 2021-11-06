package controlador;

import Entidad.Producto;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Crear_Producto;

/**
 *
 * @author Rodrigo
 */
public class Servlet_AgregarProducto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        ArrayList listaErrores = new ArrayList();
        Producto producto1 = new Producto();
        Crear_Producto ingresaPro = new Crear_Producto();
        int stockI = 0;
        int precioI = 0;

        String id = request.getParameter("txt_code");
        String nombre = request.getParameter("txt_nombre");
        String peso = request.getParameter("txt_peso");
        String categoria = request.getParameter("categoria");
        String descripcion = request.getParameter("descripcion");

        String stock = request.getParameter("txt_stock");
        String presio = request.getParameter("txt_precio");

        String url = request.getParameter("img");
        String boton = request.getParameter("btn_regisProducto");

        if (boton != null) {

            if (id == null || id.equalsIgnoreCase("")) {
                listaErrores.add("El codigo de producto es obligatorio");

            }
            if (nombre == null || nombre.equalsIgnoreCase("")) {
                listaErrores.add("El nombre de producto es obligatorio");
            }

            if (stock == null || stock.equalsIgnoreCase("")) {
                listaErrores.add("El stock es obligatorio");

            }
            if (presio == null || presio.equalsIgnoreCase("")) {
                listaErrores.add("El presio es obligatorio");

            }
            if (peso == null || peso.equalsIgnoreCase("")) {
                listaErrores.add("El peso es obligatorio");

            }
            if (categoria == null || categoria.equalsIgnoreCase("Seleccione una categoria")) {
                listaErrores.add("seleccione una categoria validad");

            }
            if (descripcion == null || descripcion.equalsIgnoreCase("")) {
                listaErrores.add("Ingrese una descripcion");

            }

            try {
                stockI = Integer.parseInt(stock);
                precioI = Integer.parseInt(presio);

                if (stockI <= 0) {
                    listaErrores.add("El stock no puede ser 0");
                }
                if (precioI <= 500) {
                    listaErrores.add("El presio no puede ser inferior a 500");
                }

            } catch (NumberFormatException e) {
                listaErrores.add("Ingrese valores numericos");

            }

            if (listaErrores.isEmpty()) {

                producto1.setCodigo(id);
                producto1.setNombre(nombre);
                producto1.setStock(stockI);
                producto1.setPrecio(precioI);
                producto1.setPeso(peso);
                producto1.setCategoria(categoria);
                producto1.setDescripcion(descripcion);
                producto1.setUrl(url);

                if (ingresaPro.ingresarProducto(producto1) == 1) {
                    response.sendRedirect("Administrador-IngresarProducto.jsp?value=true");
                } else {
                    response.sendRedirect("Administrador-IngresarProducto.jsp?value=false");
                }
            } else {
                request.setAttribute("listaErrores", listaErrores);
                request.getRequestDispatcher("Administrador-IngresarProducto.jsp").forward(request, response);

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
