package setup.implementations;

import services.implementations.DefaultUserManagementService;


import entities.User;
import services.UserManagementService;
import setup.Menu;
import java.util.List;

public class CustomerListMenu implements Menu {
	
	UserManagementService userManagement = DefaultUserManagementService.getInstance();
	
	public void start() {
		List<User> users = userManagement.getUsers();
		for(User user : users) {
			System.out.println(user.toString());
		}
	}
	
	public void printMenuHeader() {
		System.out.println("========== CUSTOMER LIST ==========");
	}
}
