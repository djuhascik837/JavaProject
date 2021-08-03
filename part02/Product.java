package part02;

public class Product {
	
	private int proCode;
	private String proMake;
	private String proModel;
	private double proPrice;
	private int proQtyAvailable;
	private boolean proDiscontinued;
	
//Product Constructor	
	public Product(int proCode, String proMake, String proModel, double proPrice, int proQtyAvailable, boolean proDiscontinued) {
		
		this.proCode = proCode;
		this.proMake = proMake;
		this.proModel = proModel;
		this.proPrice = proPrice;
		this.proQtyAvailable = proQtyAvailable;
		this.proDiscontinued = proDiscontinued;
		
	}

//Product Details Method	
	public String getProductDetails() {
		
		System.out.println("--------------------");
		String str1 = "(" + proCode + ") " + proMake + " " + proModel;
		String str2 = String.format("Price: £%.2f \nStock: %d", proPrice, proQtyAvailable);
		String str3 = proDiscontinued ? "Yes" : "No";
		String myStr = str1 + "\n" + str2 + "\nDiscontinued? " + str3;
		return myStr;
		
	}
	
//Getters
	public int getProCode() {
		return proCode;
	}
	public String getProMake() {
		return proMake;
	}
	public String getProModel() {
		return proModel;
	}
	public double getProPrice() {
		return proPrice;
	}
	public int getProQtyAvailable() {
		return proQtyAvailable;
	}
	public boolean isProDiscontinued() {
		return proDiscontinued;
	}
	
//Setters	
	public void setProCode(int proCode) {
		this.proCode = proCode;
	}
	public void setProMake(String proMake) {
		this.proMake = proMake;
	}
	public void setProModel(String proModel) {
		this.proModel = proModel;
	}
	public void setProPrice(double proPrice) {
		this.proPrice = proPrice;
	}
	public void setProQtyAvailable(int proQtyAvailable) {
		this.proQtyAvailable = proQtyAvailable;
	}
	public void setProDiscountinued(boolean proDiscontinued) {
		this.proDiscontinued = proDiscontinued;
	}
	
	

}
