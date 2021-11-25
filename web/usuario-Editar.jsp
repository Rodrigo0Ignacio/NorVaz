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
        <link href="css/InicioSesion-estilos.css" rel="stylesheet" type="text/css"/>
        <link href="alertifyjs/css/alertify.min.css" rel="stylesheet" type="text/css"/>
        <link href="alertifyjs/css/themes/default.min.css" rel="stylesheet" type="text/css"/>
        <title>NorVaz - Editar Perfil</title>
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
            <div class="InisiarSesion">
                <h2>Cambiar Contraseña</h2>
                <form name="cambio_password" action="servlet_usuario_Editar" method="post" onsubmit="return ValidarCoincidenciaPass()"> 
                    
                <table>
                       <tr><br><td><br></td><td></td></tr>
                       <tr><td><br></td><td></td></tr>
                       <tr><td>Nueva contraseña* </td><td><input type="password" value="" name="txt_password1"></td></tr>
                       <tr><td><br></td><td></td></tr>
                       <tr><td>Repita contraseña* </td><td><input type="password" value="" name="txt_password2"></td></tr>
                       <tr><td><br></td><td></td></tr>
                       <tr><td></td><td> <input type="submit" name="btn_restablecer" value="Cambiar"></td></tr>
                       <tr><td><br></td><td></td></tr>
                       <p> Al modificar la contraseña tendra que volver a 
                               iniciar sesion.</p>
                       <input type="hidden" name="txt_correo" value="<%=usuario%>" placeholder="<%=usuario%>">    

                       <!--MUESTRA LOS MENSAJES DE ERROR -->
                       <%if (lista != null) { %>
                       <%for (int i = 0; i < lista.size(); i++) {%>
                       <ul>
                           <tr><td><br></td><td><%=lista.get(i)%></td></tr>
                       </ul>

                       <% }
                    }%>
                       <%if (confirmaCamvio != null) {%>
                       <tr><td><br></td><td><%=confirmaCamvio%></td></tr>
                               <%}%>
                </table>
                </form>


            </div>
                <div class="Registrarse">
                    <h2> Modificar Datos </h2>
                    <form name="modificar_datos" method="post" action="servlet_usuario_Editar" onsubmit="return validarFormulario()" >
                    <table>

                        <tr><br><td><br></td><td></td></tr>
                           <tr><td><br></td><td></td></tr>
                           <tr><td>Nombre* </td><td><input type="text" value="<%=user.getNombre()%>" name="txt_camNombre" onkeypress="return soloLetras(event)"></td></tr>
                           <tr><td><br></td><td></td></tr>
                           <tr><td>Apellidos* </td><td><input type="text" value="<%=user.getApellidos()%>" name="txt_camApellido" onkeypress="return soloLetras(event)"></td></tr>
                           <tr><td><br></td><td></td></tr>
                           <tr><td>Email* </td><td><input type="email" value="<%=user.getEmail()%>" name="txt_camEmail1" placeholder="ejemplo: roberto.farias@dominio.cl" ></td></tr>
                           <tr><td><br></td><td></td></tr>
                           <tr><td>Confirmar Email* </td><td><input type="email" value="<%=user.getEmail()%>" name="txt_camEmail2" placeholder="ejemplo: roberto.farias@dominio.cl"></td></tr>
                           <tr><td><br></td><td></td></tr>
                           <tr><td>Telefono* </td><td><input type="tel" value="<%=user.getTelefono()%>" name="txt_camTelefono" placeholder="ejemplo: 98745632" onkeypress="return soloNumeros(event)" ></td></tr>
                           <tr><td><br></td><td></td></tr>
                           <tr><td></td><td><input type="hidden" value="<%=rut%>" name="rut"></td></tr>
                           <tr><td><br></td><td></td></tr>
                           <tr><td></td><td> <input type="submit" name="btn_Registrar" value="Modificar"></td></tr>
        
                    </table>
                    </form>   
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
    <script src="alertifyjs/alertify.min.js" type="text/javascript"></script>
    <script src="js/Metodos.js" type="text/javascript"></script>
    
</html>
