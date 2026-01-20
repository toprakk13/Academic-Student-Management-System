import java.util.ArrayList;
import java.util.List;

public class Program extends AcademicEntity {
	private String department;
	private fileRead read=new fileRead();
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDegreeLevel() {
		return degreeLevel;
	}
	public void setDegreeLevel(String degreeLevel) {
		this.degreeLevel = degreeLevel;
	}
	public int getTotalCredits() {
		return totalCredits;
	}
	public void setTotalCredits(int totalCredits) {
		this.totalCredits = totalCredits;
	}
	private String  degreeLevel;
	private int totalCredits;
	private List<Course> courses=new ArrayList<>();
	private List<String> courseCodes = new ArrayList<>();
	public Program(String code, String name, String description, String department, String degreeLevel,
			int totalCredits) {
		super(code, name, description);
		this.department = department;
		this.degreeLevel = degreeLevel;
		this.totalCredits = totalCredits;
	}
	public void addCourse(Course course) {
        courses.add(course);
        courseCodes.add(course.getCode());
    }
	public List<Course> getCourses() {
        return courses;
    }
	public String toString() {
		String formatted = "{" + String.join(", ", courseCodes) + "}";
		
		return "Program Code: "+getCode()+"\n"
				+ "Name: "+getName()+"\n"
				+ "Department: "+getDepartment()+"\n"
				+ "Degree Level: "+degreeLevel+"\n"
				+ "Required Credits: "+totalCredits+"\n"
				+ "Courses: "+formatted+"\n";
	}
	public String reports(){
		return null;
		
	}
	

}
