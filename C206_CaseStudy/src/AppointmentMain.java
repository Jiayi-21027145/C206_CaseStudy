import java.util.ArrayList;

public class AppointmentMain {
	public static void main(String[] args) {

		// Create an arraylist
		ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
		appointmentList.add(new Appointment("J0001", "James", 12345678, "1 June 2020", "12.00pm"));
		appointmentList.add(new Appointment("J0002", "Mary", 97756342, "28 May 2021", "2.00pm"));
		appointmentList.add(new Appointment("J0003", "Andy", 87654321, "23 February 2022", "3.00pm"));

		// start the program
		int option = 0;
		while (option != 4) {

			AppointmentMain.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// view appointment
				AppointmentMain.viewAllAppointment(appointmentList);

			} else if (option == 2) {
				AppointmentMain.setHeader("ADD APPOINTMENTS");

				// Add appointment
				Appointment ap = inputAppointment();
				AppointmentMain.addAppointment(appointmentList, ap);
				System.out.println("Appointment added");

			} else if (option == 3) {
				AppointmentMain.setHeader("DELETE APPOINTMENT");

				// delete Appointment
				AppointmentMain.deleteAppointment(appointmentList);

			} else if (option == 4) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}
		}
	}

	public static void menu() {
		AppointmentMain.setHeader("Bike Lover Community");
		System.out.println("1. View Appointment");
		System.out.println("2. Add Appointment");
		System.out.println("3. Delete Appointment");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}

	private static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	// =================Option 1 View Feedbacks (CRUD - Read)
	// =======================
	public static String retrieveAllappointment(ArrayList<Appointment> appointmentList) {
		String output = "";

		for (int i = 0; i < appointmentList.size(); i++) {
			output += String.format("%-20s %-10s %-10d %-50s %-10s\n", appointmentList.get(i).getId(),
					appointmentList.get(i).getName(), appointmentList.get(i).getContact_details(),
					appointmentList.get(i).getDate(), appointmentList.get(i).getTime());
		}
		return output;
	}

	public static void viewAllAppointment(ArrayList<Appointment> appointmentList) {
		AppointmentMain.setHeader("Appointment List");
		String output = String.format("%-20s %-10s %-15s %-10s %-50s\n", "ID", "NAME", "CONTACT DETAILS", "DATE",
				"TIME");

		output += retrieveAllappointment(appointmentList);
		System.out.println(output);
	}

	// =================Option 2 Add Feedbacks (CRUD - create)
	// =======================
	public static Appointment inputAppointment() {
		String id = Helper.readString("Enter id > ");
		String name = Helper.readString("Enter name > ");
		int contact = Helper.readInt("Enter contact > ");
		String date = Helper.readString("Enter date > ");
		String time = Helper.readString("Enter time > ");

		Appointment ap = new Appointment(id, name, contact, date, time);
		return ap;
	}

	public static void addAppointment(ArrayList<Appointment> appointmentList, Appointment ap) {
		appointmentList.add(ap);
	}

	// =================Option 3 Delete Feedbacks (CRUD - delete)
	// =======================

	public static boolean doDeleteAppointment(ArrayList<Appointment> appointmentList, String id) {

		boolean isDeleted = false;

		for (int i = 0; i < appointmentList.size(); i++) {
			if (appointmentList.get(i).getId().equals(id)) {
				appointmentList.remove(i);
				isDeleted = true;
			}
		}
		return isDeleted;
	}

	public static void deleteAppointment(ArrayList<Appointment> appointmentList) {
		AppointmentMain.viewAllAppointment(appointmentList);

		String id = Helper.readString("Enter id > ");
		Boolean isDeleted = doDeleteAppointment(appointmentList, id);
		if (isDeleted == false) {
			System.out.println("Invalid ID entered");
		} else {
			System.out.println("ID" + id + "deleted");

		}
	}

}