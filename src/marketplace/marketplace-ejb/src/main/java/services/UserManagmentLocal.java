package services;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.ejb.Remote;

import domain.Clientnonvalid;
import domain.Users;

@Remote
public interface UserManagmentLocal {
	/***
	 * 
	 * @param clientNonValid
	 * @return
	 */
	 public String registrationRequest(Clientnonvalid clientNonValid);
	 public String registrationConfirmation(String keyString);
	 public boolean isTemKey(String keyString);
	 
	/***
	 * add user 
	 * @param users
	 * @return
	 * @throws NoSuchAlgorithmException 
	 * @throws UnsupportedEncodingException 
	 */
	public String addUser(Users users) ;
	/**
	 * 
	 * rechertche user
	 * @param emailString
	 * @return user 
	 */
	public Users findUsers(String emailString);
	

}
