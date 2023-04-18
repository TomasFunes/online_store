package entities.implementations;
import java.util.List;
import java.util.ArrayList;

import entities.*;

public class DefaultCart implements Cart{
	
	private List<Product> products;
	
	public DefaultCart(){
		products = new ArrayList<>();
	}
	
	@Override
	public boolean isEmpty() {
		return products.size() == 0;
	}
	
	@Override
	public void addProduct(Product productById) {
		products.add(productById);
	}
	
	@Override
	public List<Product> getProducts() {
		return List.copyOf(products);
	}
	
	@Override
	public void clear() {
		products = new ArrayList<>();
	}
}
