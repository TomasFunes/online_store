package exceptions;

public class NotLoggedInException extends RuntimeException {
	
	public NotLoggedInException() {
		super("You are not logged in. Please, sign in or create a new account.");
	}
}
