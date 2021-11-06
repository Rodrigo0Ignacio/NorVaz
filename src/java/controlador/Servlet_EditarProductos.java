package controlador;

import Entidad.Producto;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Actualizar_Producto;
import modelo.Borrar_Producto;
import modelo.Leer_Producto;

/**
 *
 * @author Rodrigo
 */
public class Servlet_EditarProductos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        ArrayList listaErrores = new ArrayList();
        Leer_Producto listar = new Leer_Producto();
        Borrar_Producto borrar = new Borrar_Producto();
        Actualizar_Producto actualizar = new Actualizar_Producto();
        
        Producto producto1 = new Producto();
        int stockI = 0;
        int precioI = 0;

        String buscarId = request.getParameter("txt_code");
        String botonBuscar = request.getParameter("btn_buscar");

        String codigo = request.getParameter("txt_code");
        String nombre = request.getParameter("txt_nombre");
        String stock = request.getParameter("txt_stock");
        String precio = request.getParameter("txt_precio");
        String peso = request.getParameter("txt_peso");
        String categoria = request.getParameter("categoria");
        String descripcion = request.getParameter("descripcion");
        String imagen = request.getParameter("img");

        String botonEditar = request.getParameter("btn_editar");
        String botonEliminar = request.getParameter("btn_eliminar");

        // ACCIONES DE BOTON PRODUCTO
        if (botonBuscar != null) {
            if (buscarId == null || buscarId.equalsIgnoreCase("")) {
                listaErrores.add("Codigo invalido");
            }
            if (listaErrores.isEmpty()) {
                ArrayList<Producto> lista = listar.listarDatos(buscarId);

                boolean ocultarForm = true;

                request.setAttribute("lista", lista);
                request.setAttribute("ocultarForm", ocultarForm);
                request.getRequestDispatcher("editarProducto.jsp").forward(request, response);

            }

        }
        //ACCION ELIMINAR
        if (botonEliminar != null) {
            if (codigo == null || codigo.equalsIgnoreCase("")) {
                listaErrores.add("Ingrese un codigo de producto valido");
            }
            if(listaErrores.isEmpty()){
            if (borrar.eliminarProduco(codigo) == 1) {
                response.sendRedirect("editarProducto.jsp?value=true");
            } else {
                response.sendRedirect("editarProducto.jsp?value=false");
            }
            } else{
                request.setAttribute("listaErrores", listaErrores);
                request.getRequestDispatcher("editarProducto.jsp").forward(request, response);
                
            }

        }

        //ACCION EDITAR
        if (botonEditar != null) {
            if (codigo == null || codigo.equalsIgnoreCase("")) {
                listaErrores.add("Ingrese un codigo de producto valido");
            }
            if (nombre == null || nombre.equalsIgnoreCase("")) {
                listaErrores.add("Ingrese un nombre valido");
            }
            if (stock == null || stock.equalsIgnoreCase("")) {
                listaErrores.add("Ingrese un stock valido");
            }
            if (precio == null || precio.equalsIgnoreCase("")) {
                listaErrores.add("Ingrese un precio valido");
            }
            if (peso == null || peso.equalsIgnoreCase("")) {
                listaErrores.add("Ingrese un peso valido");
            }
            if (categoria == null || categoria.equalsIgnoreCase("")) {
                listaErrores.add("Ingrese un categoria valido");
            }
            if (descripcion == null || descripcion.equalsIgnoreCase("")) {
                listaErrores.add("Ingrese un descripcion valido");
            }
            try {
                stockI = Integer.parseInt(stock);
                precioI = Integer.parseInt(precio);

                if (stockI <= 0) {
                    listaErrores.add("El stock no puede ser 0");
                }
                if (precioI <= 500) {
                    listaErrores.add("El presio no puede ser inferior a 500");
                }

            } catch (NumberFormatException e) {
                listaErrores.add("Ingrese valores numericos");

            }
            
            if(listaErrores.isEmpty()){
                producto1.setCodigo(codigo);
                producto1.setNombre(nombre);
                producto1.setStock(stockI);
                producto1.setPrecio(precioI);
                producto1.setPeso(peso);
                producto1.setCategoria(categoria);
                producto1.setDescripcion(descripcion);
                producto1.setUrl(imagen);
                
                if(actualizar.ActualizarProducto(producto1) == 1){
                    response.sendRedirect("editarProducto.jsp?value=true");
                }else{
                     response.sendRedirect("editarProducto.jsp?value=false");
                }  
            }else{
                request.setAttribute("listaErrores", listaErrores);
                request.getRequestDispatcher("editarProducto.jsp").forward(request, response);
                
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
