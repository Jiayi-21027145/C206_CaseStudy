import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class TestFeedbacks {
	
	//prepare test data
	private Feedbacks fb1;
	private Feedbacks fb2;
	private Feedbacks fb3;
	
	private ArrayList<Feedbacks> feedbacksList;
	
	public TestFeedbacks() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		//prepare test data
		
		fb1 = new Feedbacks("J0001", "James", 99999999, "The service provided was good", "1 June 2020");
		fb2 = new Feedbacks("J0002", "Mary", 97756342, "The staff is able to answer my queries", "28 May 2021");
		fb3 = new Feedbacks("J0003", "Andy", 87654321, "The app provide the things that I need", "23 February 2022");
		
		feedbacksList = new ArrayList<Feedbacks>();
	}
	
	@Test 
	public void testAddFeedbacks() {
		//List not null, can add new item 
		assertNotNull("Test if there is valid Feedback arraylist to add to", feedbacksList);
		
		//Given an empty list, after adding 1 feedback, the size of the list is 1
		FeedbacksMain.addFeedback(feedbacksList, fb1);
		assertEquals("Test if that feedbacks arraylist size is 1?", 1, feedbacksList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Feedback is added same as 1st feedbank of the list?", fb1, feedbacksList.get(0));
		
		//Add another item, test that size of the list is 2?
		FeedbacksMain.addFeedback(feedbacksList, fb2);
		FeedbacksMain.addFeedback(feedbacksList, fb3);
		assertEquals("Test that Feedback arraylist size id 3?", 3, feedbacksList.size());
		assertSame("Test that Feedback is added same as the 3rd item of the list?", fb3, feedbacksList.get(2));
		
	}
	
	@Test
	public void testRetrieveFeedbacks() {
		//Test if feedbacks list is not null but empty, so that can add new item
		assertNotNull("Test if there is valid Feedback arraylist to add to", feedbacksList);
		
		//test if the list of feedback retrieved from the feedbackMainis empty
		String allFeedbacks = FeedbacksMain.retrieveAllFeedback(feedbacksList);
		String testOutput = "";
		assertEquals("Check that ViewAllFeedbacklist", testOutput, allFeedbacks);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		FeedbacksMain.addFeedback(feedbacksList, fb1);
		FeedbacksMain.addFeedback(feedbacksList, fb2);
		
		assertEquals("Test if that FeedBacks arraylist size is 2?", 2, feedbacksList.size());
		
		//Test if the expected output string same as the list of feedbacks retrieve 
		allFeedbacks = FeedbacksMain.retrieveAllFeedback(feedbacksList);
		
		testOutput = String.format("%-10s %-20s %-10d %-50s %-10s\n", "J0001", "James", 99999999, "The service provided was good", "1 June 2020");
		testOutput += String.format("%-10s %-20s %-10d %-50s %-10s\n", "J0002", "Mary", 97756342, "The staff is able to answer my queries", "28 May 2021");
		
		assertEquals("Check that ViewAllFeedbackslist", testOutput, allFeedbacks);
		
	}
	@Test
	public void testDeleteFeedbacks() {
		
		// Given an empty list, after adding 2 users, test if the size of the list is 2
		FeedbacksMain.addFeedback(feedbacksList, fb1);
		FeedbacksMain.addFeedback(feedbacksList, fb2);
		assertEquals("Test if that user arraylist size is 1?", 2, feedbacksList.size());

		// The user added is as same as the first item of the list
		assertSame("Test that user is added same as 1st user of the list?", fb1, feedbacksList.get(0));

		// Test that user list is not null, so that the user can be deleted
		assertNotNull("Test if there is valid user arraylist to delete user from", feedbacksList);

		// Deleting user.Test the size of the list is to 1
		FeedbacksMain.doDeletingFeedbacks(feedbacksList, fb1.getId());
		assertEquals("test that user arraylist size is 1?", 1, feedbacksList.size());
		assertSame("Test that 2nd user is moved to the first item of the list?", fb2, feedbacksList.get(0));
	}

	
		//check feedbacks list is not null, so that can add a feedback
//		assertNotNull("Test if there is valid Feedback arraylist to add to", feedbacksList);
//		
//		FeedbacksMain.addFeedback(feedbacksList, fb1);
//		FeedbacksMain.addFeedback(feedbacksList, fb3);
//		
//		//Given an empty list, after adding 2 feedbacks, the size of the list is 2? 
//		FeedbacksMain.deleteFeedbacks(feedbacksList, fb1);
//		
//		assertEquals("Test if that Feedbacks arraylist size is 1?", fb1, feedbacksList.size());
//		
//		//Feedback is the same as the first feedback in the list
//		assertSame("Test that Feedback is added as 1st of the list?", fb3, feedbacksList.get(0));
//		
//		//Delete feedback
//		FeedbacksMain.deleteFeedbacks(feedbacksList, fb2);
//		assertEquals("Test that Feedbacks arraylist size is 2?", 2, feedbacksList.size());
//		assertSame("Test that Feedbacks is added as 2nd of the list?", fb2, feedbacksList.get(1));
////		assertSame("Test that Feedbacks is added same as 3rd item of the list?", fb1, feedbacksList.get(0));
//	}
	@After
	public void tearDown() throws Exception{
		fb1 = null;
		fb2 = null;
		fb3 = null;
		feedbacksList = null;
	}
}

		
		
		

