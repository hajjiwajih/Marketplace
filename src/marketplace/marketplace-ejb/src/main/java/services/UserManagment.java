package services;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Users;

/**
 * Session Bean implementation class UserManagment
 */
@Stateless
public class UserManagment implements UserManagmentLocal {

	@PersistenceContext
	EntityManager em;
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
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	public String addUser(Users users)  {
		users.setPassword(hashfunction.hash(users.getPassword()));
		em.persist(users);
		return ("added");
	}
	public Users findUsers(String emailString)
	{
		return (em.find(Users.class, emailString));
	}
}
