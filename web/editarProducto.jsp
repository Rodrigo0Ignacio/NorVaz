
<%@page import="modelo.Crud_Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidad.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<%
    HttpSession sesion = request.getSession();
    /* capturamos la sesion del usuario*/
    String nombre = null;
    String usuario = null;
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
    }
// capturamos los atributos entrantes del usuario a editar
    ArrayList<Producto> lista = (ArrayList<Producto>) request.getAttribute("lista");

// capturamos la variable para ocultar un form
    String formBuscarCUenta = null;
    if (request.getAttribute("ocultarForm") != null) {
        formBuscarCUenta = "style=\"display: none\"";
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
        <link href="css/InicioSesion-estilos.css" rel="stylesheet" type="text/css"/>
  
        <title>NorVaz - Editar Producto</title>
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
                <div class="InisiarSesion" <%=formBuscarCUenta%> >
                    <h2> Buscar Producto </h2>
                    <br>
                    <form method="post" action="servlet_EditarProductos" >
                        <table>
                            <tr>
                            <tr><td><br></td><td></td></tr>
                            <tr><td>Codigo de Producto&nbsp;</td><td><input type="text"
                                                                   name="txt_code" placeholder="codigo de producto a editar"></td></tr>
                            <tr><td><br></td><td></td></tr>
                            <tr><td></td><td> <input type="submit" name="btn_buscar" value="Buscar Producto"></td></tr>
                            <tr><td><br></td><td></td></tr>

                        </table>
                    </form>

                </div>

                <%if (lista != null) {%>
                <%for (Producto i : lista) {%>
                <div class="cuenta" >
                    <h2> Editar Producto </h2>
                    <br>
                    <form method="post" action="servlet_EditarProductos"  >
                        <table>
                        <tr><td><br></td><td></td></tr>
                        <tr><td>Codigo de producto* </td><td><input type="text" name="txt_code" value="<%= i.getCodigo()%>"></td></tr>
                        <tr><td><br></td><td></td></tr>
                        <tr><td>Nombre* </td><td><input type="text"  name="txt_nombre" value="<%= i.getNombre()%>"></td></tr>
                        <tr><td><br></td><td></td></tr>
                        <tr><td>Stock* </td><td><input type="number"  name="txt_stock" value="<%= i.getStock()%>"></td></tr>
                        <tr><td><br></td><td></td></tr>
                        <tr><td>Precio (IVA incluido)* </td><td><input type="number" name="txt_precio" value="<%= i.getPrecio()%>" placeholder="ingrese valores sin punto"></td></tr>
                        <tr><td><br></td><td></td></tr>
                        <tr><td>Peso en Kilogramos* </td><td><input type="text" value="<%= i.getPeso()%>" name="txt_peso" placeholder="1,3K o 3K"></td></tr>
                        <tr><td><br></td><td></td></tr>

                        <tr><td>Categoria* </td><td><select name="categoria" >
                                    <option>Seleccione una categoria</option>
                                    <option>Sofás</option>
                                    <option>Mesas</option>
                                    <option>Sillas</option>
                                    <option>Camas</option>
                                    <option>Escritorios</option>
                                    <option>Cómodas</option>
                                    <option>Mesas de comedor</option>
                                    <option>Sofás seccionales</option>
                                    <option>Muebles de televisor</option>
                                    <option>Bibliotecas</option>
                                    <option>Mesitas de café</option>
                                    <option>Beladores</option>
                                    <option>Mini bar</option>
                                    <option>Islas para cocina</option>
                                    <option>Armarios</option>
                                    <option>Organizadores de juguetes</option>
                                    <option>Percheros de pared</option>
                                    <option>Muebles para jardín</option>
                                    <option>Otros</option>
                                </select></td></tr>
                        <tr><td><br></td><td></td></tr>
                        <tr><td>Descripcion* </td><td><textarea name="descripcion" rows="4" cols="36" placeholder="Ingrese una breve descripcion"><%= i.getDescripcion()%></textarea></td></tr>
                        <tr><td><br></td><td></td></tr>
                        <tr><td>Ingresar Imagen </td><td><input type="text" name="img" placeholder="imagen.jpg" value="<%= i.getUrl()%>"></td></tr>
                        <tr><td><br></td><td></td></tr>
                        <tr><td></td><td> <input type="submit" name="btn_editar" value="Editar Producto"></td></tr>
                        <tr><td><br></td><td></td></tr>
                        <tr><td></td><td> <input type="submit" name="btn_eliminar" value="Eliminar Producto"></td></tr>
                        </table>   
                    </form>
                </div>

                <%}%>
                <%}%>
                <%if (lista != null) {%>
                <%if (lista.isEmpty()) {%>
                <h1>Producto no encontrado</h1>

                <%}%>
                <%}%>
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
