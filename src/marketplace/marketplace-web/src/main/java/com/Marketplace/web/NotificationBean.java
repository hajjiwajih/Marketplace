package com.Marketplace.web;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.SessionScoped;

import services.CommandeManagmentLocal;

@SessionScoped
@Stateless
public class NotificationBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	CommandeManagmentLocal ntf;
	
	public String StartTime() {
	 return ntf.StartTime();
	}
	public String StopTime() {
		return ntf.StopTime();
	}
}
