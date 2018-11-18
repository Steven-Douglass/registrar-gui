import java.util.ArrayList;

public class Section {
	private static int staticCRN = 40001; // Hold the CRN at the class level
	public Integer CRN = 0; // Hold the CRN for each individual Section
	public Course course;
	public Instructor instructor;
	public ArrayList<TimeSlot> timeSlots = new ArrayList<>();

	// Constructor
	Section(Course course, Instructor instructor) {
		// Add the CRN to the Section being instantiated,
		// then increment the static CRN
		this.CRN = staticCRN;
		staticCRN++;

		// Add the course and instructor to the Section
		this.course = course;
		this.instructor = instructor;
	}

	// Add a TimeSlot
	public void addTimeSlot(TimeSlot t) {
		timeSlots.add(t);
	}

	// Get the schedule
	public String getSchedule() {
		if (timeSlots.size() == 0) {
			return "Online";
		} else {
			String schedule = "";
			for (int i = 0; i < timeSlots.size(); i++) {
				schedule += timeSlots.get(i).dayOfWeek + " " + timeSlots.get(i).startTime + "-"
						+ timeSlots.get(i).endTime + " ";
			}
			return schedule;
		}
	}

}
