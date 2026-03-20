package inventory_system;
import java.util.Scanner;
public class LootInventory {
	public static void main (String []args) {
		Scanner scan = new Scanner (System.in); 

		// Arrays to store product data
		String [] products = new String [10];
		int [] quantity = new int [10];
		double [] itemPrice = new double[10];
		
						
		int count = 0; // Tracks number of items stored
		int choice = 7;  // User menu choice

		do {
			// Display menu
			System.out.println("1. Add Item");
			System.out.println("2. View Items");
			System.out.println("3. Search Item");
			System.out.println("4. Update Item");
			System.out.println("5. Delete Item");
			System.out.println("6. Total Inventory Value");
			System.out.println("7. Exit");
			choice = scan.nextInt();

			switch (choice) {
			case 1:
				// Add new item
				if(count<products.length) {
					System.out.println("Enter your new product");
					scan.nextLine();
					products[count] = scan.nextLine();

					;					
					System.out.println("How many Quantity");
					quantity[count] = scan.nextInt();

					System.out.println("Value of Each item");
					itemPrice[count] = scan.nextDouble();

					count++;
				}else {
					System.out.println("Maximum slot!!");
				}
				break;
			case 2:
				// View all items
				System.out.println("Viewing Item\n");
				for(int i = 0; i<count; i++){
					System.out.println("Item " + (i + 1) + ": "
							+ products[i] + " | Qty: " +
							quantity[i] + "| Price:" + itemPrice[i]);
				}
				break;
			case 3: 
				// Search for an item by name
				scan.nextLine();
				System.out.println("Enter the product name:");
				String search =scan.nextLine();

				boolean found = false;

				for (int i = 0; i<count; i++) { 
					if(products[i].equalsIgnoreCase(search)) {
						System.out.println("Found" + products[i] + " | Qty: " + quantity[i] + "| Price: "+ itemPrice[i]);

						found = true;
						break;
					}
				}
				// If not found
				if(!found) {
					System.out.println("Item not found");
				}
				break;
			case 4:
				// Update an existing item
				scan.nextLine();
				System.out.println("Enter product name to Update");
				String updateName = scan.nextLine();

				boolean updated = false; 
				for (int i = 0; i<count; i++) {
					if(products[i].equalsIgnoreCase(updateName)) {
						
						// Replace item details
						System.out.println("Enter your new product");
						products[i] = scan.nextLine();

						System.out.println("How many Quantity");
						quantity[i] = scan.nextInt();

						System.out.println("Value of Each item");
						itemPrice[i] = scan.nextDouble();



						updated= true;
						break;
					}
				}
				if (!updated) {
					System.out.println("Item not found.");
				}
				break;
			case 5:
				
				// Delete an item
				scan.nextLine();
				System.out.println("Enter the name you want delete");
				String deleteItem = scan.nextLine();
				
				boolean delete = false;
				
				for(int i = 0; i<count; i++){
					if(products[i].equalsIgnoreCase(deleteItem)) {
						for (int j = i; j<count -1; j++) {
							products[j] = products[j + 1];
							quantity[j] = quantity[j + 1];
							itemPrice[j] = itemPrice[j + 1];
							
						}
						count--; // reduce item count
						delete = true;
						break;
					}
				}
				if(!delete) {
					System.out.println("Item not found");
				}else {
					System.out.println("Item deleted Succesfully");
				}
				break;
			
			case 6:
				
				// Calculate total inventory value
				double total = 0;
				
				for(int i = 0; i<count; i++){
				double itemTotal = quantity[i] * itemPrice[i];
				
				total += itemTotal;
				}
				System.out.println("Total Inventory Value: " + total);

			    break;
			   
			case 7: 
				// Invalid input
				System.out.println("Exit");
			
				default :
					System.out.println("Input Number only");
				
			}


		}while(choice!=7); // repeat until user exits
		
		scan.close();
	}
}
