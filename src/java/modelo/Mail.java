/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

/**
 *
 * @author Elizabeth
 */
public class Mail {
    protected final String correo = "norvazLitoral@gmail.com";
    protected final String pasword = "norvaz2021";
    private Session s;
    private MimeMessage mensaje;
    private Properties p;
    private Transport t;
    private BodyPart texto;
    private BodyPart adjunto;
    private MimeMultipart m;
    private String msg = "";
    
    public Mail(){
        p = new Properties();
       
    }
    
    public String enviarCorreo(String correo_destino,String asunto,String contenido ){
        p.put("mail.smtp.host","smtp.gmail.com");
        p.setProperty("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.ssl.trust","smtp.gmail.com");
        p.setProperty("mail.smtp.port","587");
        p.setProperty("mail.smtp.user", correo); 
        p.setProperty("mail.smtp.auth", "true");
        p.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        
        s = Session.getDefaultInstance(p);
        mensaje = new MimeMessage(s);
        
        try {
            mensaje.setFrom(new InternetAddress(correo));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(correo_destino));
            mensaje.setSubject(asunto);
            mensaje.setText(contenido);
            
            t = s.getTransport("smtp");
            t.connect(correo,pasword);
            t.sendMessage(mensaje, mensaje.getAllRecipients());
            t.close();
            
            msg = "Email enviado";  
            
        } catch (MessagingException ex) {
            msg = "Error al enviar";
        }
        
        return msg;
    }
    
     public void enviarCorreo_con_Archivos(String correo_destino,String asunto,String contenido,
             String url,String nombre_extension){
         
        p.put("mail.smtp.host","smtp.gmail.com");
        p.setProperty("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.ssl.trust","smtp.gmail.com");
        p.setProperty("mail.smtp.port","587");
        p.setProperty("mail.smtp.user", correo); 
        p.setProperty("mail.smtp.auth", "true");
        p.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        
        s = Session.getDefaultInstance(p);
        texto = new MimeBodyPart();
        try {
            texto.setText("mensaje");
            adjunto = new MimeBodyPart();
            adjunto.setDataHandler(new DataHandler(new FileDataSource(url)));
            adjunto.setFileName(nombre_extension);
            m = new MimeMultipart();
            m.addBodyPart(texto);
            m.addBodyPart(adjunto);
            
        } catch (MessagingException ex) {
            Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
        }
        mensaje = new MimeMessage(s);
        
        
        try {
            mensaje.setFrom(new InternetAddress(correo));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(correo_destino));
            mensaje.setSubject(asunto);
            mensaje.setContent(m);
            
            t = s.getTransport("smtp");
            t.connect(correo,pasword);
            t.sendMessage(mensaje, mensaje.getAllRecipients());
            t.close();
            
           // JOptionPane.showMessageDialog(null,"Mensaje enviado");
            
        } catch (MessagingException ex) {
           // JOptionPane.showMessageDialog(null,"Error: "+ex);
        }  
    }
    
    
    
    
    
}
