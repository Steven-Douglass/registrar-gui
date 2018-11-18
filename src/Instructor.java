
public class Instructor extends Person {
	String department;
	
	// Constructor
	Instructor(int ID, String lastName) {
		super(ID, lastName);

	}
	
	// Set the department to the string parameter that is passed to the method
	public void setDepartment(String s) {
		department = s;
	}
	
	// Get the department
	public String getDepartment() {
		return department;
	}
}
