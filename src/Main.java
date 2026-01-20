import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String personsFile=args[0];
		 String departmentsFile=args[1];
		 String programsFile=args[2];
		 String coursesFile=args[3];
		 String assignmentFile=args[4];
		 String gradesFile=args[5];
		 String outputFile=args[6];
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))){
			// TODO Auto-generated method stub
		
			
			fileRead read = new fileRead();
			read.loadPersonsFromFile(personsFile);
			read.loadCoursesFromFile(coursesFile);
			read.loadProgramFromFile(programsFile);
			read.loadDepartmentsFromFile(departmentsFile);
			read.processAssignmentsFromFile(assignmentFile);
			
			
			
			
			read.loadGradesFromFile(gradesFile);
			
			writer.write("Reading Person Information \n"
					+ "Reading Departments \n"
					+ "Reading Programs \n"
					+ "Reading Courses \n"
					+ "Reading Course Assignments \n"
					+ "Reading Grades \n"
					+ "----------------------------------------\n");//object from filereader
			writer.write("            Academic Members\n"
					+ "----------------------------------------\n");
			for(Persons i:read.getPersonList()) {
				if(i instanceof academicMember) {
					writer.write(i.toString()+"\n");
				}
			}
			writer.write("----------------------------------------\n"
					+ "\n"
					+ "----------------------------------------\n"
					+ "                STUDENTS\n"
					+"----------------------------------------\n");
			
			for(Persons i:read.getPersonList()) {
				if(i instanceof Students) {
					writer.write(i.toString()+"\n");
				}
			}
			writer.write("----------------------------------------\n"
					+ "\n"
					+ "---------------------------------------\n"
					+ "              DEPARTMENTS\n"
					+ "---------------------------------------\n");
			for(AcademicEntity i:read.getEntityList()) {
				if(i instanceof Department) {
					writer.write(i.toString()+"\n");
					}
			
			}
			writer.write("----------------------------------------\n"
					+ "\n"
					+ "--------------------------------------\n"
					+ "                PROGRAMS\n"
					+ "---------------------------------------}\n");
			for(AcademicEntity i:read.getEntityList()) {
				if(i instanceof Program) {
					writer.write(i.toString());
				}
				
			}
			writer.write("\n");
			writer.write("----------------------------------------\n"
					+ "\n"
					+ "---------------------------------------\n"
					+ "                COURSES\n"
					+ "---------------------------------------\n");
			for(AcademicEntity i:read.getEntityList()) {
				if(i instanceof Course) {
					writer.write(i.toString()+"\n");
				}
			}
			
			writer.write("----------------------------------------\n"
					+ "\n"
					+ "----------------------------------------\n"
					+ "             COURSE REPORTS\n"
					+ "----------------------------------------\n");
			for(AcademicEntity i:read.getEntityList()) {
				if(i instanceof Course) {
					writer.write(i.reports());
				}
			}
			for(Persons i:read.getPersonList()) {
				if(i instanceof Students) {
					writer.write(i.reports());
				}
			}

	}
		catch (IOException e) {
	        System.out.println("Komut dosyası okuma hatası: " + e.getMessage());
	    }

	}

}
