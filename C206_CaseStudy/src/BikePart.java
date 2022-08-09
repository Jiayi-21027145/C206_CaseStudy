
public class BikePart extends Bike {
	

    private String partname;

	public BikePart(int quantity, String features, double price, String partname) {
		super(quantity, features, price);
		this.partname = partname;
	}

	public String getPartname() {
		return partname;
	}

	public void setName(String partname) {
		this.partname = partname;
	}
}
	

	
		

