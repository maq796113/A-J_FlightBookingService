public interface FlightClass {
	public boolean checkAvailability(AirplaneSeating as);
	
	public void bookTicket(AirplaneSeating as, Passenger passenger);
	
	public void message();

}
