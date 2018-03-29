package pi.marketplace.web;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import domain.tmpuser;
import services.UserManagmentLocal;

@ManagedBean
@SessionScoped
public class Resgistration implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	UserManagmentLocal userManagmentLocal;

	public Resgistration() {
		// TODO Auto-generated constructor stub
	}

	private String email = null;
	private String password = null;
	private String password2 = null;
	private String firstName = null;
	private String lastName = null;
	private int phoneNumber = 0;
	private String adress = null;
	
	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String register() {
		String navto=""; 
		if (password.equals(password2)) {
			tmpuser tmpuser = new tmpuser();
			tmpuser.setAdress(adress);
			tmpuser.setEmail(email);
			tmpuser.setFirstName(firstName);
			tmpuser.setLastName(lastName);
			tmpuser.setPassword(password);
			tmpuser.setPhoneNumber(phoneNumber);
			userManagmentLocal.registrationRequest(tmpuser);
			navto="registersuccessfully";
		}
		FacesMessage msg = new FacesMessage("bad credentials");
		FacesContext.getCurrentInstance().addMessage("form_login:btn_login", msg);
		return navto;
		
		
	}
}
