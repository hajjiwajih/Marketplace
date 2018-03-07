package services;

import javax.ejb.Local;

import domain.Users;

@Local
public interface UserManagmentLocal {
	public String addUser(Users users) ;

}
