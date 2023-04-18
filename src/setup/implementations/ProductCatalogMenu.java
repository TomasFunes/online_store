package setup.implementations;
import setup.*;
import services.implementations.*;
import java.util.Scanner;
import entities.*;
import exceptions.*;

public class ProductCatalogMenu implements Menu {
	
	DefaultProductManagementService productManagement = DefaultProductManagementService.getInstance();
	ApplicationContext context = ApplicationContext.getInstance();
	Cart cart = context.getSessionCart();
	Product[]products = productManagement.getProducts();
	
	private static String EMPTY_CART_STATEMENT = "Enter product id to add it to the cart or 'menu' to go back to the main menu";
	private static String NON_EMPTY_CART_STATEMENT = "If you want to add a new product - enter the product id.\n"
													+ "If you want to proceed with checkout - enter word 'checkout'";
	
	private static String INVALID_INPUT_MESSAGE = "The id entered is not in product catalog. Please try again";
	
	public void start() {
		System.out.println("========== PRODUCT CATALOG ==========");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		boolean goBack = false;
		
		while(!goBack) {
			printMenuHeader();
			String input = sc.next();
			
			switch(input) {
				case "menu":
					goBack = true;
					break;
				case "checkout":
					try {
						if(context.getLoggedInUser() == null) {
							throw new NotLoggedInException();
						}
						if(cart.getProducts().length == 0) {
							throw new EmptyCartException();
						}
						Menu menu = new CheckoutMenu();
						menu.start();
						goBack = true;
						
					}catch(NotLoggedInException e) {
						System.out.println(e.getMessage());
						goBack = true;
					}catch(EmptyCartException  |  InvalidCreditCardException e) {
						System.out.println(e.getMessage());
					}
				
					break;
				default:
					try {
						Product productToAdd = productManagement.getProductById(Integer.parseInt(input));
						cart.addProduct(productToAdd);
						System.out.println("Product " + productToAdd.getProductName() + " has been added to your cart");
						System.out.println();
					}catch(NullPointerException | NumberFormatException e) {
						System.out.println(INVALID_INPUT_MESSAGE);
						System.out.println();
					}
			}			
		}
	}
	
	public void printMenuHeader() {

		if(cart.isEmpty()) {
			System.out.println(EMPTY_CART_STATEMENT);
		}
		else {
			System.out.println(NON_EMPTY_CART_STATEMENT);
		}
		System.out.println();
		for(Product product : products) {
			System.out.println(product);
		}
	}
}
