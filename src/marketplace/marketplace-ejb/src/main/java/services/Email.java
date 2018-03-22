package services;

import java.util.Properties;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Singleton
@LocalBean
public class Email {

	/**
	 * Default constructor.
	 */
	public Email() {

		// TODO Auto-generated constructor stub
	}

	/***
	 * 
	 * send email
	 * @param recieverString 
	 * @param subjectString 
	 * @param textString
	 */
	public void send(String recieverString, String subjectString, String textString) {
		final String username = "contact.pimarketplace@gmail.com"; // enter your
																	// mail id
		final String password = "esprit2018";// enter ur password

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("contact.pimarketplace@gmail.com")); // same
																						// email
																						// id
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recieverString));// whome
																									// u
																									// have
																									// to
																									// send
																									// mails
																									// that
																									// person
																									// id
			message.setSubject(subjectString);
			message.setText(textString);

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean isEmailValid(String emailString)
	{boolean result = true;
	   try {
		      InternetAddress emailAddr = new InternetAddress(emailString);
		      emailAddr.validate();
		   } catch (AddressException ex) {
		      result = false;
		   }
		   return result;
		
	}
}
