package services;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class CommandeManagment
 */
@Stateless
@LocalBean
public class CommandeManagment implements CommandeManagmentLocal {

    /**
     * Default constructor. 
     */
    public CommandeManagment() {
        // TODO Auto-generated constructor stub
    }

    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private List<Date> Startdate= new ArrayList<Date>() ;


	public String StartTime(){
		 Date date = new Date();

	        return sdf.format(date);
	}

	public String StopTime() {
		 Date date = new Date();

		return sdf.format(date);
		
	}

	public List<Date> getStartdate() {
		return Startdate;
	}

	public void setStartdate(List<Date> startdate) {
		Startdate = startdate;
	}
}
