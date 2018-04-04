package services;

import java.net.MalformedURLException;
import java.net.URL;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	public float getcurentsold(String walletidString) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean payout(String walletidString, float value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String Add_trasaction(String hachString) {
		
		try {
			URL url= new URL("https://dogechain.info/api/v1/transaction/"+hachString);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return null;
	}

}
