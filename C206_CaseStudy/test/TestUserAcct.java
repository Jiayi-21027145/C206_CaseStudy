import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestUserAcct {
	private UserAccount user1;
	private UserAccount user2;
	private UserAccount user3;
	
	private ArrayList<UserAccount> userList;

	
	public TestUserAcct() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		user1 = new UserAccount("J0001","James", 12345678,"53 Tampines Cresent");
		user2 =new UserAccount("J0002","Mary", 97756342,"876 BoonLay  ave 3");
		user3 = new UserAccount("J0003","Andy", 87654321,"530 simei lane");
		
		
		
		userList= new ArrayList<UserAccount>();
		
	}

	@Test
	public void testaddUser() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid User arraylist to add to", userList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		RegistrationMain.addUser(userList, user1);		
		assertEquals("Test if that user arraylist size is 1?", 1, userList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that user is added same as 1st user of the list?", user1, userList.get(0));
		
		//Add another item. test The size of the list is 2?
		RegistrationMain.addUser(userList, user2);
		RegistrationMain.addUser(userList, user3);
		assertEquals("Test that user arraylist size is 3?", 3, userList.size());
		assertSame("Test that user is added same as 3rd user of the list?", user3, userList.get(2));
	}
	
	@Test
	public void testViewAllUser() {
		// Test if user list is not null but empty, so that can new user can be added  
		assertNotNull("Test if there is valid user arraylist to add to", userList);
		
		//test if the list of user retrieved from the userList is empty
		String allUser= RegistrationMain.retrieveAllUser(userList);
		String testOutput = "";
		assertEquals("Check that ViewAllUserlist", testOutput, allUser);
				
		//Given an empty list, after adding 2 users, test if the size of the list is 2
		RegistrationMain.addUser(userList, user1);
		RegistrationMain.addUser(userList, user2);
		assertEquals("Test if that user arraylist size is 2?", 2, userList.size());
		
		//test if the expected output string same as the list of  retrieved from the user list
		allUser= RegistrationMain.retrieveAllUser(userList);

		testOutput = String.format("%-10s %-10s %-20d %-30s\n", "J0001","James", 12345678,"53 Tampines Cresent");
		testOutput += String.format("%-10s %-10s %-20d %-30s\n","J0002","Mary", 97756342,"876 BoonLay  ave 3");
	
		assertEquals("Check that ViewAllUserlist", testOutput, allUser);
	}
	
	@Test
	public void deleteUser() {
			//Given an empty list, after adding 2 users, test if the size of the list is 2
				RegistrationMain.addUser(userList, user1);
				RegistrationMain.addUser(userList, user2);
				assertEquals("Test if that user arraylist size is 1?", 2, userList.size());
			
				//The user  added is as same as the first item of the list
				assertSame("Test that user is added same as 1st user of the list?", user1, userList.get(0));
				
				// Test that user list is not null, so that the user can be deleted
				assertNotNull ("Test if there is valid user arraylist to delete user from",userList);
				
				//Deleting user.Test the size of the list is to 1
				RegistrationMain.dodeleteUser(userList, user1.getId());
				assertEquals("test that user arraylist size is 0?",1,userList.size());
				assertSame("Test that 2nd user is moved to the first item of the list?",user2,userList.get(0));
	}
	
	@After
	public void tearDown() throws Exception {
		user1 = null;
		user2 = null;
		user3 = null;
		userList = null;
	}
}