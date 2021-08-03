package part01;

import java.util.ArrayList;

public class Supplier {
	
	private int supCode;
	private String supName;
	private Address supAddress;
	private SupRegion supRegion;
	private ArrayList<Product> supProducts = new ArrayList<Product>();
	
//Supplier Constructor		
	public Supplier(int supCode, String supName, Address supAddress, SupRegion supRegion,
			ArrayList<Product> supProducts) {
		
		this.supCode = supCode;
		this.supName = supName;
		this.supAddress = supAddress;
		this.supRegion = supRegion;
		this.supProducts = supProducts;
	}
	
	
//Print Products Method
	public void printProductList() {
		
		for(int i = 0; i < supProducts.size(); i++) {
			System.out.println(	supProducts.get(i).getProductDetails());
		}
		
	}
	
	
//Getters	
	public int getSupCode() {
		return supCode;
	}
	public String getSupName() {
		return supName;
	}
	public Address getSupAddress() {
		return supAddress;
	}
	public SupRegion getSupRegion() {
		return supRegion;
	}
	public ArrayList<Product> getSupProducts() {
		return supProducts;
	}
	
//Setters	
	public void setSupCode(int supCode) {
		this.supCode = supCode;
	}
	public void setSupName(String supName) {
		this.supName = supName;
	}
	public void setSupAddress(Address supAddress) {
		this.supAddress = supAddress;
	}
	public void setSupRegion(SupRegion supRegion) {
		this.supRegion = supRegion;
	}
	public void setSupProducts(ArrayList<Product> supProducts) {
		this.supProducts = supProducts;
	}
	
	

}
