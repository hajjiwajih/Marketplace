package services;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Clientnonvalid;
import domain.Users;
import domain.client;

/**
 * Session Bean implementation class UserManagment
 */
@Stateless
public class UserManagment implements UserManagmentLocal {

	@PersistenceContext
	EntityManager em;
	@EJB
	Email email;
	@EJB
	Hashfunction hashfunction;

	/**
	 * Default constructor.
	 */
	public UserManagment() {
		// TODO Auto-generated constructor stub
	}

	/***
	 * add user to the database
	 * 
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException
	 */
	public String addUser(Users users) {
		try {
			users.setPassword(hashfunction.hash(users.getPassword()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		email.send(users.getEmail(), "Marketplace service", "acount created");
		em.persist(users);
		return ("added");
	}

	public Users findUsers(String emailString) {
		return (em.find(Users.class, emailString));
	}

	public String registrationRequest(Clientnonvalid clientNonValid) {
		boolean iskey = true;
		String key = null;
		while (iskey) {			
			key = UUID.randomUUID().toString();
			iskey = isTemKey(key);
		}
		clientNonValid.setKey(key);
		email.send(clientNonValid.getEmail(), "validation inscription", " click on this link "+key);
		
		em.persist(clientNonValid);
		return ("qdde");
	}

	public String registrationConfirmation(String keyString) {
		//em.find(Clientnonvalid.class, keyString);
		return ("hello world");
	}

	public boolean isTemKey(String keyString) {
		if (em.find(Clientnonvalid.class, keyString) != null)
			return false;
		return true;
	}

}
