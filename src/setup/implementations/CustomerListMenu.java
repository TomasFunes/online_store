package setup.implementations;

import services.implementations.DefaultUserManagementService;

import java.util.Arrays;

import entities.User;
import services.UserManagementService;
import setup.Menu;

public class CustomerListMenu implements Menu {
	
	UserManagementService userManagement = DefaultUserManagementService.getInstance();
	
	public void start() {
		User[] users = userManagement.getUsers();
		for(User user : users) {
			System.out.println(user.toString());
		}
	}
	
	public void printMenuHeader() {
		System.out.println("========== CUSTOMER LIST ==========");
	}
}
