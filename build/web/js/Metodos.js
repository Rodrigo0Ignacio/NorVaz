
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
        
        function validarEmail(correo){
            var expReg= /^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$/;
            var esvalido = expReg.test(correo);
            if(esvalido == false){
                alertify.alert("Error","El Email es invalido").set('label','ok');
                return false;
            }
        }

        
        
        
        