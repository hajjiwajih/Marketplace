package services;

import javax.ejb.Local;

@Local
public interface PaymentLocal {

	float getcurentsold(String walletidString);
	boolean payout(String walletidString, float value);
	 String Add_trasaction(String hachString);
}
