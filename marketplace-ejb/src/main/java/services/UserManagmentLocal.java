package services;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.ejb.Remote;

import domain.Users;
import domain.tmpuser;

@Remote
public interface UserManagmentLocal {
	/***
	 * 
	 * @param clientNonValid
	 * @return
	 */
	 public boolean registrationRequest(tmpuser tmpuser);
	 public boolean RegistrationConfirmation(String Key);
	 
	/***
	 * add user 
	 * @param users
	 * @return
	 * @throws NoSuchAlgorithmException 
	 * @throws UnsupportedEncodingException 
	 */
	public boolean addUser(Users users) ;
	/**
	 * 
	 * rechertche user
	 * @param emailString
	 * @return user 
	 */
	public Users findUsers(String emailString);
	/***
	 * update users throw merge function
	 * @param users
	 * @return
	 */
	public boolean updateUser(Users users);
	

}
