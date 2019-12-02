package Classes;

import javax.mail.*;
import org.apache.commons.mail.*;
        
public class enviarEmail {
    
    public void enviar(String idCliente, String emailCliente, String senha){
        SimpleEmail  email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(587);
        email.setStartTLSRequired(true);
        email.setStartTLSEnabled(true);
        email.setSSLOnConnect(true);
        
        email.setAuthenticator(new DefaultAuthenticator("projetorose2019@gmail.com", "projrose2019"));
        try{
            email.setFrom("projetorose2019@gmail.com");
            email.setSubject("Acesso ao Sistema!");
            email.setMsg("Olá " + idCliente + ", sua senha temporária é: " + senha + "\nSeu login será excluído após 10 minutos, faça o login para evitar.");
            email.addTo(emailCliente);
            email.send();
        }
        catch (EmailException e){
            e.printStackTrace();  
        }
    }
    
        public void enviarSenhaNova(String idCliente, String emailCliente, String senha){
        

        SimpleEmail  email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(587);
        email.setStartTLSRequired(true);
        email.setStartTLSEnabled(true);
        email.setSSLOnConnect(true);
        
        email.setAuthenticator(new DefaultAuthenticator("projetorose2019@gmail.com", "projrose2019"));
        try{
            email.setFrom("projetorose2019@gmail.com");
            email.setSubject("Mudança de senha!");
            email.setMsg("Olá " + idCliente + ", sua senha temporária é: " + senha);
            email.addTo(emailCliente);
            email.send();
        }
        catch (EmailException e){
            e.printStackTrace();  
        }
    }
}
