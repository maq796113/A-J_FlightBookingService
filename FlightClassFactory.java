
public class FlightClassFactory {

	public FlightClass getClass(String flightClass) {
		if (flightClass == null || flightClass.isEmpty()) {
			return null;
		}
		switch (flightClass) {
		case "First Class":
			return new FirstClassFlight();
		
		case "Business Class":
			return new BusinessClassFlight();
		
		case "Economy Class":
			return new EconomyClassFlight();
		
		default:
			throw new IllegalArgumentException("Unknown Class: "+flightClass);
		}
			
	}
}
	


