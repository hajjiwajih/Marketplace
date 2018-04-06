package pi.marketplace.web;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import services.Authentication;

@ManagedBean
@SessionScoped
public class Usermanagment  implements Serializable{
	@EJB
	  private Authentication authentication;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String emailString="";
	private String passwordStrin="";
	private static  String key="";
	private String keygenerated="";
	public String getEmailString() {
		return emailString;
	}
	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}
	public String getPasswordStrin() {
		return passwordStrin;
	}
	public void setPasswordStrin(String passwordStrin) {
		this.passwordStrin = passwordStrin;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		Usermanagment.key = key;
	}
	public String login(){
		keygenerated=authentication.firststep(emailString, passwordStrin);
		if (keygenerated!=null)
			{System.out.println(keygenerated);
			return "secondFactor.jsf";
			}
		return "error.jsf";
	}
	public String Second(){
		if (key.equals(keygenerated))
			return ("dashboard.jsf");
		return "";
	}
	
	
	
	

	
}
