package services;

import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Users;

/**
 * Session Bean implementation class Authentication
 */
@Stateless
@LocalBean
public class Authentication implements AuthenticationRemote {
	@EJB
	private Email email;
	@EJB
	private Hashfunction hashfunction;
	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public Authentication() {
		// TODO Auto-generated constructor stub
	}

	public String firststep(String emailString, String passString) {
		 Users users =new Users();
		String key=null ;
		 users=em.find(Users.class, email);
		 if (users!=null)
		 {
			 try {
				if (hashfunction.hash(passString).equals(users.getPassword()));
				key = UUID.randomUUID().toString();
				email.send(users.getEmail(), "second factor\n", "please enter this key to login\n "+key);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return key;
		 }
		return key;
	}

	

}
