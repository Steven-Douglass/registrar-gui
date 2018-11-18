import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Random;

public class Driver {
	public static void main(String[] args) {
		// Variables
		Catalog catalog = new Catalog();
		Term term = new Term("Fall 2018"); 
		Faculty faculty = new Faculty();
		Student student = new Student(1, "Douglass");
		Availability availability = new Availability();

		// Populate the objects
		createInstructors(faculty);
		createCourses(catalog);
		createTimeSlots(availability);
		createSections(catalog, faculty, term, availability);

		// GUI
		RegistrarGUI GUI = new RegistrarGUI(student, term);
	}

	// Create instructors and add them to the Faculty object
	private static void createInstructors(Faculty faculty) {
		faculty.addInstructor(new Instructor(101, "Johnson"));
		faculty.addInstructor(new Instructor(102, "Kay"));
		faculty.addInstructor(new Instructor(103, "Xu"));
		faculty.addInstructor(new Instructor(104, "Mulligan"));
		faculty.addInstructor(new Instructor(105, "Muldoon"));
		faculty.addInstructor(new Instructor(106, "Stanzione"));
		faculty.addInstructor(new Instructor(107, "Brady"));
		faculty.addInstructor(new Instructor(108, "Sawyer"));
		faculty.addInstructor(new Instructor(109, "Brown"));
		faculty.addInstructor(new Instructor(110, "Harrison"));
		faculty.addInstructor(new Instructor(111, "Ford"));
		faculty.addInstructor(new Instructor(112, "Danzinger"));
		faculty.addInstructor(new Instructor(113, "Clarke"));
		faculty.addInstructor(new Instructor(114, "Abraham"));
		faculty.addInstructor(new Instructor(115, "Perkowski"));
		faculty.addInstructor(new Instructor(116, "Brando"));
	}

	// Create courses and add them to the Catalog object
	private static void createCourses(Catalog catalog) {
		catalog.addCourse(new Course("ART 01.101", "Art Appreciation", Department.Art));
		catalog.addCourse(new Course("ART 01.201", "Painting with Oils", Department.Art));
		catalog.addCourse(new Course("ART 01.202", "Painting with Water Colors", Department.Art));
		catalog.addCourse(new Course("BIOL 01.110", "Genetics", Department.Biology));
		catalog.addCourse(new Course("BIOL 04.301", "Anatomy and Physiology", Department.Biology));
		catalog.addCourse(new Course("CHEM 01.101", "Introduction to Chemistry", Department.Chemistry));
		catalog.addCourse(new Course("CHEM 01.201", "Organic Chemistry", Department.Chemistry));
		catalog.addCourse(new Course("CHEM 01.301", "Analytical Chemistry", Department.Chemistry));
		catalog.addCourse(new Course("CSC 04.114", "Object Oriented Programming", Department.Computer_Science));
		catalog.addCourse(new Course("CSC 04.301", "Human Computer Interaction", Department.Computer_Science));
		catalog.addCourse(new Course("CSC 07.211", "Artificial Intelligence", Department.Computer_Science));
		catalog.addCourse(new Course("CSC 04.370", "Software Engineering", Department.Computer_Science));
		catalog.addCourse(new Course("CSC 04.210", "Data Structures and Algorithms", Department.Computer_Science));
		catalog.addCourse(new Course("ECON 01.101", "Microeconomics", Department.Economics));
		catalog.addCourse(new Course("HIS 01.101", "Western Civilization", Department.History));
		catalog.addCourse(new Course("HIS 01.331", "Civil Wars", Department.History));
		catalog.addCourse(new Course("MUS 01.214", "The Genres of Rock Music", Department.Music));
		catalog.addCourse(new Course("PHIL 01.111", "Ethics", Department.Philosophy));
		catalog.addCourse(new Course("PHIL 01.221", "Existentialism", Department.Philosophy));
		catalog.addCourse(new Course("PHY 02.121", "Introduction to Mechanics", Department.Physics));
		catalog.addCourse(new Course("PSY 04.114", "Abnormal Psychology", Department.Psychology));
	}

	// Populate the Availability object with TimeSlot objects
	private static void createTimeSlots(Availability availability) {
		TimeSlot myTimeSlot;
		for (int i = 1; i <= 5; i++) {
			for (int j = 9; j <= 18; j++) {
				myTimeSlot = new TimeSlot(DayOfWeek.of(i), LocalTime.of(j, 0), LocalTime.of(j, 50));
				availability.addTimeSlot(myTimeSlot);
			}
		}
	}

	// Create three sections per course in the catalog. Each course
	// will receive a random instructor and random timeslot.
	private static void createSections(Catalog catalog, Faculty faculty, Term term, Availability availabilty) {
		// Create a new random number generator
		Random random = new Random();
		// Initialize three sections since we need three sections for each course
		Section section1;
		Section section2;
		Section section3;
		// Iterate through each course
		for (int i = 0; i < catalog.courses.size(); i++) {
			// For each course generate a random instructor
			Instructor randomInstructor = faculty.getInstructors().get(random.nextInt(16));
			// Create three sections for each course
			section1 = new Section(catalog.courses.get(i), randomInstructor);
			section2 = new Section(catalog.courses.get(i), randomInstructor);
			section3 = new Section(catalog.courses.get(i), randomInstructor);

			// Generate random timeslots. There are 50 to choose from (10 each day Monday
			// through Friday)
			TimeSlot randomTimeSlot1 = availabilty.timeSlots.get(random.nextInt(50));
			TimeSlot randomTimeSlot2 = availabilty.timeSlots.get(random.nextInt(50));
			TimeSlot randomTimeSlot3 = availabilty.timeSlots.get(random.nextInt(50));

			// Add 0 TimeSlots to section1 (This will be the online class).
			// Add 1 TimeSlot to section2 (This will be the hybrid class).
			// Add 2 TimeSlots to section3 (This will be the traditional class).
			section2.addTimeSlot(randomTimeSlot1);
			section3.addTimeSlot(randomTimeSlot2);
			section3.addTimeSlot(randomTimeSlot3);

			// Add the sections to the term
			term.addSection(section1);
			term.addSection(section2);
			term.addSection(section3);
		}
	}
}