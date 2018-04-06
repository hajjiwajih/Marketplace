package services;

import javax.ejb.Local;

import domain.Transaction;

@Local
public interface PaymentLocal {

	String Add_trasaction(Transaction transaction);
	Boolean findTransaction(String hashString);
}	
