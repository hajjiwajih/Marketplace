package services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Transaction;

/**
 * Session Bean implementation class Payment
 */
@Stateless
@LocalBean
public class Payment implements PaymentLocal {

	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public Payment() {
		// TODO Auto-generated constructor stub
	}
 
	@Override
	public String Add_trasaction(Transaction transaction) {
		em.persist(transaction);
		return "added";
	}

	@Override
	public Boolean findTransaction(String hashString) {
		if(em.find(Transaction.class, hashString) != null)
			return true;
		return false;
	}

}
