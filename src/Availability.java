import java.util.ArrayList;

public class Availability {
	ArrayList<TimeSlot> timeSlots = new ArrayList<TimeSlot>();
	
	// Add a TimeSlot
	public void addTimeSlot(TimeSlot t) {
		timeSlots.add(t);
	}
}
