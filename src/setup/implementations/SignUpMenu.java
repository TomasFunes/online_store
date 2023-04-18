package setup.implementations;
import setup.*;
import services.UserManagementService;
import services.implementations.DefaultUserManagementService;
import entities.implementations.*;
import entities.*;

import java.util.Scanner;

public class SignUpMenu implements Menu {
	
	
	private UserManagementService userManagementService = DefaultUserManagementService.getInstance();
	
	public void start() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your first name: ");
		String firstName = sc.next();
		System.out.println("Enter your last name: ");
		String lastName = sc.next();
		System.out.println("Enter your password: ");
		String password = sc.next();
		System.out.println("Enter your email: ");
		String email = sc.next();
		
		User user = new DefaultUser(firstName, lastName, password, email);
		System.out.println(userManagementService.registerUser(user));
		
		
	}
	
	public void printMenuHeader() {
		System.out.println();
		System.out.println("========== SIGN UP ==========");
		System.out.println();
	}
}
