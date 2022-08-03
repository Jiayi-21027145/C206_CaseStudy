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
		
		fb1 = new Feedbacks("James", 12345678, "The service provided was good", "1 June 2020");
		fb2 = new Feedbacks("Mary", 97756342, "The staff is able to answer my queries", "28 May 2021");
		fb3 = new Feedbacks("Andy", 87654321, "The app provide the things that I need", "23 February 2022");
		
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
		assertEquals("test that Feedback arraylist size id 3?", 3, feedbacksList.size());
		assertSame("test that Feedback is added same as the 3rd item of the list?", fb3, feedbacksList.get(2));
		
	}
	
	@Test
	public void testRetrieveFeedbacks() {
		//Test if feedbacks list is not null but empty, so that can add new item
		assertNotNull("test if there is valid Feedback arraylist to add to", feedbacksList);
		
		//test if the list of feedback retrieved from the feedbackMainis empty
		String allFeedbacks = FeedbacksMain.retrieveAllFeedback(feedbacksList);
		String testOutput = "";
		assertEquals("Check that ViewAllFeedbacklist", testOutput, allFeedbacks);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		FeedbacksMain.addFeedback(feedbacksList, fb1);
		FeedbacksMain.addFeedback(feedbacksList, fb2);
		
		assertEquals("Test if that Feednacks arraylist size is 2?", 2, feedbacksList.size());
		
		//Test if the expected output string same as the list of feedbacks retrieve 
		allFeedbacks = FeedbacksMain.retrieveAllFeedback(feedbacksList);
		
		testOutput = String.format("%-20s %-10d %-50s\n", "James", 12345678, "The service provided was good");
		testOutput += String.format("%-20s %-10d %-50s\n", "Mary", 97756342, "The staff is able to answer my queries");
		
		assertEquals("Check that ViewAllFeedbackslist", testOutput, allFeedbacks);
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
//	public void setUp() throws Exception {
//	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test
//	public void test() {
//		fail("Not yet implemented");
	}

//}
