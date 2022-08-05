import java.util.ArrayList;

public class UserAccount extends Buyer {
	private String address;

	public UserAccount(String id, String name, int Contact_details, String address) {
		super(id, name, Contact_details);
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
