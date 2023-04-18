package services.implementations;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import services.*;
import setup.ApplicationContext;
import entities.*;

public class DefaultUserManagementService implements UserManagementService {

	private User[] users;
	private int size = 0;
	private static DefaultUserManagementService instance;
	private ApplicationContext context = ApplicationContext.getInstance();
	private static final String NOT_VALID_EMAIL = "You have to input email to register. Please, try one more time";
	private static final String NOT_UNIQUE_EMAIL = "This email is already user by another user. Please, use another email";
	private static final String SUCCESSFUL_VALIDATION = "New user is created";
	
	private DefaultUserManagementService() {
		users = new User[0];
	}
	
	public static DefaultUserManagementService getInstance() {
		if(instance == null) {
			instance = new DefaultUserManagementService();
		}
		return instance;
	}
	
	public String registerUser(User user) {
		String notification;
		
		if(!isValidEmail(user.getEmail())) {
			notification = NOT_VALID_EMAIL;
		}
		else if(!isUniqueEmail(user.getEmail())) {
			notification = NOT_UNIQUE_EMAIL;
		}
		else{
			users = Arrays.copyOf(users, ++size);
			users[size - 1] = user;
			context.setLoggedInUser(user);
			notification = SUCCESSFUL_VALIDATION;
		}
		
		return notification;
	}
	
	public boolean checkCredentials (String email, String password) {
		boolean validCredentials = false;
		for(User user : users) {
			if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
				validCredentials = true;
				break;
			}
		}
		return validCredentials;
	}
	
	public User[] getUsers() {
		return Arrays.copyOf(users, size);
	}
	
	public User getUserByEmail(String userEmail) {
		User foundUser = null;
		for(User user : users) {
			if(user.getEmail().equals(userEmail)) {
				foundUser = user;
				break;
			}
		}
		return foundUser;
	}
	
	public boolean verifyEmail(String email) {
		return isValidEmail(email) && isUniqueEmail(email);
	}
	
	
	private boolean isValidEmail(String email) {
		boolean valid = false;
		
		String gmailPattern = "[a-zA-Z-\\d]+@(gmail|hotmail|outlook)\\.com";
		Pattern p = Pattern.compile(gmailPattern);
		
		Matcher m = p.matcher(email);
		
		if(m.find()) {
			valid = true;
		}
		
		return valid;

	}
	
	private boolean isUniqueEmail(String email) {
		boolean isUnique = true;
		for(User user : users) {
			if(user.getEmail().equals(email)) {
				isUnique = false;
				break;
			}
		}
		
		return isUnique;
	}
}
