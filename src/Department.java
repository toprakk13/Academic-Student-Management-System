import java.util.List;

public class Department extends AcademicEntity {
	private Persons head; 
	private List<Program> programs;
	private fileRead read=new fileRead();
	public Department(String code, String name, String description,String headId) {
		super(code, name, description);
		// TODO Auto-generated constructor stub
		
		
            
	}
	public void addProgram() {
		for(AcademicEntity i:read.getEntityList()) {
        	if(i instanceof Program) {
        	Program a=(Program)i;
        	
        		programs.add(a);
        		
        		
        	}
        }
    }

    public List<Program> getPrograms() {
        return programs;
    }
	public Persons getHead() {
		return head;
	}
	public void setHead(academicMember head) {
		this.head = head;
	}
	public String toString() {
		return "Department Code: "+getCode()+"\n"
				+ "Name: "+getName()+"\n"
				+ "Head: "+head.getName()+"\n";
	}
	public String reports(){
		return null;
		
	}
	
	

}
