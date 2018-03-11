package services;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.ejb.Remote;

import domain.Users;

@Remote
public interface UserManagmentLocal {
	/***
	 * add user 
	 * @param users
	 * @return
	 * @throws NoSuchAlgorithmException 
	 * @throws UnsupportedEncodingException 
	 */
	public String addUser(Users users) ;
	public Users findUsers(String emailString);

}
