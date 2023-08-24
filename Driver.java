import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Driver {
	static String password;
	static String username;
	static boolean exitWindow = false;
	
	static String fc = "First Class";
	static String ec = "Economy Class";
	static String bc = "Business Class";
	static int choice;
	
	static String departureTime; // 29/08/2024 01:45
	
	
	
	static String[] departureTimes = {"12:45", "01:45", "04:00"};
	static String[] availableDates = {"29/08/2024", "30/08/2024", "31/08/2024"};
	
	//ONLY DOMESTIC FLIGHTS
	static String[] places = {"Lahore", "Islamabad", "Peshawar", "Faisalabad", "Skardu", "Karachi", "Peshawar", "Quetta", "Hyderabad", "Gujranwala"};
	static String start_point;
	static String destination;
	static String _class;
	
	
	
	/*A&J Airlines
	 * 
	 * 
	 * class Passenger()
	 * 
	 * class Flight()  -------> 
	 * 
	 * class FlightClass()
	 * 
	 * class EconomyClassFlight()
	 * 
	 * class BusinessClassFlight()
	 * 
	 * class FirstClassFlight()
	 * 
	 * class Ticket()
	 * 
	 * class User()
	 * 
	 * 
	 * 
	 * 
	 */
	
	static void displayMenu() {
		System.out.println("****** __|__\n--o--o--(_)--o--o-- ******");
		System.out.println("******Welcome to A&J Airlines Ticket Booking Service******");
		System.out.println("1. SignIn\n2. SignUp\n3. Show Credits\n4. Exit");
	}
	
	static void displayCredits() {
		System.out.println("By: Muhammad Abdullah Qureshi (221437659)");
	}
	
	

	public static void main(String[] args) throws FileNotFoundException {
		
		
		Scanner scan = new Scanner(System.in);
		displayMenu();
		while (!exitWindow) {
			
			System.out.print("Enter Choice (1-4): ");
			choice = scan.nextInt();
			
			switch(choice) {
				case 1:
					System.out.print("Enter your username: ");
					scan.nextLine();
					username = scan.nextLine();
					System.out.print("\nEnter your password: ");
					password = scan.nextLine();
					SignIn signIn = new SignIn(username, password); //signIn
				try {
					if (signIn.isUserValid()) {
						getDestandStart();
						getFlightClass();
						getDepartureTime();
						Flight flight = new Flight(start_point, destination, _class, departureTime);
						flight.calculateArrivalTime();
						AirplaneSeating as = new AirplaneSeating();
						
						if (flight.getFlightClass().checkAvailability(as)) {
							flight.getFlightClass().message();
							as.printSeatingArrangement();
							System.out.print("Enter the seat (e.g., 1E, 3A etc.): ");
							String seat = scan.nextLine();
							System.out.println("Before we proceed we need to get the Passenger's details.");
							System.out.print("Enter Passenger's Name: ");
							String name = scan.nextLine();
							System.out.print("Enter Passenger's CNIC: ");
							int cnic = scan.nextInt();
							System.out.print("Enter Passenger's Contact Number: ");
							int c_num = scan.nextInt();
							
							Ticket ticket = new Ticket(name, cnic, c_num, seat);
							ticket.calculatePrice();
							System.out.println("Your Total Bill Is: Rs "+ticket.getPrice());
							flight.getFlightClass().bookTicket(as, ticket);
							
						
						}
						else {
							System.out.println("Seats Not Available");
						}
						
					}
					
					else {
						System.out.println("Invalid username or password");
						continue;
					}
						
					
				} catch (IOException e) {
					
					e.printStackTrace();
				}
					break;
					
					
					
				case 2:
					
					System.out.print("Enter your username: ");
					scan.nextLine();
					username = scan.nextLine();
					
					System.out.print("\nEnter your password: ");
					
					password = scan.nextLine();
					SignUp signUp = new SignUp(username, password); //signUp
					try {
						signUp.storeUserInDB();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							}
					
					break;
					
				case 3:
					displayCredits();
					break;
				case 4:
					System.out.println("Exiting");
					exitWindow = true;
					break;
				default:
					System.out.println("Invalid Input");
					break;
					
			}
			
		}
		scan.close();
	}

	private static void getDepartureTime() {
		try (Scanner _scan = new Scanner(System.in)) {
			System.out.println("What dates are you looking for departure");
			int len = 0;
			int c = 1;
			while (len<availableDates.length) {
				if (len == 0)
				System.out.println(c+". "+availableDates[len]);
				len++;
				c++;
			}
			int _cho;
			String date = " ";
			int k = 0;
			do {
				if (k>0)
					System.out.println("Error! Invalid choice entered, Try Again!");
				
				System.out.print("Enter choice: ");
				_cho = _scan.nextInt();
				
				k++;
				
			} while (_cho>availableDates.length || _cho<1);
			
			len = 0;
			while (len<availableDates.length) {
				if (len == _cho-1) {
					date = availableDates[len];
				}
					
				len++;
			}
			
			
			//Let's get time
			
			System.out.println("What times are you looking for departure?");
			len = 0;
			c = 1;
			while (len<departureTimes.length) {
				if (len == 0)
				System.out.println(c+". "+departureTimes[len]);
				len++;
				c++;
			}
			String time = " ";
			int l=0;
			do {
				if (l>0)
					System.out.println("Error! Invalid choice entered, Try Again!");
				
				System.out.print("Enter choice: ");
				_cho = _scan.nextInt();
				
				l++;
				
			} while (_cho>departureTimes.length || _cho<1);
			
			len = 0;
			while (len<departureTimes.length) {
				if (len == _cho-1) {
					time = departureTimes[len];
				}
		
					
					
				len++;
			}
			departureTime = date + " "+ time;
		}
	}

	private static void getFlightClass() {
		try (Scanner _scan = new Scanner(System.in)) {
			System.out.println("What class are you looking to get on?");
			System.out.println("1. "+fc+"\n2. "+bc+"3. "+ec);
			int _cho;
			int i = 0;
			do {
				if (i>0)
					System.out.println("Error! Invalid choice entered, Try Again!");
				
				System.out.print("Enter choice: ");
				_cho = _scan.nextInt();
				
				i++;
				
			} while (_cho>3 || _cho<1);
			
			if (_cho == 1)
				_class = fc;
			else if (_cho == 2)
				_class = bc;
			else
				_class = ec;
				
		} 
	}

	private static void getDestandStart() {
		
		Scanner _scan = new Scanner(System.in);
		System.out.println("As of now Domestic Flights are available");
		System.out.println("Where would you like to go?");
		for (int i=0; i< places.length; i++) {
			System.out.println(places[i]);
		}
		char[] is = takeInputsDestandStart(_scan);
		
		destination = covertInitials2Places(is[0]);
		start_point = covertInitials2Places(is[1]);
		if (destination == null && start_point == null) {
			System.out.println("Invalid input, try again");
			while (destination == null && start_point == null) {
				is = takeInputsDestandStart(_scan);
				destination = covertInitials2Places(is[0]);
				start_point = covertInitials2Places(is[1]);
			}
		}
		_scan.close();
	}

	private static char[] takeInputsDestandStart(Scanner scan) {
		char start_i;
		char dest_i;
		System.out.print("Pick your destination (enter the initials of the city): ");
		dest_i = scan.next().charAt(0);
		if (Character.isLowerCase(dest_i)) {
			dest_i = Character.toUpperCase(dest_i);
		}
		System.out.print("Pick your start point (enter the initials of the city): ");
		start_i = scan.next().charAt(0);
		if (Character.isLowerCase(start_i)) {
			start_i = Character.toUpperCase(start_i);
		}
		return new char[] {dest_i, start_i};
	}

	private static String covertInitials2Places(char i) {
		for (int j=0; j< places.length; j++) {
			if (places[j].charAt(0) == i) {
				return places[j];
			}
		}
		return null;
	}

	

}


