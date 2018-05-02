package com.Marketplace.AzureApp;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class CreateVM {
	
	
	
	



	

		 
		private static final long serialVersionUID = 1L;
		

		public CreateVM() {
			// TODO Auto-generated constructor stub
		} 

		private String username = null;
		private String password = null;
		private String MachineNAME = null;
		private String resourcename = null;
		
		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getMachineNAME() {
			return MachineNAME;
		}

		public void setMachineNAME(String machineNAME) {
			MachineNAME = machineNAME;
		}

		public String getResourcename() {
			return resourcename;
		}

		public void setResourcename(String resourcename) {
			this.resourcename = resourcename;
		}
/*
		public String createvm () {
			String navto=""; 
			
				 createvm = new tmpuser();
				tmpuser.setAdress(adress);
				tmpuser.setEmail(email);
				tmpuser.setFirstName(firstName);
				tmpuser.setLastName(lastName);
				tmpuser.setPassword(password);
				tmpuser.setPhoneNumber(phoneNumber);
				userManagmentLocal.registrationRequest(tmpuser);
				navto="registersuccessfully";
			}
			FacesMessage msg = new FacesMessage("bad credentials");
			FacesContext.getCurrentInstance().addMessage("form_login:btn_login", msg);
			return navto;
			
			
		}
*/

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
}
