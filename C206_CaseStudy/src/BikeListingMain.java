
import java.time.LocalDate;
import java.util.ArrayList;

public class BikeListingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create an arraylist

		ArrayList<BikeListing> BikesList = new ArrayList<BikeListing>();
		BikesList.add(new BikeListing(45, "The bike performs best in the mountain terrain.", 140.20, "BMX"));
		BikesList.add(new BikeListing(34, "An all rounderbike performance", 89.90, "Hybird"));
		BikesList.add(new BikeListing(49, "Moves faster on the road!", 134.20,"Road Bike"));

		// start the program
		int option = 0;
		while (option != 4) {

			BikeListingMain.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// view bike lists
				BikeListingMain.viewAllBike(BikesList);

			} else if (option == 2) {
				BikeListingMain.setHeader("ADD BIKES");

				// Add Bikes
				BikeListing bikeadd = inputBikes();
				BikeListingMain.addBike(BikesList, bikeadd);
				System.out.println("Bike added");

			} else if (option == 3) {
				BikeListingMain.setHeader("DELETE BIKES");

				// delete Bike
				BikeListingMain.deleteBikes(BikesList);

			} else if (option == 4) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}
		}
	}

	// TODO Auto-generated method stub



	public static void menu() {
		BikeListingMain.setHeader("Bike Lover Community");
		System.out.println("1. View Bikes");
		System.out.println("2. Add Bikes");
		System.out.println("3. Delete Bikes");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}

	private static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	// =================Option 1 View Bikes (CRUD - Read) =======================
	public static String retrieveAllBike(ArrayList<BikeListing> BikesList) {
		String output = "";

		for (int i = 0; i < BikesList.size(); i++) {
			output += String.format("%-20d %-50s %-10.2f %-20s \n", BikesList.get(i).getQuantity(),
					BikesList.get(i).getFeatures(), BikesList.get(i).getPrice(), BikesList.get(i).getBikeName());
		}
		return output;

	}

	public static void viewAllBike(ArrayList<BikeListing> BikesList) {

		BikeListingMain.setHeader("Bike List");
		String output = String.format("%-20s %-50s %-10s %-20s \n", "QUANTITY", "FEATURES", "PRICE", "NAME");

		output = retrieveAllBike(BikesList);
		System.out.println(output);
	}

	// =================Option 2 Add Bikes (CRUD - create) =======================

	public static BikeListing inputBikes() {

		String name = Helper.readString("Enter name > ");
		int quantity = Helper.readInt("Enter quantity > ");
		double price = Helper.readDouble("Enter price of the bike > ");
		String features = Helper.readString("Enter Features of the bike > ");

		BikeListing bikeadd = new BikeListing(quantity, features, price, name);
		return bikeadd;
	}

	public static void addBike(ArrayList<BikeListing> BikesList, BikeListing Bikeadd) {
		BikesList.add(Bikeadd);
	}

	// =================Option 3 Delete Bikes (CRUD - delete)
	// =======================
	public static boolean doDeleteBike(ArrayList<BikeListing> BikesList, String bikeName) {

		boolean isDeleted = false;

		for (int i = 0; i < BikesList.size(); i++) {
			if (BikesList.get(i).getBikeName() == bikeName) {
				BikesList.remove(i);
				isDeleted = true;
			}
		}
		return isDeleted;
	}

	public static void deleteBikes(ArrayList<BikeListing> BikesList) {
		BikeListingMain.viewAllBike(BikesList);

		String bikeName = Helper.readString("Enter bike position to delete(eg:1,2,3) > ");
		Boolean isDeleted = doDeleteBike(BikesList, bikeName);
		if (isDeleted == false) {
			System.out.println("Invalid bike name entered!");
		} else {
			System.out.println("Bike" + bikeName+ "deleted");

		}
	}

}


