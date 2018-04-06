package services;

import javax.ejb.Remote;

@Remote
public interface AuthenticationRemote {

	String firststep(String emailString, String passString); 
	
	

}
