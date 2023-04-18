package setup.implementations;

import setup.ApplicationContext;
import setup.*;
import services.implementations.*;
import java.util.Scanner;
import entities.*;

public class SignInMenu implements Menu {
	
	private ApplicationContext context = ApplicationContext.getInstance();
	private DefaultUserManagementService userManagement = DefaultUserManagementService.getInstance();	
	
	public void start() {
		printMenuHeader();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please, enter your email: ");
		String email = sc.next();
		System.out.println("Enter your password: ");
		String password = sc.next();
		
		if(userManagement.checkCredentials(email, password)) {
			User user = userManagement.getUserByEmail(email);
			context.setLoggedInUser(user);
			System.out.println("Glad to see you back " + user.getFirstName() + " " + user.getLastName());
		}
		else {
			System.out.println("Unfortunately, such login and password doesn't exist");
		}
	}
	
	public void printMenuHeader() {
		System.out.println("========== SIGN IN ==========");
	}
}
