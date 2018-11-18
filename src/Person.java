public class Person {
	private String lastName;
	private Integer id;

	// Constructor
	Person(int ID, String lastName) {
		this.id = ID;
		this.lastName = lastName;
	}

	// Getters and setters

	// Get the last name
	public String getLastName() {
		return lastName;
	}

	// Set the last name
	public void setLastName(String s) {
		lastName = s;
	}

	// Get the ID
	public Integer getID() {
		return id;
	}

	// Set the ID
	public void setId(Integer id) {
		this.id = id;
	}
}
