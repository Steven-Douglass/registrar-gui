import java.util.ArrayList;

public class Catalog {
	public ArrayList<Course> courses = new ArrayList<>();
	
	// Add a course to the list
	public void addCourse(Course course) {
		courses.add(course);
	}
}
