
public class AirplaneSeating {
	private char[][] seat_plan;
	
	public AirplaneSeating(char[][] seating) {
		this.seat_plan = seating;
	}

	public AirplaneSeating() {
		this.seat_plan = new char[15][6];
		for (int i =0; i<15; i++) {
			for (int j = 0; j<6; j++) {
				this.seat_plan[i][j] = '*';
			}
		}
	}
	
	public void printSeatingArrangement() {
		System.out.println("      A    B    C    D    E    F");
		for (int i=0; i<seat_plan.length;i++) {   //seat layout print
			System.out.print(String.format("%02d", i+1)+"    ");
			for (int j=0; j<seat_plan[0].length;j++) {
				System.out.print(seat_plan[i][j]+"    ");
			}
			System.out.println();
			
		}
		System.out.println("\nHere, * indicates that the seat is available; x indicates that the seat is occupied.");
	}

	public char[][] getSeat_plan() {
		return seat_plan;
	}

	public void setSeat_plan(char[][] seat_plan) {
		this.seat_plan = seat_plan;
	}
}
