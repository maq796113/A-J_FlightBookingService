import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;



public class Flight {
	
	public Flight(String start_point, String destination, String flightClass, String departure_time) {
		super();
		flight_id = UUID.randomUUID();
		this.start_point = start_point;
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
		String duration = " ";
		
        String[] places = {"Lahore", "Islamabad", "Peshawar", "Faisalabad", "Skardu", "Karachi"};
        Map<String, String[]> durationMap = new HashMap<>();  //key: city1     value: [city2, duration]
        
        durationMap.put("1", new String[] {places[0], places[1], "00:59"});
        durationMap.put("2", new String[] {places[0], places[2], "01:30"});
        durationMap.put("3", new String[] {places[0], places[3], "00:30"});
        durationMap.put("4", new String[] {places[0], places[4], "03:30"});
        durationMap.put("5", new String[] {places[0], places[5], "04:10"});
        
        durationMap.put("6", new String[] {places[1], places[2], "01:05"});
        durationMap.put("7", new String[] {places[1], places[3], "00:30"});
        durationMap.put("8", new String[] {places[1], places[4], "02:30"});
        durationMap.put("9", new String[] {places[1], places[5], "05:30"});
        
        durationMap.put("10", new String[] {places[2], places[3], "02:30"});
        durationMap.put("11", new String[] {places[2], places[4], "03:10"});
        durationMap.put("12", new String[] {places[2], places[5], "6:30"});
        
        durationMap.put("13", new String[] {places[3], places[4], "04:50"});
        durationMap.put("14", new String[] {places[3], places[5], "06:30"});
        
        durationMap.put("15", new String[] {places[4], places[5], "08:30"});
        
        
        for (Map.Entry<String, String[]> entry : durationMap.entrySet()) {
        	String[] value = entry.getValue();
        	if (start_point == value[0] || destination == value[0] && start_point == value[1] || destination == value[1])  {
        		duration = value[2];
        	}
        }
        
        
        this.arrival_time = calculateFinalTime(this.departure_time, duration);

	}
	
	private String calculateFinalTime(String initialTime, String duration) {
	    
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Calendar calendar = Calendar.getInstance();
        try {
            Date startTime = sdf.parse(initialTime);
            String[] durationParts = duration.split(":");
            int hours = Integer.parseInt(durationParts[0]);
            int minutes = Integer.parseInt(durationParts[1]);
            calendar.setTime(startTime);
            calendar.add(Calendar.HOUR_OF_DAY, hours);
            calendar.add(Calendar.MINUTE, minutes);
            
            return sdf.format(calendar.getTime());
            
            
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
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
