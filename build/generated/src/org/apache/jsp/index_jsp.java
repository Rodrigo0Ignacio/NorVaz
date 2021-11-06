package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Producto;
import modelo.Crud_Producto;
import java.util.ArrayList;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    HttpSession sesion = request.getSession();
    /* capturamos la sesion del usuario*/
    String usuario = null;
    String rut = null;
    String nombre = null;
    String rol = "0";
    String estiloU = null;
    String estiloA = null;
    String sesionIniciada = null;
    String sinSesion = null;

    Crud_Producto product = new Crud_Producto();
    ArrayList<Producto> cProductos = product.ListarCategoria();
    
    if (sesion.getAttribute("rol") != null && sesion.getAttribute("usuario") != null) {
        rol = sesion.getAttribute("rol").toString();
        usuario = sesion.getAttribute("usuario").toString();
        nombre = sesion.getAttribute("nombre").toString();
        rut = sesion.getAttribute("rut").toString();
    }

// CIERRA UNA SESION
    if (request.getParameter("cerrar") != null) {
        sesion.invalidate();
        response.sendRedirect("index.jsp");
    }

    switch (rol) {
        case "1":
            estiloA = "style=\"display: none\"";
            sinSesion = "style=\"display: none\"";
            break;

        case "2":
            estiloU = "style=\"display: none\"";
            sinSesion = "style=\"display: none\"";
            break;

        default:
            estiloU = "style=\"display: none\"";
            estiloA = "style=\"display: none\"";
            sesionIniciada = "style=\"display: none\"";
    }


      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"css/Index-estilos.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>NorVaz</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("\n");
      out.write("        <div id=\"contenedor\">\n");
      out.write("            <div id=\"header\">\n");
      out.write("\n");
      out.write("                <div id=\"logo\">\n");
      out.write("                    <img src=\"img/logo_destornillador.PNG\" alt=\"\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div id=\"CuentaUser\">\n");
      out.write("                    <ul>\n");
      out.write("                        <li><img class=\"central\" src=\"img/usuario.png\" alt=\"\"></li>\n");
      out.write("                    </ul>\n");
      out.write("                    <!--APARTADO DE OPCIONES DE SESION (USUARIO)-->\n");
      out.write("                    <ul ");
      out.print(sesionIniciada);
      out.write(" >\n");
      out.write("                        <li><a href=\"InicioSesion.jsp\"> Bienvenid@ ");
      out.print(nombre);
      out.write(" </a></li>\n");
      out.write("                        <li><a href=\"index.jsp?cerrar=true\">Cerrar Sesion</a></li>\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("                    <ul ");
      out.print(sinSesion);
      out.write(" >\n");
      out.write("                        <li><a href=\"InicioSesion.jsp\"> Iniciar Sesion</a></li>\n");
      out.write("                        <li><a href=\"InicioSesion.jsp\"> Crear una cuenta</a></li>\n");
      out.write("                        <li><a href=\"javascript:abrir()\"> olvidaste tu contraseña</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <!--ESTE SUB MENU PERTENECE AL USUARIO-->\n");
      out.write("            <div id=\"nav2\" ");
      out.print( estiloU);
      out.write("  >\n");
      out.write("                <nav class=\"navegacion2\">\n");
      out.write("                    <ul class=\"menu2\">\n");
      out.write("\n");
      out.write("                        <li><a href=\"usuario-Editar.jsp\"> Editar Perfil </a></li>\n");
      out.write("                        <li><a href=\"agregar-direccion.jsp\"> Agregar Una Direccion </a></li>\n");
      out.write("                        <li><a href=\"ver_direccion.jsp\"> Ver direccion </a></li>\n");
      out.write("                        <li><a href=\"Ver_pedido.jsp\"> Ver pedido </a></li>\n");
      out.write("                        <li><a href=\"Carrito.jsp\"> <img src=\"img/carrito.png\"> ver carrito </a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </nav>\n");
      out.write("            </div> \n");
      out.write("            <!--ESTE SUB MENU PERTENECE AL ADMINISTRADOR-->\n");
      out.write("            <div id=\"barra-usuario1\" class=\"barra-usuario\" ");
      out.print( estiloA);
      out.write("  >\n");
      out.write("                <nav class=\"navegacion2\">\n");
      out.write("                    <ul class=\"menu2\">\n");
      out.write("\n");
      out.write("                        <li><a href=\"usuario-Editar.jsp\"> Editar Perfil </a></li>\n");
      out.write("                        <li><a href=\"Agregar-Administrador.jsp\"> Agregar Administrador </a></li>\n");
      out.write("                        <li><a href=\"editar-cuenta-administrador.jsp\"> Editar Cuenta Usuario </a></li>\n");
      out.write("                        <li><a href=\"Administrador-IngresarProducto.jsp\"> Agregar Producto </a></li>\n");
      out.write("                        <li><a href=\"editarProducto.jsp\"> Editar Producto </a></li>\n");
      out.write("                        <li><a href=\"listar-Servicios.jsp\"> Servicios </a></li>\n");
      out.write("                        <li><a href=\"ver-estado.jsp\"> Administrar Estado </a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </nav>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"c-slider\">\n");
      out.write("\n");
      out.write("                <div id=\"slider\"> \n");
      out.write("                    <section><a href=\"index.jsp\"><img src=\"img/publicidad.jpg\" alt=\"\"></a></section>\n");
      out.write("                    <section><a href=\"index.jsp\"><img src=\"img/publicidad.jpg\" alt=\"\"></a></section>\n");
      out.write("                    <section><a href=\"index.jsp\"><img src=\"img/publicidad.jpg\" alt=\"\"></a></section>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"btn-prev\">&#60</div>\n");
      out.write("                <div id=\"btn-next\">&#62</div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <script src=\"js/slider.js\"></script>\n");
      out.write("\n");
      out.write("            <div id=\"nav1\">\n");
      out.write("                <nav class=\"navegacion\">\n");
      out.write("                    <ul class=\"menu\">\n");
      out.write("                        <li><a href=\"index.jsp\">Inicio </a></li>\n");
      out.write("                        <li><a href=\"Servicios.jsp\">Servicios </a></li>\n");
      out.write("                        <li><a href=\"Productos.jsp\">Productos </a>\n");
      out.write("                            <ul class=\"submenu\">\n");
      out.write("                                ");
for (Producto p : cProductos) {
      out.write("\n");
      out.write("\n");
      out.write("                                <li><a href=\"Servlet_productos?param=");
      out.print(p.getCategoria());
      out.write('"');
      out.write('>');
      out.print(p.getCategoria());
      out.write("</a></li>\n");
      out.write("                                    ");
}
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        <li><a href=\"Contactanos.jsp\"> Contactanos </a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </nav>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"contenido\">\n");
      out.write("                <input type=\"radio\" name=\"filtro\" id=\"btn-vendidos\" checked>\n");
      out.write("                <label for=\"btn-vendidos\" class=\"vendidos\">Lo mas vendido</label>\n");
      out.write("\n");
      out.write("                <input type=\"radio\" name=\"filtro\" id=\"btn-comentados\">\n");
      out.write("                <label for=\"btn-comentados\" class=\"comentados\">Lo mas comentado</label>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <div id=\"articulos\">\n");
      out.write("                    <div class=\"vendido\">\n");
      out.write("                        <article class=\"producto\">\n");
      out.write("                            <div>\n");
      out.write("                                <img src=\"img/mueble-toto.jpg\" alt=\"\">\n");
      out.write("                            </div>\n");
      out.write("                            <div id=\"detalles\">\n");
      out.write("                                <ul>\n");
      out.write("                                    <li>Codigo:prueba</li>\n");
      out.write("                                    <li>Precio:</li>\n");
      out.write("                                    <li>Tipo: </li>\n");
      out.write("                                    <li>Marca: </li>\n");
      out.write("                                    <li>Peso: </li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                            <div id=\"Boton\">\n");
      out.write("                                <button> Agregar a la bolsa</button>\n");
      out.write("                            </div>\n");
      out.write("                        </article>\n");
      out.write("                        <article class=\"producto\">\n");
      out.write("                            <div>\n");
      out.write("                                <img src=\"img/mueble-toto.jpg\" alt=\"\">\n");
      out.write("                            </div>\n");
      out.write("                            <div id=\"detalles\">\n");
      out.write("                                <ul>\n");
      out.write("                                    <li>Codigo:prueba</li>\n");
      out.write("                                    <li>Precio:</li>\n");
      out.write("                                    <li>Tipo: </li>\n");
      out.write("                                    <li>Marca: </li>\n");
      out.write("                                    <li>Peso: </li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                            <div id=\"Boton\">\n");
      out.write("                                <button> Agregar a la bolsa</button>\n");
      out.write("                            </div>\n");
      out.write("                        </article>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"comentado\">\n");
      out.write("                        <article class=\"producto\">\n");
      out.write("                            <div>\n");
      out.write("                                <img src=\"img/mueble-toto.jpg\" alt=\"\">\n");
      out.write("                            </div>\n");
      out.write("                            <div id=\"detalles\">\n");
      out.write("                                <ul>\n");
      out.write("                                    <li>Codigo:prueba</li>\n");
      out.write("                                    <li>Precio:</li>\n");
      out.write("                                    <li>Tipo: </li>\n");
      out.write("                                    <li>Marca: </li>\n");
      out.write("                                    <li>Peso: </li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                            <div id=\"Boton\">\n");
      out.write("                                <button> Agregar a la bolsa</button>\n");
      out.write("                            </div>\n");
      out.write("                        </article>\n");
      out.write("                    </div>\n");
      out.write("                </div>  \n");
      out.write("            </div>\n");
      out.write("<!--VENTANA FLOTANTE-->\n");
      out.write("        <div class=\"flotante\" id=\"ventana\">\n");
      out.write("            <div id=\"cerrar\">\n");
      out.write("                <a href=\"javascript:cerrar()\"><img src=\"img/boton.png\"></a>\n");
      out.write("\n");
      out.write("                <form method=\"post\" action=\"servlet_Email\">\n");
      out.write("                    <input class=\"txt\" type=\"email\" name=\"email\" value=\"\" placeholder=\"Ingresa el Email Asociado a la cuenta\"> <br/> <br/>\n");
      out.write("                    <input class=\" \" type=\"submit\" name=\"enviarCorreo\" value=\"Recuperar contraseña\"> \n");
      out.write("                </form>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("\n");
      out.write("        <div id=\"fooster\">\n");
      out.write("\n");
      out.write("            <a href=\"index.jsp\"><img src=\"img/icono facebok.png\" alt=\"\"/></a>\n");
      out.write("            <p>Norvaz dedicados con nuestros clientes para que\n");
      out.write("                cuenten con los servicios y productos de mejor calidad</p>\n");
      out.write("            <p><a href=\"\">Aviso Legal</a>·<a href=\"\">Politica de privacidad</a></p>\n");
      out.write("        </div>\n");
      out.write("</div>\n");
      out.write("                            \n");
      out.write("</body>\n");
      out.write("<!--JS DE VETANA FLOTANTE-->\n");
      out.write("<script src=\"js/ventana-flotante.js\" type=\"text/javascript\"></script>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
