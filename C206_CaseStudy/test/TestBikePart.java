import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBikePart {

	private BikePart bp1;
	private BikePart bp2;
	private BikePart bp3;
	
	private ArrayList<BikePart> bikepartList;

	public TestBikePart() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		bp1 = new BikePart(2,"Help the object move",9.20,"Wheel Tube");
		bp2 = new BikePart(1,"To have a place to sit down",10.90,"Seat"); 
		bp3 = new BikePart(1,"Connects the wheel and the pedal",9.90,"Chain");
		
		bikepartList = new ArrayList<BikePart>();
	}

	@Test
	public void testAddBikePart() {
		assertNotNull("Test if there is valid BikePart arraylist to add to", bikepartList);

		BikePartMain.addBikePart(bikepartList, bp1);
		assertEquals("Test if that bikepart arraylist size is 1?", 1, bikepartList.size());

		assertSame("Test that bikepart is added same as 1st bikepart of the list?", bp1, bikepartList.get(0));

		BikePartMain.addBikePart(bikepartList, bp2);
		BikePartMain.addBikePart(bikepartList, bp3);
		assertEquals("test that Feedback arraylist size is 4?", 3, bikepartList.size());
		assertSame("test that Feedback is added same as the 4rd item of the list?", bp3, bikepartList.get(2));
	}

	@Test
	public void testRetrieveBikePart() {

		// Test if feedbacks list is not null but empty, so that can add new item
	    assertNotNull("test if there is valid Appointment arraylist to add to", bikepartList);

	    // test if the list of feedback retrieved from the feedbackMainis empty
	    String allBikePart = BikePartMain.retrieveAllBikePart(bikepartList);
	    String testOutput = "";
	    assertEquals("Check that ViewAllappointmentList", testOutput, allBikePart);

	    // Given an empty list, after adding 2 items, test if the size of the list is 2
	    BikePartMain.addBikePart(bikepartList, bp1);
	    BikePartMain.addBikePart(bikepartList, bp2);

	    assertEquals("Test if that Appointment arraylist size is 2?", 2, bikepartList.size());

	    // Test if the expected output string same as the list of feedbacks retrieve
	    allBikePart = BikePartMain.retrieveAllBikePart(bikepartList);

	    testOutput = String.format("%-20d %-10s %-10.2f %-20s\n", 2, "Help the object move",9.20,"Wheel Tube");
	        
	    testOutput += String.format("%-20d %-10s %-10.2f %-20s\n",1,"To have a place to sit down",10.90,"Seat"); 

	    assertEquals("Check that ViewAllBikePartlist", testOutput, allBikePart);

	  }
	
	@Test
	public void testDeleteBikePart() {

		BikePartMain.addBikePart(bikepartList, bp1);
		BikePartMain.addBikePart(bikepartList, bp2);
		assertEquals("Test if that Appointment arraylist size is 1?", 2, bikepartList.size());

		// The item just added is as same as the first item of the list
		assertSame("Test that bikepart is added same as the 1st bikepart of the list?", bp1, bikepartList.get(0));

		// Test if feedbacks list is not null but empty, so that can add new item
		assertNotNull("test if there is valid bikepart arraylist to delete to", bikepartList);

		// Delete the feedback , test the size of the list is 1
		BikePartMain.doDeleteBikePart(bikepartList, bp1.getPartname());
		assertEquals("Test that bikepart arrayList is 0?", 1, bikepartList.size());
		assertSame("Test that bikepart is added same as 3rd item of the list?", bp2, bikepartList.get(0));
	}

	@After
	public void teardown() throws Exception {
		bp1 = null;
		bp2 = null;
		bp3 = null;
		bikepartList = null;
	}
}
