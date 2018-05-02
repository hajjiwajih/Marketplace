package pi.marketplace.web;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Null;

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
	private String emailString=null;
	private String passwordStrin=null;
	private static  String key=null;
	private String keygenerated=null;
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
		else {
			FacesMessage msg = new FacesMessage("bad credentials");
			FacesContext.getCurrentInstance().addMessage("from_login:login", msg);
			return "";
			
		}
		
		
	}
	public String Second(){
		if (key.equals(keygenerated))
			return ("dashboard.jsf?faces-redirect=true");
		return "";
	}
	
	
	
	

	
}
