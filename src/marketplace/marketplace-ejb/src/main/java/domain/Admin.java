package domain;

import domain.Users;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity

public class Admin extends Users implements Serializable {
	/***
	 * le role de administrateur 
	 */
	private String role; 
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	private static final long serialVersionUID = 1L;

	public Admin() {
		super();
	}
   
}
