package org.flightmanagementsystem.Service;

import java.math.BigInteger;
import java.util.List;

import org.flightmanagementsystem.model.User;

public interface UserService {
//Add user method
	User addUser(User user);
	
	//Find a single user
	User viewUser(BigInteger id);
	
	//Find all user
	List<User> viewAllUser();
	
	//Update user
	User updateUser(User user, BigInteger id);
	
	//Delete user
	void deleteUser(BigInteger id);
}
