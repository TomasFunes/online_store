package setup.implementations;

import setup.ApplicationContext;
import exceptions.*;
import setup.Menu;
import java.util.Scanner;
import entities.*;
import services.*;
import services.implementations.*;

public class SettingsMenu implements Menu {

	private static String SETTINGS_MENU = "1. Change password\n"
										+ "2. Change email\n"
										+ "Enter 'menu' to go back";
	
	ApplicationContext context = ApplicationContext.getInstance();
	DefaultUserManagementService userManagement = DefaultUserManagementService.getInstance();
	
	public void start() throws NotLoggedInException {
		if(context.getLoggedInUser() == null) {
			throw new NotLoggedInException();
		}
		
		Scanner sc = new Scanner(System.in);
		printMenuHeader();
		User currentUser = context.getLoggedInUser();
		System.out.println(SETTINGS_MENU);
		boolean goBack = false;
		
		while(!goBack) {
			String choice = sc.next();
			switch(choice) {
			case "1":
				System.out.println("Please enter new password: ");
				String password = sc.next();
				currentUser.setPassword(password);
				System.out.println("Your password has been successfully changed");
				goBack = true;
				break;
			case "2":
				System.out.println("Please enter new email: ");
				String email = sc.next();
				if(userManagement.verifyEmail(email)) {
					currentUser.setEmail(email);
					goBack = true;
				}
				else {
					System.out.println("Email is not valid or not unique. Please try again");
				}
				break;
			case "menu":
				goBack = true;
				break;
			default:
				System.out.println("Only 1, 2 is allowed. Try one more time");
			}
		}
		
	}
	
	public void printMenuHeader() {
		System.out.println("========== SETTINGS ==========");
	}
}
