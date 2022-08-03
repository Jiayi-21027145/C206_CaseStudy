
//
public class Feedbacks extends Buyer{
	private String comments;
	private String date;
	
	public Feedbacks(String name, int Contact_details, String comments, String date) {
		super(name, Contact_details);
		this.comments = comments;
		this.date = date;
	}
	public String getComments(){
		return comments;
	}
	public String getDate() {
		return date;
	}
	public String toString() {
		String output = "";
		return output;
	}

}
