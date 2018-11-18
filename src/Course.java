
public class Course {
	private String courseNumber;
	private String title;
	private Department department;

	// Constructor
	Course(String courseNumber, String title, Department department) {
		this.courseNumber = courseNumber;
		this.title = title;
		this.department = department;
	}

	// Get the course number
	public String getCourseNumber() {
		return courseNumber;
	}

	// Get the course title
	public String getTitle() {
		return title;
	}

	// Get the course department
	public Department getDepartment() {
		return department;
	}
}
