package pi.marketplace.web;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import domain.tmpuser;
import services.UserManagmentLocal;
@ManagedBean
@SessionScoped
public class Resgistration  implements Serializable{
	@EJB
	UserManagmentLocal userManagmentLocal;
	public Resgistration() {
		// TODO Auto-generated constructor stub
	}
	private String email;
	private String password; 
	private String firstName;
	private String lastName;
	private int phoneNumber;
	private String adress;
	
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

	public String register()
	{
		tmpuser tmpuser= new tmpuser();
			tmpuser.setAdress(adress);
			tmpuser.setEmail(email);
			tmpuser.setFirstName(firstName);
			tmpuser.setLastName(lastName);
			tmpuser.setPassword(password);
			tmpuser.setPhoneNumber(phoneNumber);
			userManagmentLocal.registrationRequest(tmpuser); 
					
		return "registersuccessfully";
		
		
	}
}
