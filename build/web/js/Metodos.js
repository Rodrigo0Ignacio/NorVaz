
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
            }
            if(telefono.length == 0){
                alertify.alert("Error","El campo telefono es requerido").set('label','ok');
                return false;
            }
            
             if(document.registro.txt_regisContrasena.value == document.registro.txt_regisConfirmaContrasena.value){
                 return true;
            } else{
                alertify.alert("Error","Las contraseñas no coinciden").set('label','ok');
                 return false;
            }
              
        }
        
        function soloLetras(e){
            tecla = e.keyCode || e.which;
            teclado = String.fromCharCode(tecla).toString();
            letras = "QWERTYUIOPASDFGHJKLÑZXCVBNMqwertyuiopasdfghjklñzxcvbnmáéíóúÁÉÍÓÚ";
            especiales = [8,13];
            tecla_especial = false;
            
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
            tecla = e.keyCode || e.which;
            teclado = String.fromCharCode(tecla).toString();
            letras = "0123456789";
            especiales = [8,13];
            tecla_especial = false;
            
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
            usuario = document.login.txt_verificarUsuario.value;
            password = document.login.txt_verificarPassword.value;
            
             if(usuario.length == 0 || password.length == 0 ){
                 alertify.alert("Error","Ingrese el usuario y contraseña").set('label','ok');
                return false;
            }
           
            
        }
        
        function ValidarCoincidenciaPass(){
            pass1 = document.cambio_password.txt_password1.value;
            pass2 = document.cambio_password.txt_password2.value;
            
             if((pass2.length == 0 || pass1.length == 0) || pass1 != pass2 ){
                 alertify.alert("Error","Las contraseñas no coinciden").set('label','ok');
                return false;
            }
           
            
        }
        
        function validarSalida(){
            var direccion = document.getElementById('region');
            
            var comuna = document.getElementById('comuna');
            var calle = document.getElementById('calle');
            var nroCalle = document.getElementById('nroCalle');
            var nroCasa = document.getElementById('nroCasa');
            
            if(direccion.value == 0 || direccion.value == ""){
                
                alertify.alert("Error","Region: Ingrese una opcion valida").set('label','ok');
                direccion.focus();
                return false;
                
            }else{
                direccion.focus();
                return true;
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
        
        

        
        
        
        