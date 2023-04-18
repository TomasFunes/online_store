package exceptions;

public class EmptyCartException extends RuntimeException {

	public EmptyCartException() {
		super("Your cart is empty. Please, add product to cart first and then proceed with checkout");
	}
}
