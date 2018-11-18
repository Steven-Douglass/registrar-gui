import java.util.HashMap;

public class Student extends Person {
	String major;
	HashMap<Integer, Section> currentSections = new HashMap<Integer, Section>();
	
	// Constructor
	Student(int ID, String lastName) {
		super(ID, lastName);
	}
	
	 // Set the major
	public void setMajor(String s) {
		major = s;
	}
	
	// Get the major
	public String getMajor() {
		return major;
	}
	
	// Add a section
	public void add(Section s) {
		currentSections.put(s.CRN, s);
	}
	
	// Drop a section
	public void drop(Section s) {
		currentSections.remove(s.CRN);
	}
}
