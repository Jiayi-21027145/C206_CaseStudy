import java.util.ArrayList;

public class BikePartMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<BikePart> bikepartList = new ArrayList<BikePart>();
		bikepartList.add(new BikePart(2, "Help the object move", 9.20, "Wheel Tube"));
		bikepartList.add(new BikePart(1, "To have a place to sit down", 10.90, "Seat"));
		bikepartList.add(new BikePart(1, "Connects the wheel and the pedal", 9.90, "Chain"));

		int option = 0;
		while (option != 4) {

			BikePartMain.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				BikePartMain.viewAllBikePart(bikepartList);

			} else if (option == 2) {
				BikePartMain.setHeader("ADD FEEDBACKS");

				BikePart bp = inputBikePart();
				BikePartMain.addBikePart(bikepartList, bp);
				System.out.println("BikePart added");

			} else if (option == 3) {
				BikePartMain.setHeader("DELETE FEEDBACKS");

				BikePartMain.deleteBikePart(bikepartList);

			} else if (option == 4) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}
		}
	}

	private static void menu() {
		// TODO Auto-generated method stub
		BikePartMain.setHeader("Bike Lover Community");
		System.out.println("1. View BikePart");
		System.out.println("2. Add BikePart");
		System.out.println("3. Delete BikePart");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}

	public static BikePart inputBikePart() {
		int quantity = Helper.readInt("Enter quantity > ");
		String features = Helper.readString("Enter description > ");
		double price = Helper.readDouble("Enter description > ");
		String name = Helper.readString("Enter name > ");

		BikePart bp = new BikePart(quantity, features, price, name);
		return bp;
	}

	public static void addBikePart(ArrayList<BikePart> bikepartList, BikePart bp) {
		bikepartList.add(bp);
	}

	public static String retrieveAllBikePart(ArrayList<BikePart> bikepartList) {
		String output = "";

		for (int i = 0; i < bikepartList.size(); i++) {
			output += String.format("%-20d %-10s %-20.2f %-10s\n", bikepartList.get(i).getQuantity(),
					bikepartList.get(i).getFeatures(), bikepartList.get(i).getPrice(),
					bikepartList.get(i).getPartname());
		}
		return output;
	}

	private static void viewAllBikePart(ArrayList<BikePart> bikepartList) {
		BikePartMain.setHeader("BikePart List");
		String output = String.format("%-20s %-10s %-20s %-10s\n", "QUANTITY", "FEATURE", "PRICE", "NAME");

		output = retrieveAllBikePart(bikepartList);
		System.out.println(output);
	}

	private static void setHeader(String string) {
		// TODO Auto-generated method stub

	}
	public static boolean doDeleteBikePart(ArrayList<BikePart> bikepartList, String name) {

		  boolean isDeleted = false;

		  for (int i = 0; i < bikepartList.size(); i++) {
		   if (bikepartList.get(i).getPartname() == name) {
		    bikepartList.remove(i);
		    isDeleted = true;
		   }
		  }
		  return isDeleted;
		 }

		 public static void deleteBikePart(ArrayList<BikePart> BikesList) {
		  BikePartMain.viewAllBikePart(BikesList);

		  String bikeName = Helper.readString("Enter bike position to delete(eg:1,2,3) > ");
		  Boolean isDeleted = doDeleteBikePart(BikesList, bikeName);
		  if (isDeleted == false) {
		   System.out.println("Invalid bike name entered!");
		  } else {
		   System.out.println("Bike" + bikeName+ "deleted");

		  }
		 }

		}