import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestAppointment {

	// prepare test data
	private Appointment ap1;
	private Appointment ap2;
	private Appointment ap3;

	private ArrayList<Appointment> appointmentList;

	public TestAppointment() {
		super();
	}

	@Before
	public void setUp() throws Exception {

		// prepare test data

		ap1 = new Appointment("J0001", "James", 12345678, "1 June 2020", "12.00pm");
		ap2 = new Appointment("J0002", "Mary", 97756342, "28 May 2021", "3.00pm");
		ap3 = new Appointment("J0003", "Andy", 87654321, "23 February 2022", "5.00pm");

		appointmentList = new ArrayList<Appointment>();
	}

	@Test
	public void testAddAppointment() {
		// List not null, can add new item
		assertNotNull("Test if there is valid Feedback arraylist to add to", appointmentList);

		// Given an empty list, after adding 1 feedback, the size of the list is 1
		AppointmentMain.addAppointment(appointmentList, ap1);
		assertEquals("Test if that feedbacks arraylist size is 1?", 1, appointmentList.size());

		// The item just added is as same as the first item of the list
		assertSame("Test that Feedback is added same as 1st feedbank of the list?", ap1, appointmentList.get(0));

		// Add another item, test that size of the list is 2?
		AppointmentMain.addAppointment(appointmentList, ap1);
		AppointmentMain.addAppointment(appointmentList, ap3);
		assertEquals("test that Feedback arraylist size id 3?", 3, appointmentList.size());
		assertSame("test that Feedback is added same as the 3rd item of the list?", ap3, appointmentList.get(2));

	}

	@Test
	public void testRetrieveAppointment() {
		// Test if feedbacks list is not null but empty, so that can add new item
		assertNotNull("test if there is valid Appointment arraylist to add to", appointmentList);

		// test if the list of feedback retrieved from the feedbackMainis empty
		String allAppointment = AppointmentMain.retrieveAllappointment(appointmentList);
		String testOutput = "";
		assertEquals("Check that ViewAllappointmentList", testOutput, allAppointment);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		AppointmentMain.addAppointment(appointmentList, ap1);
		AppointmentMain.addAppointment(appointmentList, ap2);

		assertEquals("Test if that Appointment arraylist size is 2?", 2, appointmentList.size());

		// Test if the expected output string same as the list of feedbacks retrieve
		allAppointment = AppointmentMain.retrieveAllappointment(appointmentList);

		testOutput = String.format("%-20s %-10s %-10d %-50s %-10s\n", "J0001", "James", 12345678, "1 June 2020",
				"12.00pm");
		testOutput += String.format("%-20s %-10s %-10d %-50s %-10s\n", "J0002", "Mary", 97756342, "28 May 2021",
				"3.00pm");

		assertEquals("Check that ViewAllAppointmentlist", testOutput, allAppointment);

	}
	@Test
	public void testDeleteAppointment() {
	// Given an empty list, after adding 2 items, test if the size of the list is 2.
		// After removing an item , then the size of the list become 1
		AppointmentMain.addAppointment(appointmentList, ap1);
		AppointmentMain.addAppointment(appointmentList, ap2);
	        assertEquals("Test if that Appointment arraylist size is 1?", 2, appointmentList.size());


		// The item just added is as same as the first item of the list
		assertSame("Test that appointment is added same as the 1st appointment of the list?", ap1,
				appointmentList.get(0));

		
		// Test if feedbacks list is not null but empty, so that can add new item
				assertNotNull("test if there is valid Feedback arraylist to delete to", appointmentList);

				
		// Delete the feedback , test the size of the list is 1
		AppointmentMain.doDeleteAppointment(appointmentList, ap1.getId());
		assertEquals("Test that appointment arrayList is 0?", 1, appointmentList.size());
		assertSame("Test that Appointment is added same as 3rd item of the list?", ap2 ,appointmentList.get(0));
}
	@After
	public void teardown() throws Exception {
		ap1 = null;
		ap2 = null;
		ap3 = null;
		appointmentList = null;
	}
}

