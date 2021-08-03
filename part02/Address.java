package part02;

public class Address {
	
	private int bldNum;
	private String bldStreet;
	private String bldTown;
	private String bldPcode;
	private String bldCountry;
	
//Address Constructor	
	public Address(int bldNum, String bldStreet, String bldTown, String bldPcode, String bldCountry) {
		
		this.bldNum = bldNum;
		this.bldStreet = bldStreet;
		this.bldTown = bldTown;
		this.bldPcode = bldPcode;
		this.bldCountry = bldCountry;
		
	}
	
//Full Address Method
	public String getFullAddress() {
		
		String str1 = bldNum + " " + bldStreet + "\n" + bldTown;
		String str2 = bldPcode;
		String str3 = bldCountry;
		String myStr = str1 + "\n" + str2 + "\n"+ str3;
		return myStr;
		
	}
	
//Getters	
 	public int getBldNum() {
		return bldNum;
	}
	public String getBldStreet() {
		return bldStreet;
	}
	public String getBldTown() {
		return bldTown;
	}
	public String getBldPcode() {
		return bldPcode;
	}
	public String getBldCountry() {
		return bldCountry;
	}

//Setters
	public void setBldNum(int bldNum) {
		this.bldNum = bldNum;
	}
	public void setBldStreet(String bldStreet) {
		this.bldStreet = bldStreet;
	}
	public void setBldTown(String bldTown) {
		this.bldTown = bldTown;
	}
	public void setBldPcode(String bldPcode) {
		this.bldPcode = bldPcode;
	}
	public void setBldCountry(String bldCountry) {
		this.bldCountry = bldCountry;
	}
	
	

}
