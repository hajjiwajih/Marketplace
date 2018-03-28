package services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Payment
 */
@Stateless
@LocalBean
public class Payment implements PaymentLocal {

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

}
