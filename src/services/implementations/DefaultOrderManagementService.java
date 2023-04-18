package services.implementations;
import services.OrderManagementService;
import java.util.List;
import java.util.ArrayList;

import java.util.Arrays;

import entities.Order;
import entities.implementations.*;

public class DefaultOrderManagementService implements OrderManagementService {
	
	private static DefaultOrderManagementService instance;
	
	List<Order> orders;
	
	private DefaultOrderManagementService() {
		orders = new ArrayList<>();
	}
	
	public void addOrder(Order order) {
		orders.add(order);
	}
	
	public List<Order> getOrdersByUserId(int userId) {
		List<Order> userOrders = new ArrayList<Order>();
		for(Order order : orders) {
			if(order.getCustomerId() == userId) {
				userOrders.add(order);
			}
		}
		return userOrders;
	}
	
	public List<Order> getOrders() {
		return List.copyOf(orders);
	}
	
	public static DefaultOrderManagementService getInstance() {
		if(instance == null) {
			instance = new DefaultOrderManagementService();
		}
		return instance;
	}
}
