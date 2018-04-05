package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

public class Order implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int idOrder;
	Date date;
	
@ManyToOne
	private client client;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
    public int getId() {
		return idOrder;
	}
    public void setId(int id) {
		this.idOrder = id;
	}

	public client getClient() {
		return client;
	}
	public void setClient(client client) {
		this.client = client;
	}
		//@Temporal(TemporalType.TIMESTAMP)
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
