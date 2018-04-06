package domain;

import domain.Users;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: client
 *
 */
@Entity
public class client extends Users implements Serializable {

	private String walletID; 
	
	private static final long serialVersionUID = 1L;

	public client() {
		super();
	}

	public String getWalletID() {
		return walletID;
	}

	public void setWalletID(String walletID) {
		this.walletID = walletID;
	}
   
}
