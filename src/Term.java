import java.util.ArrayList;

public class Term {
	private ArrayList<Section> term = new ArrayList<>();
	private String termName;
	
	// Constructor
	Term(String term) {
		termName = term;
	}
	
	// Get the term
	public ArrayList<Section> getTerm() {
		return term;
	}

	// Set the term
	public void setTerm(ArrayList<Section> term) {
		this.term = term;
	}

	// Get the term name
	public String getTermName() {
		return termName;
	}

	// Set the term name
	public void setTermName(String termName) {
		this.termName = termName;
	}

	// Add a section to the term
	public void addSection(Section s) {
		term.add(s);
	}
	
}
