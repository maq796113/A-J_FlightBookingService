
public class Ticket extends Passenger{
	
	
	
	
	public Ticket(String name, int cnic, int contact_num, String seat) {
		super(name, cnic, contact_num, seat);
		
	}


	private int price;
	
	
	
	public void calculatePrice() {
		this.price = 150000;

	}



	public int getPrice() {
		return price;
	}
	
	

}
