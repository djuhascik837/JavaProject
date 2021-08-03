package part01;

import java.util.ArrayList;
import java.util.Scanner;

public class TesterSupplierApp {
	
	//Instance Variables that I can use throughout the class.
	private static Scanner mySc = new Scanner(System.in);
	private static ArrayList<Supplier> supplierAl = new ArrayList<Supplier>(); 

//Main Method
	public static void main(String[] args) {
		
		supplierAl.add(Data.getSupplier1());
        supplierAl.add(Data.getSupplier2());
        supplierAl.add(Data.getSupplier3());
        
        mainMenu();
        

	}
	
	//Menu
	public static void mainMenu() {
	
		System.out.println("\n----Please choose an option from the menu----\n");	
		System.out.println("A. Print All Products.");
		System.out.println("B. Add New Supplier.");
		System.out.println("C. Add New Product");
		System.out.println("D. Exit \n");
		System.out.print("Choose Option: ");
		userInput();
		
	}
	
	
//UserInput	
	public static void userInput() {
		String userInput = mySc.nextLine().toUpperCase();
		userOption(userInput);
	}

	
//User Option, checks what user inputs	
	public static void userOption(String userInput) {
		if(userInput.equals("A")) {
			printAllProducts();
		} else if (userInput.equals("B")) {
			addNewSupplier();
		} else if (userInput.equals("C")) {
			addNewProduct(true);
		} else if (userInput.equals("D")) {
			exit();
		}  else {
			System.out.println("Invalid answer, try again.");
			System.out.print("Choose Option: ");
			userInput();
		}
	}
	
//Prints all Products	
	public static void printAllProducts() {
		
		boolean isMenu = false;
		
		System.out.println("\n----All Products----");
		for(int i = 0; i < supplierAl.size(); i++) {
			System.out.println("\n----" + supplierAl.get(i).getSupName() + "----");
			supplierAl.get(i).printProductList();
		}
		
		System.out.println("--------------------");
		System.out.println("Type menu to take you to the Main menu, or Exit to exit the application.");
		System.out.print("Option here: ");
		
		
		while (isMenu == false) {
		String userInput = mySc.nextLine().toUpperCase();
		if (userInput.equals("MENU")) {
			mainMenu();
			isMenu = true;
		} else if (userInput.equals("EXIT")) {
			exit();
			isMenu = true;
		} else {
			System.out.println("Invalid Option, try again.");
			System.out.print("Option here: ");
			isMenu = false;
		}
		
		}
		System.out.println("\n--------------------");
		
	}

//Add New Supplier	
	public static void addNewSupplier() {
		
		//Variables
		ArrayList<Product> newProduct = new ArrayList<Product>();
		SupRegion newRegion = SupRegion.UNITED_KINGDOM;
		boolean isSupRegion = true;
		boolean addNewPro = true;
		
		
		System.out.println("\n----Add a New Supplier----\n");
		System.out.print("Supplier Code: ");
		int supCode = mySc.nextInt();
		mySc.nextLine();
		
		System.out.print("Supplier Name: ");
		String supName = mySc.nextLine();
		
		Address newSupAddress = addNewAddress();
		
		System.out.println("Please select Supplier Region: ");
		System.out.println("A. United Kingdom");
		System.out.println("B. Europe ");
		System.out.println("C. Other \n");
		System.out.print("Choose Option: ");
		
		//Validates whether input is correct if not repeats steps.
		while (isSupRegion == true) {
			
		String userOption = mySc.nextLine().toUpperCase();
			if (userOption.equals("A")) {
				newRegion = SupRegion.UNITED_KINGDOM;
				isSupRegion = false;
			} else if (userOption.equals("B")) {
				newRegion = SupRegion.EUROPE;
				isSupRegion = false;
			} else if (userOption.equals("C")) {
				newRegion = SupRegion.OUTSIDE_EU;
				isSupRegion = false;
			} else {
				System.out.println("Invalid option, please try again.");
				isSupRegion = true;
			}//if
		}//while
		
		//Runs add new product method
		newProduct.add(addNewProduct(false));
		
		//checks if user wants to add another product to the supplier
		while(addNewPro == true) {
			
			System.out.print("Would you like to add another product, yes or no: ");
			String newPro = mySc.nextLine().toUpperCase();
			
			if (newPro.equals("YES")) {
				newProduct.add(addNewProduct(false));
			} else if (newPro.equals("NO")) {
				addNewPro = false;
			} else {
				System.out.println("Invalid Option, please try again");
			}//if
			
		}//while
		
		Supplier newSup = new Supplier(supCode, supName, newSupAddress, newRegion, newProduct);
		supplierAl.add(newSup);
		
		mainMenu();
		
	}//addNewSupplier method
	
//Add New Address
	public static Address addNewAddress() {
		System.out.println("\n----Add Supplier Address----\n");;
		System.out.print("Building Number: ");
		int bldNum = mySc.nextInt();
		mySc.nextLine();
		
		System.out.print("Street: ");
		String newStreet = mySc.nextLine();
		
		System.out.print("Town: ");
		String newTown = mySc.nextLine();
		
		System.out.print("Post Code: ");
		String newCode = mySc.nextLine().toUpperCase();
		
		System.out.print("Country: ");
		String newCountry = mySc.nextLine();
		
		System.out.println("--------------------");
		
		Address newAdd = new Address(bldNum, newStreet, newTown, newCode, newCountry);
		return newAdd;
		
	}

//Add New Product	
	public static Product addNewProduct(boolean addToSupplier) {
		
		boolean isDiscontinued = true;
		boolean newDiscontinued = true;
		boolean isNewSupValid = true;
		
		System.out.println("\n----Add Product----\n");
		System.out.print("Product Code: ");
		int proCode = mySc.nextInt();
		mySc.nextLine();
		
		System.out.print("Product Make: ");
		String proMake = mySc.nextLine();
		
		System.out.print("Product Model: ");
		String proModel = mySc.nextLine();
		
		System.out.print("Product Price: ");
		double proPrice = mySc.nextDouble();
		mySc.nextLine();
		
		System.out.print("Product Stock: ");
		int proStock = mySc.nextInt();
		mySc.nextLine();
			
		//checks user input for correct answer
			while(isDiscontinued == true) {
				
				System.out.print("Product Discontinued, yes or no: ");
				String proDiscontinued = mySc.nextLine().toUpperCase();
				
				if (proDiscontinued.equals("YES")) {
					isDiscontinued = false;
					newDiscontinued = true;
				} else if (proDiscontinued.equals("NO")) {
					isDiscontinued = false;
					newDiscontinued = false;
				} else {
					System.out.println("Invalid Option, please try again.");
				}
				
			}
		
			
		System.out.println("-------------------");
		System.out.println("The product has been added.");
		System.out.println("-------------------");
		
		Product newProduct = new Product(proCode, proMake, proModel, proPrice, proStock, newDiscontinued);
		
		//checks for supplier of product and whether the product needs added to a supplier
		
		if (addToSupplier == true) {
		
		System.out.print("Which supplier would you like to add this product to: \n");
			
			for (int i = 0; i < supplierAl.size(); i++) {
				System.out.println("- " + supplierAl.get(i).getSupName());
			}//this for loop prints out supplier names that are stored.
			
			System.out.println("--------------------");
			System.out.print("Type name of supplier here: ");
			
			while(isNewSupValid == true) {
				
				String userInput = mySc.nextLine().toUpperCase();
				for (int y = 0; y < supplierAl.size(); y++) {
					
					if(userInput.equals(supplierAl.get(y).getSupName().toUpperCase())) {
						supplierAl.get(y).getSupProducts().add(newProduct);
						isNewSupValid = false;
						}
				}//for loop for adding product to supplier if supplier name matches.
				
				if(isNewSupValid == false) {
					System.out.println("--------------------");
					System.out.println("The product has been added to supplier: " + userInput.toUpperCase());
					System.out.println("--------------------");
				} else if (isNewSupValid == true) {
					System.out.print("Invalid option, please try again: ");
				}
			
			}//add to Supplier to if
			
			mainMenu();
		}
		return newProduct;
	
	}
	
//Exit method
	public static void exit() {
		System.out.println("\n--------------------");
		System.out.println("See you soon! o/");
		System.out.println("--------------------");
		System.exit(0);
	}

}
