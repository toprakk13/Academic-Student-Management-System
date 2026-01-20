
public class Grades {
	private String grade;
	private double gradeNumeric;
	public double getGradeNumeric() {
		return gradeNumeric;
	}
	public void setGradeNumeric(double gradeNumeric) {
		this.gradeNumeric = gradeNumeric;
	}
	private String studentId;
	private String courseCode;
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public Grades(String grade, String studentId, String courseCode) {
		
		this.grade = grade;
		this.studentId = studentId;
		this.courseCode = courseCode;
	}
public Grades(double grade, String studentId, String courseCode) {
		
		gradeNumeric = grade;
		this.studentId = studentId;
		this.courseCode = courseCode;
	}
	

}
