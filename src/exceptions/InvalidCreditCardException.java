package exceptions;

public class InvalidCreditCardException extends RuntimeException {

	public InvalidCreditCardException() {
		super("You entered invalid credit card number. Valid credit card should contain 16 digits. Please, try one more time");
	}
}
