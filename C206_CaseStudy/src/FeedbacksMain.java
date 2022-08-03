import java.time.LocalDate;
import java.util.ArrayList;

public class FeedbacksMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Create an arraylist
		ArrayList<Feedbacks> feedbacksList = new ArrayList<Feedbacks>();
		
		//start the program
		int option = 0;
		
		while(option != 4) {
			
			FeedbacksMain.menu();
			option = Helper.readInt("Enter an option > ");
			
			if(option == 1) {
				//view comments
				FeedbacksMain.viewAllFeedback(feedbacksList);
				
			}else if(option ==2 ) {
				FeedbacksMain.setHeader("ADD FEEDBACKS");
				
				//Add feedbacks
				Feedbacks fb = inputFeedbacks();
				FeedbacksMain.addFeedback(feedbacksList, fb);
				System.out.println("Feedback added");
				
			}else if (option == 3) {
				FeedbacksMain.setHeader("DELETE FEEDBACKS");
				
				//delete feedback
				FeedbacksMain.deleteFeedbacks(feedbacksList);
				
			}else if (option == 4){
				System.out.println("Bye!");
			}else {
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
	
	//=================Option 1 View Feedbacks (CRUD - Read) =======================
	public static String retrieveAllFeedback(ArrayList<Feedbacks> feedbacksList) {
		String output = "";
		
		for (int i = 0; i < feedbacksList.size(); i++) {
			output += String.format("%-20s %-10d %-50s\n",   feedbacksList.get(i).getName(), feedbacksList.get(i).getContact_details(), feedbacksList.get(i).getComments());
		}
		return output;
	}
	public static void viewAllFeedback(ArrayList<Feedbacks> feedbacksList) {
		FeedbacksMain.setHeader("Feedback List");
		String output = String.format("%-20s %-10s %-50s\n", "NAME", "CONTACT DETAILS", "COMMENTS");
		
		output += retrieveAllFeedback(feedbacksList) ;
		System.out.println(output);
	}
		
	//=================Option 2 Add Feedbacks (CRUD - create) =======================
	public static Feedbacks inputFeedbacks() {
		String name = Helper.readString("Enter name > ");
		int contact = Helper.readInt("Enter contact > ");
		String comment = Helper.readString("Enter comment > ");
		String date = Helper.readString("Enter date > ");
		
		Feedbacks fb = new Feedbacks(name, contact, comment, date);
		return fb;
	}
	public static void addFeedback(ArrayList<Feedbacks> feedbacksList, Feedbacks fb) {
		feedbacksList.add(fb);
	}
	
	//=================Option 3 Delete Feedbacks (CRUD - delete) =======================
	public static boolean doDeleteFeedbacks (ArrayList<Feedbacks> feedbacksList, String date) {
		boolean isDeleted = false;
		
		for (int i = 0; i < feedbacksList.size(); i++) {
			if(feedbacksList.get(i).getDate() == true) {
				
				

				
		
		
			}
		}

		


		
	}

}
