import java.time.LocalDate;
import java.util.ArrayList;

public class FeedbacksMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create an arraylist
		ArrayList<Feedbacks> feedbacksList = new ArrayList<Feedbacks>();
		feedbacksList.add(new Feedbacks("J0001", "James", 99999999, "The service provided was good", "1 June 2020"));
		feedbacksList.add(new Feedbacks("J0002", "Mary", 97756342, "The staff is able to answer my queries", "28 May 2021"));
		feedbacksList.add(new Feedbacks("J0003", "Andy", 87654321, "The app provide the things that I need", "23 February 2022"));

		// start the program
		int option = 0;
		while (option != 4) {

			FeedbacksMain.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// view comments
				FeedbacksMain.viewAllFeedback(feedbacksList);

			} else if (option == 2) {
				FeedbacksMain.setHeader("ADD FEEDBACKS");

				// Add feedbacks
				Feedbacks fb = inputFeedbacks();
				FeedbacksMain.addFeedback(feedbacksList, fb);
				System.out.println("Feedback added");

			} else if (option == 3) {
				FeedbacksMain.setHeader("DELETE FEEDBACKS");

				// delete feedback
				FeedbacksMain.deleteFeedbacks(feedbacksList);

			} else if (option == 4) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}
		}
	}

	public static void menu() {
		FeedbacksMain.setHeader("Bike Lover Community");
		System.out.println("1. View Feedbacks");
		System.out.println("2. Add Feedbacks");
		System.out.println("3. Delete Feedbacks");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}

	private static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	// =================Option 1 View Feedbacks (CRUD - Read)===========================================
	public static String retrieveAllFeedback(ArrayList<Feedbacks> feedbacksList) {
		String output = "";

		for (int i = 0; i < feedbacksList.size(); i++) {
			output += String.format("%-10s %-20s %-10d %-50s %-10s\n", feedbacksList.get(i).getId(), feedbacksList.get(i).getName(),
					feedbacksList.get(i).getContact_details(), feedbacksList.get(i).getComments(), feedbacksList.get(i).getDate());
		}
		return output;
	}

	public static void viewAllFeedback(ArrayList<Feedbacks> feedbacksList) {
		FeedbacksMain.setHeader("Feedback List");
		String output = String.format("%-10s %-20s %-10s %-50s %-10s\n", "ID", "NAME", "CONTACT DETAILS", "COMMENTS", "DATE");

		output = retrieveAllFeedback(feedbacksList);
		System.out.println(output);
	}

	// =================Option 2 Add Feedbacks (CRUD - create)===========================================

	public static Feedbacks inputFeedbacks() {
		String id = Helper.readString("Enter id > ");
		String name = Helper.readString("Enter name > ");
		int contact = Helper.readInt("Enter contact > ");
		String comment = Helper.readString("Enter comment > ");
		String date = Helper.readString("Enter date > ");

		Feedbacks fb = new Feedbacks(id, name, contact, comment, date);
		return fb;
	}

	public static void addFeedback(ArrayList<Feedbacks> feedbacksList, Feedbacks fb) {
		feedbacksList.add(fb);
	}

	// =================Option 3 Delete Feedbacks (CRUD - delete)

	public static boolean doDeletingFeedbacks(ArrayList<Feedbacks> feedbacksList, String id){

		
		boolean isDeleted = false;
		
		for(int i = 0; i < feedbacksList.size(); i++) {
			if(id.equalsIgnoreCase(feedbacksList.get(i).getId())) {
				
				feedbacksList.remove(i);
				isDeleted = true;
			}
		}return isDeleted;
				


	}
	

	public static boolean doDeleteFeedback(ArrayList<Feedbacks> feedbacksList, String id) {

		boolean isDeleted = false;

		for (int i = 0; i < feedbacksList.size(); i++) {
			if (feedbacksList.get(i).getId() == id) {
				feedbacksList.remove(i);
				isDeleted = true;
			}
		}
		return isDeleted;
	}

	public static void deleteFeedbacks(ArrayList<Feedbacks> feedbacksList) {
		FeedbacksMain.viewAllFeedback(feedbacksList);

		String id = Helper.readString("Enter id > ");
		Boolean isDeleted = doDeletingFeedbacks(feedbacksList, id);
		if (isDeleted == false) {
			System.out.println("Invalid ID entered");
		} else {
			System.out.println("ID" + id + "deleted");

		}
	}
		}



//	public static void deleteFeedbacks(ArrayList<Feedbacks> feedbacksList, feedbacks fb) {
//		retrieveAllFeedback(feedbacksList);
//		id = Helper.readString("Enter id > ");
//		isDeleted = doDeletingFeedbacks(feedbacksList, id);
//		
//		if(isDeleted == true) {
//			System.out.println("Feedback deleted!");
//		}else {
//			System.out.println("Delete Unsuccessful!");
//		}
	
//		String id = Helper.readString("Enter id > ");
//		for(int i = 0; i < feedbacksList.size(); i++) {
//			if(feedbacksList.get(i).getId().equalsIgnoreCase(id)){
//				feedbacksList.remove(fb);

//			}
//
//
//		}
//	}
//}
//	
