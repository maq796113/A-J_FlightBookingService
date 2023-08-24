import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;



public class Flight {
	
	public Flight(String start_point, String destination, String flightClass, String departure_time) {
		super();
		flight_id = UUID.randomUUID();
		this.destination = destination;
		FlightClassFactory fcf = new FlightClassFactory();
		  
		
		this.flightClass = fcf.getClass(flightClass);
		this.departure_time = departure_time;
	}
	private UUID flight_id;
	private String start_point;
	private String destination;
	private FlightClass flightClass;
	private String departure_time;
	private String arrival_time;
	
	public void calculateArrivalTime() {
		String durationInput = " ";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime departureTime = LocalDateTime.parse(this.departure_time, formatter);
        String[] places = {"Lahore", "Islamabad", "Peshawar", "Faisalabad", "Skardu", "Karachi"};
        Map<String, String[]> durationMap = new HashMap<>();  //key: city1     value: [city2, duration]
        
        durationMap.put(places[0], new String[] {places[1], "00:59"});
        durationMap.put(places[0], new String[] {places[2], "01:30"});
        durationMap.put(places[0], new String[] {places[3], "00:30"});
        durationMap.put(places[0], new String[] {places[4], "03:30"});
        durationMap.put(places[0], new String[] {places[5], "04:10"});
        
        durationMap.put(places[1], new String[] {places[2], "01:05"});
        durationMap.put(places[1], new String[] {places[3], "00:30"});
        durationMap.put(places[1], new String[] {places[4], "02:30"});
        durationMap.put(places[1], new String[] {places[5], "05:30"});
        
        durationMap.put(places[2], new String[] {places[3], "02:30"});
        durationMap.put(places[2], new String[] {places[4], "03:10"});
        durationMap.put(places[2], new String[] {places[5], "6:30"});
        
        durationMap.put(places[3], new String[] {places[4], "04:50"});
        durationMap.put(places[3], new String[] {places[5], "06:30"});
        
        durationMap.put(places[4], new String[] {places[5], "08:30"});
        
        
        for (Map.Entry<String, String[]> entry : durationMap.entrySet()) {
        	String key = entry.getKey();
        	String[] value = entry.getValue();
        	if ((this.start_point == key || this.destination == key) && (this.start_point == value[0] || this.destination == value[0])) {
        		durationInput = value[1];
        	}
        }
        
     
        Duration duration = Duration.parse("PT" + durationInput.replace(":", "H") + "M");
        this.arrival_time = departureTime.plus(duration).toString();

	}
	
	public UUID getFlight_id() {
		return flight_id;
	}
	
	
	public FlightClass getFlightClass() {
		return flightClass;
	}
	public void setFlightClass(String flightClass) {
		FlightClassFactory fcf = new FlightClassFactory();
		this.flightClass = fcf.getClass(flightClass);
		
	}
	public String getDeparture_time() {
		return departure_time;
	}
	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}
	public String getArrival_time() {
		return arrival_time;
	}
	
	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getStart_point() {
		return start_point;
	}

	public void setStart_point(String start_point) {
		this.start_point = start_point;
	}
	
	
	
	
	

}
