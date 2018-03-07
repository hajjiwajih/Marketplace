package services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Users;

/**
 * Session Bean implementation class UserManagment
 */
@Stateless
public class UserManagment implements  UserManagmentLocal {
	
	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public UserManagment() {
        // TODO Auto-generated constructor stub
    }

	/***
	 * add user to the database
	 */
	public String addUser(Users users) {
		em.merge(users);
		return null;
	}

}
