package domain;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Transaction
 *
 */
@Entity

public class Transaction implements Serializable {

	   
	@Id
	private String hash;
	private float value;
	private String sender_id;
	private String reciever_id;

	

	private static final long serialVersionUID = 1L;

	public Transaction() {
		super();
	}   
	public String getHash() {
		return this.hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}   


	public float getValue() {
		return this.value;
	}

	public void setValue(float value) {
		this.value = value;
	}   
	public String getSender_id() {
		return this.sender_id;
	}

	public void setSender_id(String sender_id) {
		this.sender_id = sender_id;
	}
	public String getReciever_id() {
		return reciever_id;
	}
	public void setReciever_id(String reciever_id) {
		this.reciever_id = reciever_id;
	}   
	
   
}
