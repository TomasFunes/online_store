package setup.implementations;

import entities.*;
import entities.implementations.*;
import setup.*;
import services.implementations.*;
import java.util.Scanner;
import java.util.List;

public class CheckoutMenu implements Menu {
	
	DefaultOrderManagementService orderManagement = DefaultOrderManagementService.getInstance();
	ApplicationContext context = ApplicationContext.getInstance();
	Order order = new DefaultOrder();
	
	public void start() {
		printMenuHeader();
		
		Scanner sc = new Scanner(System.in);
		List<Product> products = context.getSessionCart().getProducts();
		int customerId = context.getLoggedInUser().getId();
		
		System.out.println("Enter your credit card number without spaces and press enter to confirm purchase.");
		String creditCardInput = sc.next();

		order.isCreditCardNumberValid(creditCardInput);
		orderManagement.addOrder(new DefaultOrder(creditCardInput, products, customerId));
		context.getSessionCart().clear();
		System.out.println("Thanks a lot for your purchase. Details about order delivery are sent to your email.");
	}
	
	public void printMenuHeader() {
		System.out.println("========== CHECKOUT MENU ==========");
	}
}
