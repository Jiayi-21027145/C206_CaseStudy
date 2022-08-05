
public class BikeListing extends Bike{

	private String bikeName;
	
	public BikeListing(int quantity, String features, double price, String bikeName) {
		super(quantity, features, price);
		this.bikeName = bikeName;
	}
	public String getBikeName() {
		return bikeName;
	}
	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}
}