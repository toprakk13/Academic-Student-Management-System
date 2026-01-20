import java.util.ArrayList;
import java.util.List;

public class Course extends AcademicEntity implements StudentManagementSystem {
	private String credit;
	private fileRead read=new fileRead();
	private String instructorName;
	public String getInstructorName() {
		return instructorName;
	}


	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}


	private int a1=0,a2=0,b1=0,b2=0,c1=0,c2=0,d1=0,d2=0,F3=0;
	private List<Persons> enrolledList = new ArrayList<>();
	
	public List<Persons> getEnrolledList() {
		return enrolledList;
	}


	public void addEnrolledList(Persons enrolled) {
		enrolledList.add(enrolled);
	}


	public String getCredit() {
		return credit;
	}


	public void setCredit(String credit) {
		this.credit = credit;
	}


	public String getSemester() {
		return semester;
	}


	public void setSemester(String semester) {
		this.semester = semester;
	}


	public String getProgramCode() {
		return programCode;
	}


	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}


	private String semester;
	private String programCode;
	private Grades grade;
	
	
	
	public Grades getGrade() {
		return grade;
	}


	public void setGrade(Grades grade) {
		this.grade = grade;
	}
	


	public Course(String code, String name, String description, String credit, String semester, String programCode
			) {
		super(code, name, description);
		this.credit = credit;
		this.semester = semester;
		this.programCode = programCode;
		
	}
	public String toString() {
		return "Course Code: "+getCode()+"\n"
				+ "Name: "+getName()+"\n"
				+ "Department: "+getDescription()+"\n"
				+ "Credits: "+credit+"\n"
				+ "Semester: "+semester+"\n";
	}


	@Override
	public String reports() {
		double sum=0;
		int count=0;
		// TODO Auto-generated method stub
		for(Grades i: read.getNumericGradeList()) {
			if(i.getCourseCode().equals(getCode())){
				sum=+i.getGradeNumeric();
				count++;
				if(i.getGradeNumeric()==4.0) {
					a1++;
				}
				if(i.getGradeNumeric()==3.5) {
					a2++;
				}
				if(i.getGradeNumeric()==3.0) {
					b1++;
				}
				if(i.getGradeNumeric()==2.5) {
					b2++;
				}
				if(i.getGradeNumeric()==2.0) {
					c1++;
				}
				if(i.getGradeNumeric()==1.5) {
					c2++;
				}
				if(i.getGradeNumeric()==1.0) {
					d1++;
				}
				if(i.getGradeNumeric()==0.5) {
					d2++;
				}
				if(i.getGradeNumeric()==0.0) {
					F3++;
				}
				
			}
		}
		double average=sum/count;
		
		
		
		String students="";	
		for(Persons y:enrolledList) {
			students+="- "+y.getName()+"(ID: "+y.getId()+")"+"\n";
		}
		String dist="";
		if (a1 > 0) dist += "A1: " + a1 + "\n";
	    if (a2 > 0) dist += "A2: " + a2 + "\n";
	    if (b1 > 0) dist += "B1: " + b1 + "\n";
	    if (b2 > 0) dist += "B2: " + b2 + "\n";
	    if (c1 > 0) dist += "C1: " + c1 + "\n";
	    if (c2 > 0) dist += "C2: " + c2 + "\n";
	    if (d1 > 0) dist += "D1: " + d1 + "\n";
	    if (d2 > 0) dist += "D2: " + d2 + "\n";
	    if (F3 > 0) dist += "F3: " + F3 + "\n";
	    if(dist==null) {dist=" ";}
		return 
				 "Course Code: "+getCode()+"\n"
				+ "Name: "+getName()+"\n"
				+ "Department: "+getDescription()+"\n"
				+ "Credits: "+credit+"\n"
				+ "Semester: "+semester+"\n"
				+ "\n"
				+ "Instructor: "+instructorName+"\n"
				+ "\n"
				+ "Enrolled Students:\n"
				+
				students
				+ "\n"
				+ "Grade Distribution: "+dist+"\n"
				+ "\n"
				+ "Average Grade: "+average+"\n"
				+ "\n"
				+ "----------------------------------------\n\n";
		
		
	}

}
