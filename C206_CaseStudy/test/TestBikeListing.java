import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestBikeListing {

  // prepare test data
  private BikeListing bl1;
  private BikeListing bl2;
  private BikeListing bl3;

  private ArrayList<BikeListing> BikesList;

  public TestBikeListing() {
    super();
  }

  @Before
  public void setUp() throws Exception {

    // prepare test data

    bl1 = new BikeListing(45,"The bike performs best in the mountain terrain.",140.20,"BMX");
    bl2 = new BikeListing(34,"An all rounderbike performance",89.90,"Hybird");
    bl2 = new BikeListing(49,"Its thinness of the wheel allows it to move faster on the road!",134.20,"Road Bike");

    BikesList = new ArrayList<BikeListing>();
  }

  @Test
  public void testAddBike() {
    // List not null, can add new item
    assertNotNull("Test if there is valid Bike arraylist to add to", BikesList);

    // Given an empty list, after adding 1 bike name, the size of the list is 1
    BikeListingMain.addBike(BikesList, bl1);
    assertEquals("Test if that Bike arraylist size is 1?", 1, BikesList.size());

    // The item just added is as same as the first item of the list
    assertSame("Test that Bike is added same as 1st Bike of the list?", bl1, BikesList.get(0));

    // Add another item, test that size of the list is 2?
    BikeListingMain.addBike(BikesList, bl1);
    BikeListingMain.addBike(BikesList, bl3);
    assertEquals("test that Bike arraylist size position is 3?", 3, BikesList.size());
    assertSame("test that Bike is added same as the 3rd item of the list?", bl3, BikesList.get(2));

  }

  @Test
  public void testRetrieveAllBike() {
    // Test if bike list is not null but empty, so that can add new item
    assertNotNull("test if there is valid Bike arraylist to add to", BikesList);

    // test if the list of bike retrieved from the BikelistMain is empty
    String allBikes = BikeListingMain.retrieveAllBike(BikesList);
    String testOutput = "";
    assertEquals("Check that ViewAllBikeList", testOutput, allBikes);

    // Given an empty list, after adding 2 items, test if the size of the list is 2
    BikeListingMain.addBike(BikesList, bl1);
    BikeListingMain.addBike(BikesList, bl2);

    assertEquals("Test if that Appointment arraylist size is 2?", 2, BikesList.size());

    

  }
  @Test
  public void doDeleteBike() {
  // Given an empty list, after adding 2 items, test if the size of the list is 2.
    // After removing an item , then the size of the list become 1
    BikeListingMain.addBike(BikesList, bl1);
    BikeListingMain.addBike(BikesList, bl2);
    assertEquals("Test if that Appointment arraylist size is 1?", 2, BikesList.size());


    // The item just added is as same as the first item of the list
    assertSame("Test that appointment is added same as the 1st appointment of the list?", bl1,
        BikesList.get(0));

    
    // Test if bike list is not null but empty, so that can add new item
        assertNotNull("test if there is valid Bike arraylist to delete to", BikesList);


// Delete the Bikelist , test the size of the list is 1
    BikeListingMain.doDeleteBike(BikesList, bl1.getBikeName());
    assertEquals("Test that appointment arrayList is 0?", 1, BikesList.size());
    assertSame("Test that Appointment is added same as 3rd item of the list?", bl2 ,BikesList.get(0));

}
  
  @After
  public void teardown() throws Exception {
	  
    bl1 = null;
    bl2 = null;
    bl3 = null;    

    BikesList = null;
  }
}
