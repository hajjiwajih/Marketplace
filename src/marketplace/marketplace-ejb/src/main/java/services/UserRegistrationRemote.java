package services;

import javax.ejb.Remote;

import domain.ClientNonValid;

@Remote
public interface UserRegistrationRemote {
	public String RegistrationRequest(ClientNonValid clientNonValid);
	public String RegistrationValidation(int id);
	

}
