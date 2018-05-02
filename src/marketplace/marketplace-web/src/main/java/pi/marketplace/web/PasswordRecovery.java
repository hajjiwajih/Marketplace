package pi.marketplace.web;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import services.UserManagment;

@ManagedBean
@SessionScoped
public class PasswordRecovery implements Serializable {

	@EJB
	private UserManagment usermanagment;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String email = "";
	private String keygeneString = "";
	private String key = "";
	private String pass1 = "";
	private String pass2 = "";

	public String getPass1() {
		return pass1;
	}

	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}

	public String getPass2() {
		return pass2;
	}

	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}

	public String firstStep() {

		if (usermanagment.isUser(email)) {
			keygeneString = usermanagment.sendtoken(email.toString());
			return ("passwordrecovery.jsf");
		}
		return ("");
	}

	public String secondStep() {
		if (key.equals(keygeneString)) {
			return ("passwordrecovery2.jsf");
		}
		return "";

	}

	public String passwordchange() {
		if (pass1.equals(pass2)) {
			usermanagment.updatepassword(email, pass1);
			return ("login.jsf");
		}
		return "";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getKeygeneString() {
		return keygeneString;
	}

	public void setKeygeneString(String keygeneString) {
		this.keygeneString = keygeneString;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
