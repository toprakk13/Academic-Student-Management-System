import java.util.ArrayList;

public class academicMember extends Persons {
	public boolean head;
	
	public boolean isHead() {
		return head;
	}
	public void setHead(boolean head) {
		this.head = head;
	}
	public academicMember(String type,String id,String name, String email, String department) {
		super(type,id,name,email,department);
		
	}
	public  String toString() {
		return "Faculty ID: "+getId()+"\n"
				+ "Name: "+getName()+"\n"
				+ "Email: "+getEmail()+"\n"
				+ "Department: "+getDepartment()+"\n";
	}
	public String reports(){
		return null;
		
	}
}
