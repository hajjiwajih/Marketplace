package services;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.Null;

import domain.Usernotconfirmed;
import domain.Users;
import domain.client;
import domain.tmpuser;

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
	public boolean addUser(Users users) {
		em.persist(users);
		return true;

	}

	public Users findUsers(String emailString) {
		return (em.find(Users.class, emailString));
	}

	@Override
	public boolean registrationRequest(tmpuser tmpuser) {
		String key = UUID.randomUUID().toString();
		tmpuser.setPrivatekey(key);
		em.persist(tmpuser);
		return true; 
		
	}

	@Override
	public boolean isTemKey(String keyString) {
		// TODO Auto-generated method stub
		return false;
	}

	/***
	 * insert into our temp data base user
	 */
	/*
	public String registrationRequest(Usernotconfirmed clientNonValid) {
		boolean iskey = true;
		String key = null;
		while (iskey) {
			key = UUID.randomUUID().toString();
			iskey = isTemKey(key);
		}
		clientNonValid.setKey(key);
		email.send(clientNonValid.getEmail(), "validation inscription", " click on this link " + key);
		try {
			clientNonValid.setPassword(hashfunction.hash(clientNonValid.getPassword()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		em.persist(clientNonValid);
		return ("qdde");
	}

	public boolean registrationConfirmation(String keyString) {
		Usernotconfirmed clientnonvalid = new Usernotconfirmed();
		clientnonvalid = em.find(Usernotconfirmed.class, keyString);
		if (clientnonvalid != null) {
			client client = new client();
			client.setActive(true);
			client.setAdress(clientnonvalid.getAdress());
			client.setEmail(clientnonvalid.getEmail());
			client.setFirstName(clientnonvalid.getFirstName());
			client.setLastName(clientnonvalid.getLastName());
			client.setPassword(clientnonvalid.getPassword());
			client.setPhoneNumber(clientnonvalid.getPhoneNumber());
			// generate walled id
			email.send(client.getAdress(), "inscription valide", "votre waller is ");
			return (addUser(client));

		}

		return ("error clent not find ");
	}

	public boolean isTemKey(String keyString) {
		if (em.find(Usernotconfirmed.class, keyString) != null)
			return false;
		return true;
	}
*/
	
}
