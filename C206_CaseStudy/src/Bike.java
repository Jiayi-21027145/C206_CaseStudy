
public class Bike  {
	
	// Yesterday, the bikelisting you guys changed it, This class 
	//diagram is the new one that I should use.
	
	
	private int Quantity;
	private String Features;
	private double Price;
	
	public Bike(int quantity, String features, double price) {
		Quantity = quantity;
		Features = features;
		Price = price;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public String getFeatures() {
		return Features;
	}

	public void setFeatures(String features) {
		Features = features;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}
	
	
}
