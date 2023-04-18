package setup.implementations;
import setup.*;
import exceptions.*;
import java.util.Scanner;

public class MainMenu implements Menu {
	
	private static String SIGN_IN_MENU  = "1. Sign Up\n"
										+ "2. Sign In\n"
										+ "3. Product Catalog\n"
										+ "4. My Orders\n"
										+ "5. Settings\n"
										+ "6. Customer List";
	
	private static String SIGN_OUT_MENU = "1. Sign Up\n"
										+ "2. Sign out\n"
										+ "3. Product Catalog\n"
										+ "4. My Orders\n"
										+ "5. Settings\n"
										+ "6. Customer List";
	
	private ApplicationContext context;
	
	{
		context = ApplicationContext.getInstance();
	}
	
	
	
	@Override
	public void start() {
		if(context.getMainMenu() == null) {
			context.setMainMenu(this);
		}
		
		while(true) {
			printMenuHeader();
			Scanner sc = new Scanner(System.in);
			String choice = sc.next();
			Menu menu;
			
			try {
				switch(choice) {
				case "1":
					menu = new SignUpMenu();
					menu.start();
					break;
				case "2":
					if(context.getLoggedInUser() == null) {
						menu = new SignInMenu();
						menu.start();
					}
					else {
						context.setLoggedInUser(null);
						System.out.println("Have a nice day!");
					}
					break;
				case "3":
					menu = new ProductCatalogMenu();
					menu.start();
					break;
				case "4":
					menu = new MyOrdersMenu();
					menu.start();
					break;
				case "5":
					menu = new SettingsMenu();
					menu.start();
					break;
				case "6":
					menu = new CustomerListMenu();
					menu.start();
					break;
				case "exit":
					
					break;
				default:
					System.out.println("Only 1, 2, 3, 4, 5, 6 is allowed. Please try again.");
				}
			}catch(NotLoggedInException | NoOrdersException e) {
				System.out.println(e.getMessage());
			}
		}
			
	}
	
	public void printMenuHeader(){
		System.out.println("========== MAIN MENU ==========");
		if(context.getLoggedInUser() == null) {
			System.out.println(SIGN_IN_MENU);
		}
		else {
			System.out.println(SIGN_OUT_MENU);
		}
	}
}
