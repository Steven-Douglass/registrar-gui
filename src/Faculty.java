import java.util.ArrayList;

public class Faculty {
	private ArrayList<Instructor> instructors = new ArrayList<Instructor>();

	// Get the ArrayList of instructors
	public ArrayList<Instructor> getInstructors() {
		return instructors;
	}

	// Add an instructor to the ArrayList instructors
	public void addInstructor(Instructor i) {
		instructors.add(i);
	}
}
