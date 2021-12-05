<%@page import="modelo.Crud_Producto"%>
<%@page import="Entidad.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<%
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

    ArrayList<Producto> productosAll = product.productosAll();
    ArrayList<Producto> cProductos = product.ListarCategoria();
    ArrayList<Producto> listac = (ArrayList<Producto>) request.getAttribute("listaC");

    ArrayList<Producto> carrito=(ArrayList)session.getAttribute("carrito");
    
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

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/productos-estilos.css" rel="stylesheet" type="text/css"/>
        <title>NorVaz</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
        <link rel="shortcut icon" href="img/martillo.png">
    </head>
    <body>
        
        <div id="contenedor">
            <div id="header">

                <div id="logo">
                    <img src="img/logo_destornillador.PNG" alt="">
                </div>

                <div id="CuentaUser">
                    <ul>
                        <li><img class="central" src="img/usuario.png" alt=""></li>
                    </ul>

                    <!--APARTADO DE OPCIONES DE SESION (USUARIO)-->
                    <ul <%=sesionIniciada%> >
                        <li><a href="InicioSesion.jsp"> Bienvenid@ <%=nombre%> </a></li>
                        <li><a href="index.jsp?cerrar=true">Cerrar Sesion</a></li>
                    </ul>

                    <ul <%=sinSesion%> >
                        <li><a href="InicioSesion.jsp"> Iniciar Sesion</a></li>
                        <li><a href="InicioSesion.jsp"> Crear una cuenta</a></li>
                        <li><a href="javascript:abrir()"> olvidaste tu contraseña</a></li>
                    </ul>
                </div>

            </div>
            <div id="nav2" <%= estiloU%>  >
                <nav class="navegacion2">
                    <ul class="menu2">

                        <li><a href="usuario-Editar.jsp"> Editar Perfil </a></li>
                        <li><a href="agregar-direccion.jsp"> Agregar Una Direccion </a></li>
                        <li><a href="ver_direccion.jsp"> Ver direccion </a></li>
                        <li><a href="Ver_pedido.jsp"> Ver pedido </a></li>
                        <li><a href="Carrito.jsp"> <img src="img/carrito.png"> ver carrito </a></li>
                    </ul>
                </nav>
            </div> 
            <!--ESTE SUB MENU PERTENECE AL ADMINISTRADOR-->
            <div id="barra-usuario1" class="barra-usuario" <%= estiloA%>  >
                <nav class="navegacion2">
                    <ul class="menu2">

                        <li><a href="usuario-Editar.jsp"> Editar Perfil </a></li>
                        <li><a href="Agregar-Administrador.jsp"> Agregar Administrador </a></li>
                        <li><a href="editar-cuenta-administrador.jsp"> Editar Cuenta Usuario </a></li>
                        <li><a href="Administrador-IngresarProducto.jsp"> Agregar Producto </a></li>
                        <li><a href="editarProducto.jsp"> Editar Producto </a></li>
                        <li><a href="listar-Servicios.jsp"> Servicios </a></li>
                        <li><a href="ver-estado.jsp"> Administrar Estado </a></li>
                    </ul>
                </nav>
            </div>

            <div id="c-slider">

                <div id="slider"> 
                    <section><a href="index.jsp"><img src="img/publicidad.jpg" alt=""></a></section>
                    <section><a href="index.jsp"><img src="img/publicidad.jpg" alt=""></a></section>
                    <section><a href="index.jsp"><img src="img/publicidad.jpg" alt=""></a></section>
                </div>
                <div id="btn-prev">&#60</div>
                <div id="btn-next">&#62</div>

            </div>
            <script src="js/slider.js"></script>

            <div id="nav1">
                <nav class="navegacion">
                    <ul class="menu">
                        <li><a href="index.jsp">Inicio </a></li>
                        <li><a href="Servicios.jsp">Servicios </a></li>
                        <li><a href="Productos.jsp">Productos </a>
                            <ul class="submenu">
                                <%for (Producto p : cProductos) {%>

                                <li><a href="Servlet_productos?param=<%=p.getCategoria()%>"><%=p.getCategoria()%></a></li>
                                    <%}%>
                            </ul>
                        </li>
                        <li><a href="Contactanos.jsp"> Contactanos </a></li>
                    </ul>
                </nav>
            </div>

            <div id="contenido">

                <div id="menuproductos">
                    <h1>menu</h1>
                    <%for (Producto p : cProductos) {%>
                    <form method="get" action="Servlet_productos">
                        <ul>
                            <li><input type="submit" name="categoria" style="border:0;" value="<%=p.getCategoria()%>"><input type="hidden" name="param" value="<%=p.getCategoria()%>"></li>
                        </ul>
                    </form>
                    <%}%>
                </div>

                <div id="productos">
                    <h1>  Productos</h1>
                    <%if (listac != null) {
                            Producto prod = listac.get(0);
                    %>
                    <h1>/<%=prod.getCategoria()%></h1>
                    <%for (Producto p : listac) {%>
                    <article class="producto">

                        <div id="imagenProducto">
                            <img src="<%=p.getUrl()%>" alt="">

                        </div>

                        <div id="detalles">
                            <ul>
                                <li><%=p.getNombre()%></li>
                                <li>Stock: <%=p.getStock()%></li>
                                <li>Tipo: <%=p.getCategoria()%></li>
                                <li>Precio: <%=p.getPrecio()%></li>
                            </ul>
                        </div>
                        <div id="Boton">
                            <form method="post" action="Servlet_ver_producto">
                                <button type="submit" name="codigo" value="<%=p.getCodigo()%>">ver Producto</button>
                            </form>
                        </div>
                    </article>

                    <%}
                    } else {
                        for (Producto p : productosAll) {%>
                    <article class="producto">

                        <div id="imagenProducto">
                            <img src="<%=p.getUrl()%>" alt="">

                        </div>

                        <div id="detalles">
                            <ul>
                                <li><%=p.getNombre()%></li>
                                <li>Stock: <%=p.getStock()%></li>
                                <li>Tipo: <%=p.getCategoria()%></li>
                                <li>Precio: <%=p.getPrecio()%></li>
                            </ul>
                        </div>
                        <div id="Boton">
                            <form method="post" action="Servlet_ver_producto">
                                <button type="submit" name="codigo" value="<%=p.getCodigo()%>">ver Producto</button>
                            </form>
                        </div>
                    </article>
                    <%}
                        }%>
                </div>

            </div>
<!--VENTANA FLOTANTE-->
        <div class="flotante" id="ventana">
            <div id="cerrar">
                <a href="javascript:cerrar()"><img src="img/boton.png"></a>

                <form method="post" action="servlet_Email">
                    <input class="txt" type="email" name="email" value="" placeholder="Ingresa el Email Asociado a la cuenta"> <br/> <br/>
                    <input class=" " type="submit" name="enviarCorreo" value="Recuperar contraseña"> 
                </form>

            </div>
        </div>
            <div id="fooster">

                <a href="index.jsp"><img src="img/icono facebok.png" alt=""/></a>
                <p>Norvaz dedicados con nuestros clientes para que
                    cuenten con los servicios y productos de mejor calidad</p>
                <p><a href="">Aviso Legal</a>·<a href="">Politica de privacidad</a></p>
            </div>
        </div>

    </body>
    <!--JS DE VETANA FLOTANTE-->
    <script src="js/ventana-flotante.js" type="text/javascript"></script>
</html>