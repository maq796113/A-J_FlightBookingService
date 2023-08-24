public class EconomyClassFlight implements FlightClass {

	@Override
	public boolean checkAvailability(AirplaneSeating as) {
		char[][] seat = as.getSeat_plan();
		for (int i=0; i<seat.length; i++) {
			for (int j=0; j<seat[0].length; j++) {
				if (i >= 10 && i < 15) {
					if (seat[i][j] == '*') {
						return true;
					}
				}
			}
		}
		return false;
		
	}
	
	

	@Override
	public void bookTicket(AirplaneSeating as, Passenger passenger) {
		String seat = passenger.getSeat();
		char[][] seatplan = as.getSeat_plan();
		for (int k=0; k<seatplan.length; k++) {
			for (int l=0; l<seatplan[0].length; l++) {
				if (k == ((int) seat.charAt(0) - '0' - 1)) {
					if (((int) seat.charAt(1) - 65)*-1== l)
						seatplan[k][l] = 'x';
				}
			}
		}
		
	}

	@Override
	public void message() {
		System.out.println("The Rows 11 to 15 Are Economy Class Seats");
		
	}

}
