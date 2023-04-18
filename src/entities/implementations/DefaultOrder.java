package entities.implementations;

import java.util.Arrays;

import entities.*;
import exceptions.InvalidCreditCardException;


public class DefaultOrder implements Order {

	private String creditCardNumber;
	private Product[] products;
	private int customerId;
	
	public DefaultOrder() {
		
	}
	
	public DefaultOrder(String creditCardNumber, Product[] products, int customerId) {
		this.creditCardNumber = creditCardNumber;
		this.products = products;
		this.customerId = customerId;
	}
	
	public boolean isCreditCardNumberValid(String userInput) throws InvalidCreditCardException {
		if(userInput.length() != 16) {
			throw new InvalidCreditCardException();
		}
		
		for(char c : userInput.toCharArray()) {
			if(c < '0' || c > '9') {
				throw new InvalidCreditCardException();
			}
		}
		
		return true;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}


	public void setProducts(Product[] products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "[creditCardNumber=" + creditCardNumber + ", products=" + Arrays.toString(products)
				+ ", customerId=" + customerId + "]";
	}
	
}
