import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment extends Buyer{

	public Appointment(String id, String name, int Contact_details, String date, String time) {
		super(id, name, Contact_details);
		this.date = date;
		this.time = time;
	}
	private String date;
	private String time;
	public String getDate() {
		return date;
	}
	public String getTime() {
		return time;
	}
	
}
