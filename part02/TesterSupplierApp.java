package part02;

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
		System.out.println("D. Search for Supplier");
		System.out.println("E. Modify Address");
		System.out.println("F. Delete an existing Product");
		System.out.println("G. Search for products within Price Range");
		System.out.println("H. Order Stock for suppliers");
		System.out.println("I. Exit Application");
		System.out.print("Choose Option: ");
		userInput();
		
	}
	
	
//UserInput	
	public static void userInput() {
		String userInput = mySc.nextLine().toUpperCase();
		userOption(userInput);
	}

	
//User Option, checks what user inputs, checks whether input is valid
	public static void userOption(String userInput) {
		if(userInput.equals("A")) {
			printAllProducts();
		} else if (userInput.equals("B")) {
			addNewSupplier();
		} else if (userInput.equals("C")) {
			addNewProduct(true);
		} else if (userInput.equals("D")) {
			searchForSup();
		}  else if (userInput.equals("E")) {
			modAddress();
		} else if (userInput.equals("F")) {
			deletePro();
		} else if (userInput.equals("G")) {
			searchForPrice();
		} else if (userInput.equals("H")) {
			orderStock();
		} else if (userInput.equals("I")) {
			exit();
		} else {
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
		
		//Checks which option the user chooses, menu or exit
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
		boolean isCode = false;
		
		
		System.out.println("\n----Add a New Supplier----\n");
		
		System.out.println("Please Enter Supplier Code ");
		int supCode = 0;
		
		if (numVal()) {
			supCode = mySc.nextInt();
			mySc.nextLine();
		} 
		
		
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
		
		int bldNum = 0;
		if (numVal()){
		bldNum = mySc.nextInt();
		mySc.nextLine();
		}
		
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
		
		int proCode = 0;
		if (numVal()) {
		proCode = mySc.nextInt();
		mySc.nextLine();
		}
		
		System.out.print("Product Make: ");
		String proMake = mySc.nextLine();
		
		System.out.print("Product Model: ");
		String proModel = mySc.nextLine();
		
		System.out.print("Product Price: ");
		
		double proPrice = 0.0;
		if (doubleVal()) {
		proPrice = mySc.nextDouble();
		mySc.nextLine();
		}
		
		System.out.print("Product Stock: ");
		
		int proStock = 0;
		if(numVal()) {
		proStock = mySc.nextInt();
		mySc.nextLine();
		}
			
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
						}//if statement
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
	
	//Searches the Data for a particular supplier and displays there products only
	public static void searchForSup() {
		
		//Variables
		boolean isSupValid = false;
		boolean isMenu = false;
		
		listOfSups();
		viewProducts(false);
		
		
		System.out.println("--------------------");
		System.out.println("Type menu to take you to the Menu, or Exit to exit the application.");
		System.out.print("Option here: ");
		
		while(isMenu == false) {
		
			
			
				String userOption = mySc.nextLine().toUpperCase();
				if (userOption.equals("MENU")) {
					isMenu = true;
					mainMenu();
				} else if (userOption.equals("EXIT")) {
					exit();
				} else {
					System.out.println("Invalid Option, try again.");
					System.out.print("Option here: ");	
				}
			
		}
			System.out.println("\n--------------------");
	}
	
	public static void searchForPrice() {
		
		double minPrice = 0.0;
		double maxPrice = 0.0;
		boolean noProducts = true;
		
		listOfSups();
		
		System.out.println("--------------------");
		System.out.print("Type the minimum price you want to search for.\n");
		if (doubleVal()) {
			minPrice = mySc.nextDouble();
			mySc.nextLine();
		}
		
		System.out.print("Type the maximum price you would like to search for.\n");
		if (doubleVal()) {
			maxPrice = mySc.nextDouble();
			mySc.nextLine();
		}
		
		for (int i = 0; i < supplierAl.size(); i++) {
			for (int y = 0; y < supplierAl.get(i).getSupProducts().size(); y++) {
				if (minPrice <= supplierAl.get(i).getSupProducts().get(y).getProPrice() 
						&& maxPrice >= supplierAl.get(i).getSupProducts().get(y).getProPrice()) {
					System.out.println(supplierAl.get(i).getSupProducts().get(y).getProductDetails());
					System.out.println("--------------------");
					
				} else if (minPrice >= supplierAl.get(i).getSupProducts().get(y).getProPrice() 
						|| maxPrice <= supplierAl.get(i).getSupProducts().get(y).getProPrice()) {
					noProducts = false;
				}
			}
		}
		
		if (noProducts == false) {
			System.out.println("--------------------");
			System.out.println("There are no products in this price range");
			System.out.println("--------------------");
		}
		
		mainMenu();
	}
	
	public static void modAddress() {
		
		boolean isSupValid = false;
		boolean isPartValid = false;
		
		listOfSups();
		
		System.out.println("--------------------");
		System.out.print("Type name of supplier you wish to change the address of here: ");
		
		while (isSupValid == false) {
			
			String userInput = mySc.nextLine().toUpperCase();
			
			for (int y = 0; y < supplierAl.size(); y++) {
				if (userInput.equals(supplierAl.get(y).getSupName().toUpperCase())){
					System.out.print("\n---" + supplierAl.get(y).getSupName().toUpperCase() + "---");
					isSupValid = true;
					System.out.print("\nWould you like to change the full address or part of it (type full or part): ");
					
					while (isPartValid == false) {
						
						String userInput01 = mySc.nextLine().toUpperCase();	
						
						if (userInput01.equals("FULL")) {
							
							supplierAl.get(y).setSupAddress(addNewAddress());
							
						} else if (userInput01.equals("PART")) {
							
							System.out.println("\n---Change part of the Address---");
							printAddress(y);
							
							System.out.print("Which part would you like to change, ");
							
							int userInput02 = 0;
							if (numVal()) {
								userInput02 = mySc.nextInt();
								mySc.nextLine();
							}
							
							switchAddress(userInput02, supplierAl.get(y).getSupAddress());
							mainMenu();
							
						} else {
							System.out.print("Invalid option please try again: ");
						}
						
					}
					
				}
				
			}
			if (isSupValid == true) {
				
			} else if (isSupValid == false) {
				System.out.print("Invalid option please try again: ");
			}
		}
	} 
	
	public static void printAddress(int index) {
		
		System.out.println("--------------------");
		System.out.print(supplierAl.get(index).getSupAddress().getFullAddress());
		System.out.println("\n--------------------");
		System.out.print("1. Building Number: ");
		System.out.println(supplierAl.get(index).getSupAddress().getBldNum());
		System.out.print("2. Street:          ");
		System.out.println(supplierAl.get(index).getSupAddress().getBldStreet());
		System.out.print("3. Town:            ");
		System.out.println(supplierAl.get(index).getSupAddress().getBldTown());
		System.out.print("4. Post Code:       ");
		System.out.println(supplierAl.get(index).getSupAddress().getBldPcode());
		System.out.print("5. Country:         ");
		System.out.println(supplierAl.get(index).getSupAddress().getBldCountry());
		
	}
	
	//method for checking whether number has been inputed.
	public static boolean numVal() {
		
		boolean isData = true;
		
		while(isData) {
			System.out.print("Enter number: ");
			if (mySc.hasNextInt()) {
				return true;
			}
			System.out.println("Invalid option");
			mySc.next();
		} return false;
	}
	
	public static boolean doubleVal() {
		
		boolean isData = true;
		
		while(isData) {
			System.out.print("Enter number: ");
			if (mySc.hasNextDouble()) {
				return true;
			}
			System.out.println("Invalid option");
			mySc.next();
		} return false;
		
	}
	
	
	//method for getting supplier names
	public static void getSupNames() {
		
		for (int i = 0; i < supplierAl.size(); i++) {
			System.out.println(supplierAl.get(i).getSupName());
		}
		
	}
	
	public static Address switchAddress(int index, Address supDetails) {
		
		int newBldNum = supDetails.getBldNum();
		String newBldStreet = supDetails.getBldStreet();
		String newBldTown = supDetails.getBldTown();
		String newBldPCode = supDetails.getBldPcode();
		String newBldCountry = supDetails.getBldCountry();
		
		switch (index) {
		
		case 1: System.out.print("- Building Number, ");
			if(numVal()) {newBldNum = mySc.nextInt(); mySc.nextLine(); } break;
		case 2: System.out.print("- Street: ");	newBldStreet = mySc.nextLine(); break;
		case 3: System.out.print("- Town: "); newBldTown = mySc.nextLine(); break;
		case 4: System.out.print("- Post Code: "); newBldPCode = mySc.nextLine(); break;
		case 5: System.out.print("- Country: "); newBldCountry = mySc.nextLine(); break;
		default: System.out.println("Invalid option, please try again.");
		
		}
		
		Address newAddress = new Address(newBldNum, newBldStreet, newBldTown, newBldPCode, newBldCountry);
		return newAddress;
		
	}
	
	public static void deletePro() {
		
		boolean isSupValid = false;
		
		System.out.println("\n---Delete Product---");
		listOfSups();
		viewProducts(true);
		mainMenu();
		
		
		
	}
	
	public static void listOfSups() {
		
		System.out.println("\n---List of Suppliers---");
		for (int i = 0; i < supplierAl.size(); i++) {	
			System.out.println("- " + supplierAl.get(i).getSupName());
		}	//for loop checking for suppliers in the Array list and printing it to screen
		
	}
	
	public static void viewProducts(boolean delete) {
		
	boolean isSupValid = false;
	boolean isPrintPro = false;
	boolean isValid = false;
	boolean isYesNo = false;
	boolean isDelete = false;
	boolean isAnother = false;
	boolean isYesNo01 = false;
	String yesNo = "";
	String yesNoDelete = "";
		
	System.out.println("--------------------");
	System.out.print("Type name of Supplier here: ");
		
	while (isSupValid == false) {
			
		String userInput = mySc.nextLine().toUpperCase();
				
			for (int y = 0; y < supplierAl.size(); y++) {
					
			//if statement checking user input and whether name matches name from list//if statement checking supplier list and how many products the supplier has					
			if (userInput.equals(supplierAl.get(y).getSupName().toUpperCase())) {
						
			//checks whether supplier has products if not displays error and takes user to main menu
				if (supplierAl.get(y).getSupProducts().size() <= 0) {
					System.out.println("There are no products available for this supplier");
					System.out.println("--------------------");
					mainMenu();
				}
					System.out.println("--------------------\nSupplier " + supplierAl.get(y).getSupName() + " has " + supplierAl.get(y).getSupProducts().size()
						+ " products.");	//checks how many products a supplier has
						
				while (isYesNo == false) {
					System.out.print("Would you like to print their product, yes or no: ");
					yesNo = mySc.nextLine().toUpperCase();
							
					if (yesNo.equals("YES")) {
					
						supplierAl.get(y).printProductList();
						isPrintPro = true;
						isYesNo = true; isSupValid = true;
								
				
								
				//checks if delete is true within the method if so then executes the delete product function
				if (delete) {			
					while(isDelete == false) {
						System.out.println("--------------------");
						System.out.print("Which product would you like to delete\n");
						int userSelection = 0;
						if(numVal()) {
							userSelection = mySc.nextInt();
							mySc.nextLine();
						}
						
						//where deleting product takes place, checks the user input and deletes the array index according to it
						if (userSelection <= (supplierAl.get(y).getSupProducts().size())) {
						supplierAl.get(y).getSupProducts().remove(userSelection-1);
						System.out.println("--------------------");
						System.out.println("Product has been deleted");
						System.out.println("--------------------");
				
				while (isYesNo01 == false) {
				
				System.out.print("Would you like to delete another product, yes or no: ");	
					
				yesNoDelete = mySc.nextLine().toUpperCase();
				if (yesNoDelete.equals("YES") && supplierAl.get(y).getSupProducts().size() > 0) {
					isDelete = false;												
					for (int x = 0; x < supplierAl.get(x).getSupProducts().size(); x++) {					
						System.out.println((x+1) + ". " + supplierAl.get(y).getSupProducts().get(x).getProductDetails());
						isYesNo01 = true;	
						}
					
				} else if (yesNoDelete.equals("NO")) {
					mainMenu();
				} else if (yesNoDelete.equals("YES") && supplierAl.get(y).getSupProducts().size() <= 0) {
					System.out.println("There are no more products left for this supplier.");
					System.out.println("--------------------");
					mainMenu();
				} else {
					System.out.println("Invalid option, please try again.");
					}
				}
						} else { 		//this else is for the above if where it prints product deleted
							System.out.print("ERROR: There is no product for the number you have selected\n");
						}
			}
		}
	}//nested if statement that checks whether user types in yes or no and prints the result
					
		else if (yesNo.equals("NO")) {
			isYesNo = true;
			mainMenu();
		} else { isYesNo = false; }
			}
		} else {
			isValid = true;
		}
					
	}//for loop for getting the index of supplier
				
			if (isPrintPro == true) {
					
			} else if (isValid == true) {
				System.out.print("Invalid option, please try again: ");
			}
				
		}//while loop
		
	}
	
	public static void orderStock() {
		
		boolean isSupValid = false;
		boolean isNotValid = false;
		boolean isValid = false;
		boolean isOrder = false;
		int productNum = 0;
		int numOfProducts = 0;
		int supIndex = 0;
		String userInput = "";
		
		System.out.println("\n---Order Stock---");
		listOfSups();
		System.out.println("--------------------");
		
		while (isNotValid == false) {
			
			System.out.print("Type the name of supplier you would like to view products for: ");
			userInput = mySc.nextLine().toUpperCase();
			for (int x = 0; x < supplierAl.size(); x++) {
				if (userInput.equals(supplierAl.get(x).getSupName().toUpperCase())) {
					isValid = true;
					isNotValid = true;
				}
			} if (isValid) {
				
			} else if (isValid == false) {
				System.out.println("Invalid Supplier, please try again.");
				isValid = false;
			}
		}
		
		while (isSupValid == false) {
			
			
				for (int y = 0; y < supplierAl.size(); y++) {	
					
				//if statement checking user input and whether name matches name from list				
				if (userInput.equals(supplierAl.get(y).getSupName().toUpperCase())) {
					isSupValid = true;
					
					//checks whether supplier has products if not displays error and takes user to main menu
					if (supplierAl.get(y).getSupProducts().size() <= 0) {
						System.out.println("There are no products available for this supplier");
						System.out.println("--------------------");
						mainMenu();
					}
					
					System.out.println("--------------------\nSupplier " + supplierAl.get(y).getSupName() + " Products: "); 
					supIndex = y;
					for (int i = 0; i < supplierAl.get(y).getSupProducts().size(); i++) {
					System.out.println((i+1) + ". " + supplierAl.get(y).getSupProducts().get(i).getProModel());
						
				}
					
					
				while (isOrder == false) {
					
					System.out.println("--------------------");
					System.out.print("Which product would you like to order.\n");
					if (numVal()) {
						productNum = mySc.nextInt();
						mySc.nextLine();
					}
					
					if (productNum <= supplierAl.get(y).getSupProducts().size()) {
						isOrder = true;
					} else if (productNum > supplierAl.get(y).getSupProducts().size()) {
						System.out.println("There is no such product, please try again.");
					}
				}
					
					System.out.println("--------------------");
					System.out.print("How many would you like to order\n");
					if (numVal()) {
						numOfProducts = mySc.nextInt();
						mySc.nextLine();
					}
					
					double total = numOfProducts * supplierAl.get(y).getSupProducts().get(productNum-1).getProPrice();
					System.out.printf("The total cost of the order is: £%.2f", total);
					int newStock = numOfProducts + supplierAl.get(y).getSupProducts().get(productNum-1).getProQtyAvailable();
					supplierAl.get(y).getSupProducts().get(productNum-1).setProQtyAvailable(newStock);
					System.out.println("\nThere will now be " + newStock + " products in stock.");
				} 
			}
			
			mainMenu();	
		}
	}
	
	public static boolean validateStrings(int stringLength, boolean numbers, String userInput) {

        boolean badName = true;

            for (int i = 0; i < userInput.length(); i++) {
                if(numbers == false) {
                    if((userInput.length() <= stringLength && Character.isLetter(userInput.charAt(i)) && userInput.length() >= 1)) {
                        badName = false;
                    } else { badName = true; }
                } else if (numbers) {
                    if(userInput.length() <= stringLength && userInput.length() >= 1) {
                        badName = false;
                    } else { badName = true; }
                    badName = false;
                } else { badName = true; } 
            }
            if (badName == true) {
            System.out.println("Invalid format, must only contain Letters and must be between 1 and " + stringLength
                    + " characters long.");
            }

        if(badName == false) {
            return true;
        } else { return false;}

    } //string validation method but did not get time to implement
	
//Exit method
	public static void exit() {
		System.out.println("\n--------------------");
		System.out.println("See you soon! o/");
		System.out.println("--------------------");
		System.exit(0);
	}

}
