package exceptions;

public class NoOrdersException extends RuntimeException {
	
	public NoOrdersException() {
		super("You don't have any orders yet.");
	}
}
