package uni;

import java.util.ArrayList;
import java.util.List;

public class studentPerformance extends Human {

	private String[] semesterName;
	private List<Paper> papers;
	private double[] marks;

	public studentPerformance(String ID, String dateOfBirth, String[] semesterName, double[] marks,
			List<Paper> papers) {
		super(ID, dateOfBirth);
		this.semesterName = semesterName;
		this.marks = marks;
		this.papers = new ArrayList<>();
	}

	public String[] getSemesterName() {
		return semesterName;
	}

	public double[] getMarks() {
		return marks;
	}

	public List<Paper> getPapers() {
		return papers;
	}

	public void addPaper(Paper paper) {
		papers.add(paper);
	}

	@Override
	public void getInfo() {
		System.out.println(getSemesterName() + " " + getMarks() + " " + getPapers());
	}
}
