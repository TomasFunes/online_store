package comparators;
import java.util.Comparator;
import entities.Product;

public class CustomProductComparator implements Comparator<Product>{
	
	public int compare(Product o1, Product o2) {
		
		return (o1.getCategoryName().compareTo(o2.getCategoryName()) != 0 ) ? 
				o1.getCategoryName().compareTo(o2.getCategoryName()) : 
					(o1.getProductPrice() > o2.getProductPrice())? 1 :
						(o1.getProductPrice() < o2.getProductPrice())? -1 : 0;
	}
}
