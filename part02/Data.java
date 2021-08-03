package part02;

import java.util.ArrayList;

public class Data {

	public static Supplier getSupplier1() {
		
		ArrayList<Product> productAl = new ArrayList<Product>();
		
		//Address
		Address add1 = new Address(1000, "Hillswood Drive", "London", "WC2N 5DU", "United Kingdom");
        
		//Products here
		Product prod1 = new Product(55555, "Samsung", "MW700", 79.99, 10, false);
        Product prod2 = new Product(741258, "Samsung", "Galaxy S7 Edge", 599.99, 78, false);
        
        //adds the products to array list
        productAl.add(prod1);
        productAl.add(prod2);
        
        Supplier sup1 = new Supplier(587231, "Samsung", add1, SupRegion.UNITED_KINGDOM, productAl);
		
        return sup1;
        
	}
	
	public static Supplier getSupplier2() {
		
		ArrayList<Product> productAl = new ArrayList<Product>();
		
		//Address
		Address add1 = new Address(40, "The Heights, Brooklands", "Paris", "PT13 0XW", "France");
		
		//Products Here
		Product prod1 = new Product(47587, "Sony", "Bravia 7800", 1299.99, 23, false);
		Product prod2 = new Product(180259, "Sony", "Playstation 4 Pro", 299.99, 500, false);
		
		//adds the products to array list
		productAl.add(prod1);
		productAl.add(prod2);
		
		Supplier sup2 = new Supplier(421784, "Sony", add1, SupRegion.EUROPE, productAl);
		
		return sup2;
		
	}
	
	public static Supplier getSupplier3() {
		
		ArrayList<Product> productAl = new ArrayList<Product>();
		
		Address add1 = new Address(1600, "Amphitheatre Parkway", "California", "CA 94043", "United States");
		
		Product prod1 = new Product(196417, "Google", "Home - White", 77.50, 100, false);
		Product prod2 = new Product(215160, "Google", "Pixel 2 64GB", 629.00, 53, false);
		
		productAl.add(prod1);
		productAl.add(prod2);
		
		Supplier sup3 = new Supplier(154987, "Google", add1, SupRegion.OUTSIDE_EU, productAl);
		
		return sup3;
		
	}

}
