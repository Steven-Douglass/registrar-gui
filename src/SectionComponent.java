import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SectionComponent {
	public JPanel sectionComponent;
	SectionComponent(Section s, int alternatingColor, Student student) {
		sectionComponent = new JPanel(new GridLayout(1,5));
		JPanel buttonPanel = new JPanel();
		JButton CRN = new JButton(s.CRN.toString());	
		CRN.setMaximumSize(new Dimension(10, 10));
		buttonPanel.add(CRN);
		JLabel courseNumber = new JLabel(s.course.getCourseNumber());
		JLabel title = new JLabel(s.course.getTitle());
		JLabel instructor = new JLabel(s.instructor.getLastName());
		JLabel schedule = new JLabel(s.getSchedule());
		
		// Add an event listener to the button
		CRN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean conflict = false;
				// If the student is not currently enrolled in this section
				if (student.currentSections.containsKey(s.CRN) == false) {					
					if (s.timeSlots.isEmpty()) {
						// If there are no timeslots, it's an online class.
						// Add the class without issue:
						student.add(s);
					} else {
						for (Section section : student.currentSections.values()) {
							for (int i = 0; i < s.timeSlots.size(); i++) {
								for (int j = 0; j < section.timeSlots.size(); j++) {
									if ((s.timeSlots.get(i).startTime == section.timeSlots.get(j).startTime)
											&& (s.timeSlots.get(i).dayOfWeek == section.timeSlots.get(j).dayOfWeek)) {
										conflict = true;
									}
								}
							}
						}
						if (conflict == false) {
							student.add(s);
						}
					}
					
				} else {
					// The student is already enrolled in this class, so drop it
					student.drop(s);
				}
				String currentSections = "";
				for (Section value : student.currentSections.values()) {
				     currentSections += student.currentSections.get(value.CRN).CRN + 
								" " + student.currentSections.get(value.CRN).course.getTitle() + ", ";
				}
				if (currentSections.length() != 0) {
					// Trim the ", " off of the end of the string of current sections
					currentSections = currentSections.substring(0, currentSections.length() - 2);
				}
				
				if (conflict == true) {
					currentSections += " [ Cannot add class due to scheduling conflict ]";
				}
				RegistrarGUI.updateFeedBackString(currentSections);
			}
		});
		
		// Set the alternating color
		Color beige = new Color(226, 230, 184);
		if (alternatingColor % 2 == 0) {
			sectionComponent.setBackground(Color.WHITE);
			buttonPanel.setBackground(Color.WHITE);
		} else {
			sectionComponent.setBackground(beige);
			buttonPanel.setBackground(beige);
		}
		
		// Add the components to the JPanel sectionComponent
		sectionComponent.add(buttonPanel);
		sectionComponent.add(courseNumber);
		sectionComponent.add(title);
		sectionComponent.add(instructor);
		sectionComponent.add(schedule);	
		sectionComponent.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
	}
}
