package services;

import java.util.Random;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.ClientNonValid;

/**
 * Session Bean implementation class UserRegistration
 */
@Stateless
@LocalBean
public class UserRegistration implements UserRegistrationRemote {
	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public UserRegistration() {
		// TODO Auto-generated constructor stub
	}

	
	public String RegistrationRequest(ClientNonValid clientNonValid) {
		while (true) {
			int keyRandom = 12315;
			if (em.find(ClientNonValid.class, keyRandom) == null) {
				clientNonValid.setKey(keyRandom);
				em.persist(clientNonValid);
				return ("added");
			}
		}
	}

	public String RegistrationValidation(int id) {
		
		return null;
	}

}
