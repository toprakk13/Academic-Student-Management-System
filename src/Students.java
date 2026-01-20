import java.util.ArrayList;

public class Students extends Persons implements StudentManagementSystem{
	private fileRead read=new fileRead();
	
	@Override
	public String reports() {
		// TODO Auto-generated method stub
		String enrolled="";
		String completed="";
		double gpa=0;
		double sum=0.0;
		double x=0.0;
		int numeric1=0;
		int numeric2=0;
		for(Grades i:read.getNumericGradeList()) {
			if(i.getCourseCode().equals(getCourseList().get(0)) && i.getStudentId().equals(getId())) {
				numeric1=Integer.parseInt(getCourseList().get(0).getCredit());
				sum=i.getGradeNumeric()*numeric1;
			}
		}
		for(Grades i:read.getNumericGradeList()) {
			if(i.getCourseCode().equals(getCourseList().get(1)) && i.getStudentId().equals(getId())) {
				numeric2=Integer.parseInt(getCourseList().get(1).getCredit());
				x=i.getGradeNumeric()*numeric2;
			}
		}
		gpa=(x+sum)/(numeric1+numeric2);
		if(!(getCourseList().isEmpty())||getCourseList().get(0).getGrade().equals("F3")||getCourseList().get(0).getGrade()==null) {enrolled+="- "+getCourseList().get(0).getName()+getCourseList().get(0).getCode()+"\n";
		}
		else if(!(getCourseList().get(1)==null)||getCourseList().get(1).getGrade().equals("F3")||getCourseList().get(1).getGrade()==null) {enrolled+="- "+getCourseList().get(1).getName()+getCourseList().get(1).getCode()+"\n";
		}
		else if(!(getCourseList().isEmpty())||!getCourseList().get(0).getGrade().equals("F3")) {completed+="- "+getCourseList().get(0).getName()+getCourseList().get(0).getCode()+"\n";
		}
		else if(!(getCourseList().get(1)==null)||!getCourseList().get(1).getGrade().equals("F3")) {completed+="- "+getCourseList().get(1).getName()+getCourseList().get(1).getCode()+"\n";
		}
		return "----------------------------------------\n"
				+ "Student ID: "+getId()+"\n"
				+ "Name: "+getName()+"\n"
				+ "Email: "+getEmail()+"\n"
				+ "Major: "+getDepartment()+"\n"
				+ "Status: Active\n"
				+ "\n"
				+ "\n"
				+ "Enrolled Courses:\n"
				+enrolled
				+ "\n"
				+ "Completed Courses:\n"
				+completed
				+ "\n"
				+ "GPA: "+gpa+"\n"
				+ "----------------------------------------\n";
		
		
		
	}
	private String grade;
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Students(String type,String id,String name, String email, String department) {
		super(type,id,name,email,department);
		
	}
	public String toString() {
		return "Student ID: "+getId()+"\n"
				+ "Name: "+getName()+"\n"
				+ "Email: "+getEmail()+"\n"
				+ "Major: "+getDepartment()+"\n"
				+ "Status: Active\n";
	}

	
	

}
