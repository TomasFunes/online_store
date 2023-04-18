package entities.implementations;
import entities.Product;

public class DefaultProduct implements Product {
	
	private int id;
	private String productName;
	private String categoryName;
	private double productPrice;
	
	public DefaultProduct(int id, String productName, String categoryName, double productPrice) {
		this.id = id;
		this.productName = productName;
		this.categoryName = categoryName;
		this.productPrice = productPrice;
		
		
	}

	public int getId() {
		return id;
	}

	public String getProductName() {
		return productName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	@Override
	public String toString() {
		return "[ID: " + id + ", Product: " + productName + ", Category: " + categoryName
				+ ", Price: " + productPrice + "]";
	}
	
	
}
