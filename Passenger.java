import java.util.UUID;

public class Passenger {
	
	private UUID passenger_id;
	private String name;
	private int cnic;
	private int contact_num;
	private String seat;

	
	
	public Passenger(String name, int cnic, int contact_num, String seat) {
		super();
		this.passenger_id = UUID.randomUUID();;
		this.name = name;
		this.cnic = cnic;
		this.contact_num = contact_num;
		this.setSeat(seat);
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getCnic() {
		return cnic;
	}
	
	



	public void setCnic(int cnic) {
		this.cnic = cnic;
	}



	public int getContact_num() {
		return contact_num;
	}



	public void setContact_num(int contact_num) {
		this.contact_num = contact_num;
	}
	


	public String getPassenger_id() {
		return passenger_id.toString();
	}



	public String getSeat() {
		return seat;
	}



	public void setSeat(String seat) {
		this.seat = seat;
	}
	
	
	
	

}
