package domain;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: InstanceNotifcation
 *
 */
@Entity

public class InstanceNotifcation implements Serializable {

	@Id
	private int id;
	
	private String timeofstarting;
	private String timeofstoping;   
	
	private static final long serialVersionUID = 1L;

	public InstanceNotifcation() {
		super();
	}   
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTimeofstarting() {
		return this.timeofstarting;
	}

	public void setTimeofstarting(String timeofstarting) {
		this.timeofstarting = timeofstarting;
	}   
	public String getTimeofstoping() {
		return this.timeofstoping;
	}

	public void setTimeofstoping(String timeofstoping) {
		this.timeofstoping = timeofstoping;
	}   
	
   
}
