var a=1;

function validarDatos(){
            nombre = document.registro.txt_regisNombre.value;
            apellidos = document.registro.txt_regisApellido.value;
            email = document.registro.txt_regisEmail.value;
            rut = document.registro.txt_regisRut.value;
            telefono = document.registro.txt_regisTelefono.value;
            
            if(nombre.length == 0){
                alertify.alert("Error","El campo Nombre es requerido").set('label','ok');
                return false;
            }
            if(apellidos.length == 0){
                alertify.alert("Error","El campo Apellidos es requerido").set('label','ok');
                return false;
            }
            if(email.length == 0){
                alertify.alert("Error","El campo email es requerido").set('label','ok');
                return false;
            }
            if(rut.length == 0){
                alertify.alert("Error","El campo RUT es requerido").set('label','ok');
                return false;
            }else{
            
            let rutV=$('#txt_Rut').val();
            let rutvalidador = new rutValidador(rutV);
    
            if(rutvalidador.esvalido){
            }else{
    
            alertify.alert("Error","El rut es invalido").set('label','ok');
            return false;}
            }
            
            
            if(telefono.length == 0){
                alertify.alert("Error","El campo telefono es requerido").set('label','ok');
                return false;
            }
            
            if(document.registro.txt_regisContrasena.value.length>7){
            if(document.registro.txt_regisContrasena.value == document.registro.txt_regisConfirmaContrasena.value){
                 return true;
            } else{
                alertify.alert("Error","Las contraseñas no coinciden").set('label','ok');
                 return false;
            }
            }else{
                alertify.alert("Error","ingrese una contraseña es requerido").set('label','ok');
            return false;}
     
              
        }
              
        
        
        function soloLetras(e){
            var tecla = e.keyCode || e.which;
            var teclado = String.fromCharCode(tecla).toString();
            var letras = "QWERTYUIOPASDFGHJKLÑZXCVBNMqwertyuiopasdfghjklñzxcvbnmáéíóúÁÉÍÓÚ ";
            var especiales = [8,13];
            var tecla_especial = false;
            
            for(var i in especiales){
                if(tecla == especiales[i]){
                    tecla_especial = true;
                    break;
                }
            }
            if(letras.indexOf(teclado) == -1 && !tecla_especial){
                alertify.alert("Error","Ingrese solo letras").set('label','ok');
                return false;
                
            }
           
        }
        
        function soloNumeros(e){
            var tecla = e.keyCode || e.which;
            var teclado = String.fromCharCode(tecla).toString();
            var letras = "0123456789";
            var especiales = [8,13];
            var tecla_especial = false;
            
            for(var i in especiales){
                if(tecla == especiales[i]){
                    tecla_especial = true;
                    break;
                }
            }
            if(letras.indexOf(teclado) == -1 && !tecla_especial){
                alertify.alert("Error","Ingrese solo Numeros").set('label','ok');
                return false;
                
            }
           
        }
        
        function validarLogin(){
            var usuario = document.login.txt_verificarUsuario.value;
            var password = document.login.txt_verificarPassword.value;
            
             if(usuario.length == 0 || password.length == 0 ){
                 alertify.alert("Error","Ingrese el usuario y contraseña").set('label','ok');
                return false;
            }
           
            
        }
        
        function ValidarCoincidenciaPass(){
            var pass1 = document.cambio_password.txt_password1.value;
            var pass2 = document.cambio_password.txt_password2.value;
            
             if((pass2.length == 0 || pass1.length == 0) || pass1 != pass2 ){
                 alertify.alert("Error","Las contraseñas no coinciden").set('label','ok');
                return false;
            }
           
            
        }
        
        function validarSalida(){
            var direccion = document.getElementById('region');
            
            var comuna = document.agregarDireccion.txt_comuna.value;
            var calle = document.agregarDireccion.calle.value;
            var nroCalle = document.agregarDireccion.nrocalle.value;
            var nroCasa = document.agregarDireccion.nrocasa.value;
            
            if(direccion.value == 0 || direccion.value == ""){
                
                alertify.alert("Error","Region: Ingrese una opcion valida").set('label','ok');
                direccion.focus();
                return false;
                
            }if(comuna.length == 0 || comuna == "" || comuna == null){
                alertify.alert("Error","falta rellenar algun item").set('label','ok');
                direccion.focus();
                return false;
            }if(calle.length == 0 || calle == "" || calle == null){
                alertify.alert("Error","falta rellenar algun item").set('label','ok');
                direccion.focus();
                return false;
            }if(nroCalle.length == 0 || nroCalle == "" || nroCalle == null){
                alertify.alert("Error","falta rellenar algun item").set('label','ok');
                direccion.focus();
                return false;
            }if(nroCasa.length == 0 || nroCasa == "" || nroCasa == null){
                alertify.alert("Error","falta rellenar algun item").set('label','ok');
                direccion.focus();
                return false;
            }
        }
        
        function validaDatosDireccion(){

            if(comuna.value == 0 || comuna.value == ""){
                
                alertify.alert("Error","Error comuna").set('label','ok');
                return false;
                
            }else{
                direccion.focus();
                return true;
            }       
        }
        function validarFormulario(){
            var nombre = document.modificar_datos.txt_camNombre.value;
            var apellido = document.modificar_datos.txt_camApellido.value;
            var email1 = document.modificar_datos.txt_camEmail1.value;
            var email2 = document.modificar_datos.txt_camEmail2.value;
            var telefono = document.modificar_datos.txt_camTelefono.value;
            
            if((nombre.length == 0 || nombre == "" || nombre == "null")){
               alertify.alert("Error","Nombre: no puede dejar datos en blanco").set('label','ok');
                return false;
                
            }
            if((apellido.length == 0 || apellido == "" || apellido == "null")){
               alertify.alert("Error","Apellidos: no puede dejar datos en blanco").set('label','ok');
                return false;
                
            }
            if((email1.length == 0 || email1 == "" || email1 == "null")){
               alertify.alert("Error","Email: no puede dejar datos en blanco").set('label','ok');
                return false;
                
            }
            if((email2.length == 0 || email2 == "" || email2 == "null")){
               alertify.alert("Error","confirme Email: no puede dejar datos en blanco").set('label','ok');
                return false;
                
            }
            if((telefono.length == 0 || telefono == "" || telefono == "null")){
               alertify.alert("Error","Telefono: no puede dejar datos en blanco").set('label','ok');
                return false;
                
            }
            if(email1 != email2){
                 alertify.alert("Error","El Email no coincide").set('label','ok');
                return false;   
            }

        }
        
        
        function validarEmail(correo){
            var expReg= /^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$/;
            var esvalido = expReg.test(correo);
            if(esvalido == false){
                alertify.alert("Error","El Email es invalido").set('label','ok');
                return false;
            }
        }
        
        function validaServicio(){
            var pobla = document.solitar_Servicio.txt_poblacion_villa.value;
            var calle = document.solitar_Servicio.txt_calle2.value;
            var nroCasa = document.solitar_Servicio.txt_NCasa.value;
            var telefono = document.solitar_Servicio.txt_telefono.value;
            var requerimiento = document.solitar_Servicio.textA_requerimiento.value;
            
            if(pobla == ""){
                 alertify.alert("Error","Complete todo los items").set('label','ok');
                return false;
            }if(calle == ""){
                 alertify.alert("Error","Complete todo los items").set('label','ok');
                return false;
            }if(nroCasa == ""){
                 alertify.alert("Error","Complete todo los items").set('label','ok');
                return false;
            }if(telefono == ""){
                 alertify.alert("Error","Complete todo los items").set('label','ok');
                return false;
            }if(requerimiento == ""){
                 alertify.alert("Error","Complete todo los items").set('label','ok');
                return false;
            }             
            
        }
        
        function buscarRut(){
            var rut = document.buscar_rut.txt_rut.value;
            
             if(rut == ""){
                alertify.alert("Error","EL campo rut esta vacio").set('label','ok');
                return false;
            }else{
            
            let rutV=$('#txt_Rut').val();
            let rutvalidador = new rutValidador(rutV);
    
            if(rutvalidador.esvalido){
            }else{
    
            alertify.alert("Error","El rut es invalido").set('label','ok');
            return false;}
            }
            
        }
        function registarAdmin(){
            var rut = document.registra_admin.txt_rut.value;
            var nombre = document.registra_admin.txt_nombre.value;
            var apellidos = document.registra_admin.txt_apellido.value;
            var emial = document.registra_admin.txt_email.value;
            var telefono = document.registra_admin.txt_telefono.value;
            var pass1 = document.registra_admin.txt_contrasena1.value;
            var pass2 = document.registra_admin.txt_contrasena2.value;
            
            if(rut == ""){
                alertify.alert("Error","EL campo rut esta vacio").set('label','ok');
                return false;
            }else{
            
            let rutV=$('#txt_Rut').val();
            let rutvalidador = new rutValidador(rutV);
    
            if(rutvalidador.esvalido){
            }else{
    
            alertify.alert("Error","El rut es invalido").set('label','ok');
            return false;}
            }
            if(nombre == ""){
                alertify.alert("Error","EL campo nombre esta vacio").set('label','ok');
                return false;
            }if(apellidos == ""){
                alertify.alert("Error","EL campo apellido esta vacio").set('label','ok');
                return false;
            }if(emial == ""){
                alertify.alert("Error","EL campo email esta vacio").set('label','ok');
                return false;
            }if(telefono == ""){
                alertify.alert("Error","EL campo telefono esta vacio").set('label','ok');
                return false;
            }if(pass1 == ""){
                alertify.alert("Error","EL campo contraseña esta vacio").set('label','ok');
                return false;
            }if(pass2 == ""){
                alertify.alert("Error","EL campo conforme contraseña esta vacio").set('label','ok');
                return false;
            }if(pass1 != pass2){
                alertify.alert("Error","Las contraseñas no coinciden").set('label','ok');
                return false;
            }
            
        }
        
        function agregarProducto(){
            var categoria = document.getElementById('categoria');
            
            var codproductos = document.ingreso_producto.txt_code.value;
            var nombre = document.ingreso_producto.txt_nombre.value;
            var stock = document.ingreso_producto.txt_stock.value;
            var preIVA = document.ingreso_producto.txt_precio.value;
            var pesoKilo = document.ingreso_producto.txt_peso.value;
            var descripcion = document.ingreso_producto.descripcion.value;
            var img = document.ingreso_producto.img.value;
            
            if(codproductos == ""){
                alertify.alert("Error","EL campo Codigo producto esta vacio").set('label','ok');
                return false;
            }if(nombre == ""){
                alertify.alert("Error","EL campo Nombre esta vacio").set('label','ok');
                return false;
            }if(stock == ""){
                alertify.alert("Error","EL campo Stock producto esta vacio").set('label','ok');
                return false;
            }if(preIVA == ""){
                alertify.alert("Error","EL campo Precio IVA esta vacio").set('label','ok');
                return false;
            }if(pesoKilo == ""){
                alertify.alert("Error","EL campo peso Kilo esta vacio").set('label','ok');
                return false;
            }if(descripcion == ""){
                alertify.alert("Error","EL campo Descripcion producto esta vacio").set('label','ok');
                return false;
            }if(categoria.value == 0 || categoria.value == ""){
                alertify.alert("Error","Categoria : seleccione un elemento").set('label','ok');
                return false;
            }
            

        }
        
        function buscarProducto(){
            var idpro = document.editar_producto.txt_code.value;
            
            if (idpro == "") {
               alertify.alert("Error", "Ingrese un codigo de producto").set('label', 'ok');
               return false;
            }
            
        }
        
        function form_editar(){
            var categoria = document.getElementById('cate');
            var codProducto = document.editarProducto1.txt_code.value;
            var nombre = document.editarProducto1.txt_nombre.value;
            var stock = document.editarProducto1.txt_stock.value;
            var precioIVA = document.editarProducto1.txt_precio.value;
            var pkilo = document.editarProducto1.txt_peso.value;
            var descip = document.editarProducto1.descripcion.value;
            var img = document.editarProducto1.img.value;
            
            if (codProducto == "") {
               alertify.alert("Error", "EL campo Categoria esta vacio").set('label', 'ok');
               return false;
            }if (nombre == "") {
               alertify.alert("Error", "EL campo nombre esta vacio").set('label', 'ok');
               return false;
            }if (stock == "") {
               alertify.alert("Error", "EL campo stock esta vacio").set('label', 'ok');
               return false;
            }if (precioIVA == "") {
               alertify.alert("Error", "EL campo precio IVA esta vacio").set('label', 'ok');
               return false;
            }if (pkilo == "") {
               alertify.alert("Error", "EL campo peso kilogramo esta vacio").set('label', 'ok');
               return false;
            }if (descip == "") {
               alertify.alert("Error", "EL campo Descripcion esta vacio").set('label', 'ok');
               return false;
            }if (categoria.value == 0 || categoria.value == "") {
               alertify.alert("Error", "Ingrese una categoria").set('label', 'ok');
               return false;
            }
   
        }
        
        function editar(){
            var nombre = document.editar_usuario.txt_nombreM.value;
            var apellidos = document.editar_usuario.txt_apellidoM.value;
            var email = document.editar_usuario.txt_emailM.value;
            var rut = document.editar_usuario.txt_rutM.value;
            var telefono = document.editar_usuario.txt_telefonoM.value;
            
           if(nombre == ""){
                alertify.alert("Error","EL campo Nombre esta vacio").set('label','ok');
                return false;
            }if(apellidos == ""){
                alertify.alert("Error","EL campo apellidos esta vacio").set('label','ok');
                return false;
            }if(email == ""){
                alertify.alert("Error","EL campo email esta vacio").set('label','ok');
                return false;
            }if(rut == ""){
                alertify.alert("Error","EL campo rut esta vacio").set('label','ok');
                return false;
            }else{
            
            let rutV=$('#txt_Rut2').val();
            let rutvalidador = new rutValidador(rutV);
    
            if(rutvalidador.esvalido){
            }else{
    
            alertify.alert("Error","El rut es invalido").set('label','ok');
            return false;}
            }
            
            
            
            if(telefono == ""){
                alertify.alert("Error","EL campo telefono esta vacio").set('label','ok');
                return false;
            }
        }

        
        

        
        
        
        