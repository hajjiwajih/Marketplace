package services;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Users;
import domain.client;
import domain.tmpuser;

/**
 * Session Bean implementation class UserManagment
 */
@Stateless
@LocalBean
public class UserManagment implements UserManagmentLocal {

	@PersistenceContext
	EntityManager em;
	@EJB
	private Email email;
	@EJB
	private Hashfunction hashfunction;

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

	/**
	 * find users
	 */
	public Users findUsers(String emailString) {
		return (em.find(Users.class, emailString));
	}

	/***
	 * register user temporory
	 */
	@Override
	public boolean registrationRequest(tmpuser tmpuser) {
		String key = UUID.randomUUID().toString();
		try {
			tmpuser.setPassword(hashfunction.hash(tmpuser.getPassword()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tmpuser.setPrivatekey(key);
		email.send(tmpuser.getEmail(), "Market place registration",
				"hello \n thank your for registratiion in our serverice \n In order to confirm your account please click on the link\n http://127.0.0.1:18080/marketplace-web/api/inscription/" + key);
		em.persist(tmpuser);
		return true;

	}

	/***
	 * confirm user registration and delete it form temp user
	 */
	@Override
	public boolean RegistrationConfirmation(String Key) {
		tmpuser tmpuser = new tmpuser();
		tmpuser = em.find(tmpuser.class, Key);
		if (tmpuser != null) {
			client client = new client();
			client.setActive(true);
			client.setAdress(tmpuser.getAdress());
			client.setEmail(tmpuser.getEmail());
			client.setFirstName(tmpuser.getFirstName());
			client.setLastName(tmpuser.getLastName());
			client.setPassword(tmpuser.getPassword());
			client.setWalletID("stactic test");
			email.send(client.getEmail(), "incription validated",
					"welcome to our service \n your wallet id id " + client.getWalletID());
			em.persist(client);
			em.remove(tmpuser);
			return true;
		}

		return false;

	}

	@Override
	public boolean updateUser(Users users) {
		em.merge(users);
		return true;
	}

}
