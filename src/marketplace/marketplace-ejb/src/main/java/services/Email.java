package services;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import com.sun.mail.iap.Protocol;

/**
 * Session Bean implementation class Email
 */
@Singleton
@LocalBean
public class Email {

    /**
     * Default constructor. 
     */
    public Email() {
        // TODO Auto-generated constructor stub
    }
    
    private int port = 465;
    private String host = "smtp.example.com";
    private String from = "matt@example.com";
    private boolean auth = true;
    private String username = "matt@example.com";
    private String password = "secretpw";
    //private Protocol protocol = Protocol.SMTPS;
    private boolean debug = true;
    

}
