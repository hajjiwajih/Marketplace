package pi.marketplace.web;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import services.Authentication;

@ManagedBean
@SessionScoped
public class AuthenticationBean implements Serializable {
	@EJB
	Authentication authen;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/***
	 * model of authen
	 */
	private String emaiString;
	private String passString;
	private String key;
	private String keyin;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public AuthenticationBean() {
		super();
	}

	public String getEmaiString() {
		return emaiString;
	}

	public void setEmaiString(String emaiString) {
		this.emaiString = emaiString;
	}

	public String getPassString() {
		return passString;
	}

	public void setPassString(String passString) {
		this.passString = passString;
	}

	public String Login() {
		String navigateTo = null;
		key = authen.firststep(emaiString, passString);
		if (key != null) {
			navigateTo = "secondFactor.jsf";
		}
		return navigateTo;
	}
	public String secondfactor()
	{
		String navigateTo = null;
		if (keyin.equals(key))
			 return navigateTo="welcome.jsf";
		return navigateTo; 		
	}

	public String getKeyin() {
		return keyin;
	}

	public void setKeyin(String keyin) {
		this.keyin = keyin;
	}
	
}
