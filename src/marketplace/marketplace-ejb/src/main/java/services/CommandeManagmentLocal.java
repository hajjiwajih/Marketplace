package services;

import javax.ejb.Local;

@Local
public interface CommandeManagmentLocal {
	
	public String StartTime();
	public String StopTime();


}
