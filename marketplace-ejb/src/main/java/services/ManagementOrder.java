package services;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
import javax.persistence.criteria.Order;
import javax.ws.rs.client.Client;


/**
 * Session Bean implementation class GenerateOrder
 */
@Stateless
public class ManagementOrder implements ManagementOrderRemote {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
	
	//List<Order> listOrder = new ArrayList<Order>();
	
	
	@Override
	public void PassOrder(Order order) {
		// TODO Auto-generated method stub
		em.persist(order);
		
	}

	@Override
	public void Update(Order order) {
		// TODO Auto-generated method stub
		em.merge(order);
		
	}

	@Override
	public void Delete(Order order) {
		// TODO Auto-generated method stub
		em.remove(em.merge(order));
		
	}

	@Override
	public Order FindById(int IdOrder) {
		// TODO Auto-generated method stub
		return em.find(Order.class, IdOrder);
	}

	@Override
	public List<Order> FindByClient(Client client) {
		//Query req =em.createQuery("select c from Client c ");
		return null;
	}

	@Override
	public List<Order> ListOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	
   
}
