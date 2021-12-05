<%@page import="Entidad.Direccion"%>
<%@page import="modelo.crud_Direccion"%>
<%@page import="Entidad.Producto"%>
<%@page import="modelo.Crud_Producto"%>
<%@page import="modelo.Leer_Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidad.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<%
HttpSession sesion = request.getSession();
/* capturamos la sesion del usuario*/
String nombre = null;
String usuario = null;
String rol = "0";
String rut = null;
String estiloU = null;
String estiloA = null;
String sesionIniciada = null;
String sinSesion = null;

Crud_Producto product = new Crud_Producto();
ArrayList<Producto> cProductos = product.ListarCategoria();


if(sesion.getAttribute("rol") != null && sesion.getAttribute("usuario") != null ){
    rol = sesion.getAttribute("rol").toString();
    usuario = sesion.getAttribute("usuario").toString();
    nombre = sesion.getAttribute("nombre").toString();
    rut = sesion.getAttribute("rut").toString();
}


// VISTA DE DATOS DE USUARIO
Leer_Usuario atributos = new Leer_Usuario();

Usuario user = new Usuario();
user.setEmail(usuario);
atributos.listarDatosUsuario(user);

// NO SE PUEDE ACCEDER A ESTA PAGINA SIN HAVER INICIADO SESION
if(usuario == null){
    response.sendRedirect("index.jsp");
}
// lista errores
ArrayList lista = (ArrayList) request.getAttribute("listaErrores");
String confirmaCamvio = (String) request.getAttribute("mensaje");

//Mostrar direccion
crud_Direccion crud = new crud_Direccion();
ArrayList<Direccion> listaDatos = crud.VerificarDireccion(rut);

switch (rol){
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
        <link href="css/editar-direccion-estilos.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="img/martillo.png">
        <title>NorVaz - ver Direccion</title>
    </head>
    <body>
        <!--VENTANA FLOTANTE-->
        
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
                                <%if(cProductos != null){%>
                                <%for (Producto p : cProductos) {%>

                                <li><a href="Servlet_productos?param=<%=p.getCategoria()%>"><%=p.getCategoria()%></a></li>
                                    <%}%>
                                    <%}%>
                            </ul>
                        </li>
                        <li><a href="Contactanos.jsp"> Contactanos </a></li>
                    </ul>
                </nav>
            </div>
            <div id="contenido">
                <div class="InisiarSesion">
                    <form action="Servlet_EditarDireccion" method="post">   
                        <%if(listaDatos != null){%>
                        <%for(Direccion d: listaDatos){%>
                        <h3>Ingresar direccion</h3>
                        <table>
                            <tr><td></td><td></td></tr>
                            <tr><td>Region</td><td><select name="region">
                                        <option>Seleccione una region </option>
                                        <option>Arica y Parinacota.</option>
                                        <option>Tarapacá</option>
                                        <option>Antofagasta</option>
                                        <option>Atacama</option>
                                        <option>Coquimbo</option>
                                        <option>Valparaíso</option>
                                        <option>Metropolitana de Santiago</option>
                                        <option>General Bernardo O’Higgins</option>
                                        <option>Maule</option>
                                        <option>Ñuble</option>
                                        <option>Biobío</option>
                                        <option>La Araucanía</option>
                                        <option>Los Ríos</option>
                                        <option>Los Lagos</option>
                                        <option>Aysén </option>
                                        <option>Magallanes</option>
                                    </select></td></tr>
                            <tr><td><br/></td><td></td></tr>
                            <tr><td>Comuna* </td><td><input type="text" value="<%=d.getComuna()%>" name="txt_comuna"></td></tr>
                            <tr><td><br/></td> <td></td></tr>
                            <tr><td>Calle</td> <td><input value="<%=d.getCalle()%>" type="text" name="calle"></td></tr>
                            <tr><td><br/></td><td></td></tr>
                            <tr><td>Nro Calle</td> <td><input value="<%=d.getNroCalle()%>" type="number" name="nrocalle"></td></tr>
                            <tr><td><br/></td><td></td></tr>
                            <tr><td>Nro Casa</td> <td><input value="<%=d.getNroCasa()%>" type="number" name="nrocasa"></td></tr> 
                            <tr><td><br/></td><td></td></tr>
                            <tr><td></td> <td><input type="submit" name="editar" value="Editar"></td></tr> 
                            <tr><td><br/></td> <td></td></tr>
                            <tr><td></td> <td><input type="submit" name="eliminar" value="Eliminar"></td></tr>
                            <tr><td></td> <td><input type="hidden" name="rut" value="<%=rut%>"></td></tr> 

                        </table>
                            <%}%>
                            <%}%>
                            <%if(listaDatos != null){%>
                            <%if(listaDatos.isEmpty()){%>
                            <h1>No hay Direcciones</h1><a href="agregar-direccion.jsp">Ingresa una direccion</a>
                            <%}%>
                            <%}%>
                    </form>
                </div>
            </div>
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