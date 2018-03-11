package services;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
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
	 */
	public Hashfunction() {
		// TODO Auto-generated constructor stub
	}

	public String hash(String passwordString)
	{
		return passwordString;
	}
}
