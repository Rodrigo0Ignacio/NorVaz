
package modelo;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Rodrigo
 */
public class Email {
    
    // DATOS DEL CORREO REMITENTE
    private String correoRemitente = "norvazsancarlos@gmail.com";
    private String passwordRemitente = "norvaz2020";

    private String asunto = null;
    private String contenido = null;
    private String advertencia = null;

    public String EnviarEmail(String correoReceptor, String asunto, String contenido) {

        Properties props = new Properties();

        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.user", correoRemitente);
        props.setProperty("mail.smtp.clave", passwordRemitente);

        Session session = Session.getDefaultInstance(props);
        MimeMessage mensaje = new MimeMessage(session);

        try {
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            mensaje.setSubject(asunto);
            mensaje.setText(contenido);

            Transport transporte = session.getTransport("smtp");
            transporte.connect("smtp.gmail.com", correoRemitente, passwordRemitente);
            transporte.sendMessage(mensaje, mensaje.getAllRecipients());
            transporte.close();

            advertencia = "Email enviado";

        } catch (Exception e) {
            advertencia = "Error al enviar";

        }

        return advertencia;
    }


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
