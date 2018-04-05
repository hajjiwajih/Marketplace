package services;

import java.util.List;

import javax.ejb.Remote;
import javax.persistence.criteria.Order;
import javax.ws.rs.client.Client;

@Remote
public interface ManagementOrderRemote{
	
	public void PassOrder(Order order);
	public void Update(Order order);
	public void Delete(Order order);
	public Order FindById(int IdOrder);
	public List<Order> ListOrder();
	public List<Order> FindByClient(Client client);

}
