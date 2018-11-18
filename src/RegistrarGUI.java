import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegistrarGUI {
	// Create the JFrame
	JFrame frame;
	static String status = "Feedback";
	static JLabel feedback = new JLabel(status);
	// term will store the Term we pass the constructor
	Term term;
	// Create the components for the South Panel
	JPanel southPanel = new JPanel();
	JPanel centerPanel = new JPanel(new GridLayout(0,1));
	ArrayList<Section> sectionList = new ArrayList<>();
	Student student;

	// Constructor
	RegistrarGUI(Student student, Term term) {
		this.student = student;
		this.term = term;
		frame = new JFrame("Banner Self Service for " + student.getLastName());
		frame.setLayout(new BorderLayout());
		frame.setMinimumSize(new Dimension(1200, 120));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		addToPanel();
	}
	
	// Create components and add them to our panel. Add the panels to our frame.
	public void addToPanel() {
		
		/////////////////////////////
		//North Panel
		/////////////////////////////
		
		// Create the components for the North Panel
		JPanel northPanel = new JPanel();
		JLabel message = new JLabel("Select a department");
		JComboBox departments = new JComboBox(Department.values());
		// Add the JComboBox action listener
		departments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Remove any current sections stored in our section list
				sectionList.removeAll(sectionList);
				// Store the selected department
				Object selectedObject = departments.getSelectedItem();
				// Loop through our term to find sections with a matching department
				int sectionsFound = 0;
				for (int i = 0; i < term.getTerm().size(); i++) {
					if (selectedObject == term.getTerm().get(i).course.getDepartment()) {
						sectionsFound++;
						// Add sections with a matching department to our list of sections
						sectionList.add(term.getTerm().get(i));
						
					}
				}	
				updateFeedback(sectionsFound, selectedObject);
				centerPanel.removeAll();
				
				// If there are sections, add the menu
				if (sectionsFound != 0) {
					// Add the menu
					JPanel menu = new JPanel(new GridLayout(1,5));
					menu.setBackground(Color.WHITE);
					JLabel CRN = new JLabel("Click CRN to add or drop course");
					JLabel courseNumber = new JLabel("Course Number");
					JLabel title = new JLabel("Title");
					JLabel instructor = new JLabel("Instructor");
					JLabel schedule = new JLabel("Schedule");
					CRN.setForeground(Color.BLUE);
					courseNumber.setForeground(Color.BLUE);
					title.setForeground(Color.BLUE);
					instructor.setForeground(Color.BLUE);
					schedule.setForeground(Color.BLUE);
					/////////////////////////////
					//Center Panel
					/////////////////////////////
					menu.add(CRN);
					menu.add(courseNumber);
					menu.add(title);
					menu.add(instructor);
					menu.add(schedule);
					menu.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
					// Add the menu to the center panel
					centerPanel.add(menu);
				}
				
				// Iterate through each section and use it to create a SectionComponent
				int alternatingColor = 0;
				for (int i = 0; i < sectionList.size(); i++) {
					SectionComponent s = new SectionComponent(sectionList.get(i), alternatingColor, student);
					JPanel sectionPanel = s.sectionComponent;
					centerPanel.add(sectionPanel);
					alternatingColor ++;
				}
				frame.pack();				
			}
		});	
		// Add the North Panel components to the North Panel
		northPanel.add(message);
		northPanel.add(departments);

		/////////////////////////////
		//South Panel
		/////////////////////////////
		
		// Add the South Panel components to the South Panel
		southPanel.add(feedback);
		
		// Add the panels to the frame
		frame.add(northPanel, BorderLayout.NORTH);
		frame.add(southPanel, BorderLayout.SOUTH);
		frame.add(centerPanel, BorderLayout.CENTER);
		frame.setVisible(true);
		frame.pack();
	}
	
	public void updateFeedback(Integer i, Object d) {
		feedback.setText(i + " sections of " + d.toString() + " found ");
	}
	
	public void updateFeedback2() {
		feedback.setText(student.currentSections.toString());
	}
	
	public static void updateFeedBackString(String s) {
		feedback.setText(s);
	}
}
