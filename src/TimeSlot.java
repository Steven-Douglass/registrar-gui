import java.time.DayOfWeek;
import java.time.LocalTime;

public class TimeSlot {
	public DayOfWeek dayOfWeek;
	public LocalTime startTime;
	public LocalTime endTime;

	// Constructor
	TimeSlot(DayOfWeek weekday, LocalTime startTime, LocalTime endTime) {
		this.dayOfWeek = weekday;
		this.startTime = startTime;
		this.endTime = endTime;
	}

}
