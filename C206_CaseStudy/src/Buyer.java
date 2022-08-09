
public class Buyer {
	private String id;
	private String name;
	private int Contact_details;
	
	public Buyer(String id, String name, int Contact_details) {
		this.id = id;
		this.name = name;
		this.Contact_details = Contact_details;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getContact_details() {
		return Contact_details;
	}
	public void setContact_details(int contact) {
		this.Contact_details = contact;
	}

}
