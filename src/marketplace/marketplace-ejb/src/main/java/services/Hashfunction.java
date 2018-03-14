package services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class Hashfunction
 */
@Singleton
@LocalBean
public class Hashfunction {

	/**
	 * Default constructor.
	 * @throws NoSuchAlgorithmException 
	 */
	public String hash(String passwordString) throws NoSuchAlgorithmException
	{
		 MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		passwordString="heder"+passwordString+"helloitme";
		 messageDigest.update(passwordString.getBytes());
		 String encryptedpassword = new String(messageDigest.digest());
		return encryptedpassword;
	}
	 public Hashfunction() {
		// TODO Auto-generated constructor stub
	}
	

	
	
}
