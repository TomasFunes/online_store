package entities.implementations;
import java.util.Arrays;

import entities.*;

public class DefaultCart implements Cart{
	
	private Product[] products;
	private int size = 0;
	
	public DefaultCart(){
		products = new Product[size];
	}
	
	@Override
	public boolean isEmpty() {
		return products.length == 0;
	}
	
	@Override
	public void addProduct(Product productById) {
		products = Arrays.copyOf(products, ++size);
		products[size - 1] = productById;
	}
	
	@Override
	public Product[] getProducts() {
		return Arrays.copyOf(products, size);
	}
	
	@Override
	public void clear() {
		size = 0;
		products = new Product[size];
	}
}
