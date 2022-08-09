import java.util.ArrayList;

public class RegistrationMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<UserAccount> userList = new ArrayList<UserAccount>();
		userList.add(new UserAccount("J0001","James", 12345678,"53 Tampines Cresent"));
		userList.add(new UserAccount("J0002","Mary", 97756342,"876 BoonLay  ave 3"));
		userList.add(new UserAccount("J0003","Andy", 87654321,"530 simei lane"));
		
		int option = 0;
		while(option != 4) {
			RegistrationMain.menu();
			option = Helper.readInt("Enter an option > ");
			
			if(option == 1) {
				//view comments
				RegistrationMain.viewAllUser(userList);
				
			}else if(option ==2 ) {
				RegistrationMain.setHeader("ADD USER");
				
				//Add User
				UserAccount ua = inputUser();
				RegistrationMain.addUser(userList, ua);
				System.out.println("User added");
				
			}else if (option == 3) {
				RegistrationMain.setHeader("DELETE USER");
				
				//delete User
				RegistrationMain.deleteUser(userList);
				
			}else if (option == 4){
				System.out.println("Bye!");
			}else {
					System.out.println("Invalid option");
			}
		}
	}	
	private static void menu() {
		// TODO Auto-generated method stub
		System.out.println("Bike Lover Community");
		Helper.line(30, "-");
		System.out.println("1. View User");
		System.out.println("2. Add User");
		System.out.println("3. Delete User");
		System.out.println("4. Quit");
	}
	private static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");	
	}
	
//================================Option 1 View Users (CRUD - Read) =================================================
	public static String retrieveAllUser(ArrayList<UserAccount> userList) {
		String output = "";
		
		for (int i = 0; i < userList.size(); i++) {
			output += String.format("%-10s %-10s %-20d %-30s\n",  userList.get(i).getId(), userList.get(i).getName(), 
					userList.get(i).getContact_details(), userList.get(i).getAddress());
		}
		return output;
	}
	public static void viewAllUser(ArrayList<UserAccount> userList) {
		RegistrationMain.setHeader("User List");
		String output = String.format("%-10s %-10s %-20s %-30s\n", "User ID", "NAME", "CONTACT DETAILS", "ADDRESS");
		
		output += retrieveAllUser(userList) ;
		System.out.println(output);
	}
//================================Option 2 Add Users (CRUD - Read) =================================================
	public static UserAccount inputUser() {
		String id = Helper.readString("Enter ID > ");
		String name = Helper.readString("Enter name > ");
		int contact = Helper.readInt("Enter contact > ");
		String address = Helper.readString("Enter address > ");
		
		UserAccount ua = new UserAccount(id, name, contact, address);
		return ua;
	}
	public static void addUser(ArrayList<UserAccount> userList, UserAccount ua) {
		userList.add(ua);
	}
//================================Option 3 Remove Users (CRUD - Read) =================================================
	public static boolean dodeleteUser(ArrayList<UserAccount> userList, String id) {
		boolean isDeleted = false;
		
		for (int i = 0; i < userList.size(); i++) {
			if(id.equalsIgnoreCase(userList.get(i).getId())) {
				
				userList.remove(i);
				isDeleted = true;
			}
		}
		return isDeleted;
}	
	public static void deleteUser (ArrayList<UserAccount> userList) {
		retrieveAllUser(userList);
		String id = Helper.readString("Enter id > ");
		Boolean isDeleted = dodeleteUser (userList,id);
		
		if (isDeleted == true) {
			System.out.println("User Deleted!");
			
		}else {
			System.out.println("Delete Unsuccessful!");
		}
	}
}	