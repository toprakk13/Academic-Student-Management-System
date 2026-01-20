import java.util.ArrayList;
import java.util.List;

public abstract class Persons implements StudentManagementSystem {
	private boolean head;
	public boolean isHead() {
		return head;
	}
	public void setHead(boolean head) {
		this.head = head;
	}
	private String id;
	private String name;  
	private String email; 
	private String department;
	private String type;
	private fileRead read=new fileRead();
	private List<Course> courseList = new ArrayList<>();
	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Persons(String type,String id,String name, String email, String department) {
		this.type=type;
		this.id=id;
		this.name=name; 
		this.email=email; 
		this.department=department;
		
	}
	public void addCourses(Course course) {
		courseList.add(course);
	}
	
		
		
		
	
	public abstract String toString();
		
		
	

}

