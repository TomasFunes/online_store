package setup.implementations;

import services.implementations.DefaultOrderManagementService;
import java.util.List;
import setup.ApplicationContext;
import services.OrderManagementService;
import entities.Order;
import setup.Menu;
import exceptions.*;

public class MyOrdersMenu implements Menu {
	
	OrderManagementService orderManagement = DefaultOrderManagementService.getInstance();
	ApplicationContext context = ApplicationContext.getInstance();
	
	public void start() throws NotLoggedInException, NoOrdersException {
		

		if(context.getLoggedInUser() == null) {
			throw new NotLoggedInException();
		}
		
		int userId = context.getLoggedInUser().getId();
		List<Order> orders = orderManagement.getOrdersByUserId(userId);

		if(orders.size() == 0 ) {
			throw new NoOrdersException();
		}
		
		printMenuHeader();
		
		for(Order order : orders) {
			System.out.println(order.toString());
		}
	}
	
	
	public void printMenuHeader(){
		System.out.println("========== MY ORDERS ==========");
	}
}
