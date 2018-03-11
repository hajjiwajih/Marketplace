package domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ClientNonValid
 *
 */
@Entity
public class ClientNonValid implements Serializable {
	
	private String email;
	private String password; 
	private String firstName;
	private String lastName;
	private int phoneNumber;
	private String adress;
	private boolean active;
	@Id
	private int  key;
	
	
	
	

	
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	private static final long serialVersionUID = 1L;

	public ClientNonValid() {
		super();
	}
   
}
