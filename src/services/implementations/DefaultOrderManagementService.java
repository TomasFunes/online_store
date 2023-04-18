package services.implementations;
import services.OrderManagementService;

import java.util.Arrays;

import entities.Order;
import entities.implementations.*;

public class DefaultOrderManagementService implements OrderManagementService {
	
	private static DefaultOrderManagementService instance;
	
	Order[] orders;
	int orderAmount;
	
	private DefaultOrderManagementService() {
		orderAmount = 0;
		orders = new Order[orderAmount];
	}
	
	public void addOrder(Order order) {
		orders = Arrays.copyOf(orders, ++orderAmount);
		orders[orderAmount - 1] = order;
	}
	
	public Order[] getOrdersByUserId(int userId) {
		Order[] userOrders = new Order[orderAmount];
		int i = 0;
		for(Order order : orders) {
			if(order.getCustomerId() == userId) {
				userOrders[i++] = order;
			}
		}
		return Arrays.copyOf(userOrders, i);
	}
	
	public Order[] getOrders() {
		return Arrays.copyOf(orders, orderAmount);
	}
	
	public static DefaultOrderManagementService getInstance() {
		if(instance == null) {
			instance = new DefaultOrderManagementService();
		}
		return instance;
	}
}
