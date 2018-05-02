package pi.marketplace.web;

import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import services.Payment;

@SessionScoped
@ManagedBean
public class Transaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private Payment payment;
	private String hash = "";
	private float sold = 0;

	public String hashverif() {

		try {
			String url = "https://dogechain.info/api/v1/transaction/" + hash;
			String genreJson = IOUtils.toString(new URL(url));
			JSONObject json = new JSONObject(genreJson);
			if (json.getInt("success") == 1) {
				domain.Transaction transaction = new domain.Transaction();

				transaction.setHash(json.getJSONObject("transaction").get("hash").toString());
				transaction.setValue(json.getJSONObject("transaction").getFloat("outputs_value"));
				transaction.setSender_id(
						json.getJSONObject("transaction").getJSONArray("inputs").getJSONObject(0).getString("address"));
				transaction.setReciever_id(json.getJSONObject("transaction").getJSONArray("outputs").getJSONObject(0)
						.getString("address"));
				sold = 0;
				if (transaction.getValue() > sold) {
					if (payment.findTransaction(transaction.getHash()) == false) {
						payment.Add_trasaction(transaction);
						return ("login.jsf");
					}
				}
			} else {
				return "error.jsf";
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error.jsf";
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public float getSold() {
		return sold;
	}

	public void setSold(float sold) {
		this.sold = sold;
	}

}
