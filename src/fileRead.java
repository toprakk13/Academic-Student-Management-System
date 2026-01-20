
import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.time.LocalDate;
	import java.time.format.DateTimeFormatter;
	import java.time.temporal.ChronoUnit;
	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;
public class fileRead {
	

	
		
		private List<Persons> personList = new ArrayList<>();
		public List<Persons> getPersonList() {
			return personList;
		}
		public void setPersonList(List<Persons> personList) {
			this.personList = personList;
		}
		public List<AcademicEntity> getEntityList() {
			return entityList;
		}
		public void setEntityList(List<AcademicEntity> entityList) {
			this.entityList = entityList;
		}
		public List<Grades> getGradeList() {
			return gradeList;
		}
		public void setGradeList(List<Grades> gradeList) {
			this.gradeList = gradeList;
		}
		private List<AcademicEntity> entityList = new ArrayList<>();
		private List<Grades> gradeList = new ArrayList<>();
		private List<Grades> numericGradeList = new ArrayList<>();
	
		
		
	    
	    public void loadPersonsFromFile(String fileName) {
	        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] userData = line.split(",");
	                String type = userData[0];
	                String id = userData[1];
	                String name = userData[2];
	                String email = userData[3];
	                String department=userData[4]; 
	                switch(type){
	                	case"S":Persons student = new Students(type, id, name, email,department);
	                			personList.add(student);
	                			break;//object from users
	                
	                	case"F":Persons academicMemberr = new academicMember(type, id, name, email,department);	
	                			personList.add(academicMemberr);
	                			break;
	                }
	                //BURAYA ADDCOURSES GELCEK
	               
	                
	            }
	        } catch (IOException e) {
	            System.out.println("Dosya okuma hatası: " + e.getMessage());
	        }
	    }
	    
	    public void loadCoursesFromFile(String fileName) {
	        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] itemData = line.split(",");
	                String code = itemData[0];
	                String name = itemData[1];
	                String description = itemData[2];
	                String credit=itemData[3];
	                String semester=itemData[4];
	                String programCode=itemData[5];
	                

	                AcademicEntity course = new Course(code, name, description, credit,semester,programCode);//object from items
	                for(Persons i:personList) {
	    				
	    					
	    					if(i.getCourseList().contains((Course)course)){
	    						if(i instanceof academicMember) {
	    							((Course) course).setInstructorName(i.getName());
	    						}
	    						else {
	    							((Course) course).addEnrolledList(i);
	    						}
	    					}
	    				
	    					
	    				}

	                

	                entityList.add(course);
	            }
	        } catch (IOException e) {
	            System.out.println("Dosya okuma hatası: " + e.getMessage());
	        }
	    }
	    public void loadDepartmentsFromFile(String fileName) {
	        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] itemData = line.split(",");
	                String code = itemData[0];
	                String name = itemData[1];
	                String description = itemData[2];
	                String headId=itemData[3];
	               
	                

	                AcademicEntity department = new Department(code, name, description, headId);//object from items
	                Department i=(Department)department;
	                

	                
	                for(Persons a:personList) {
	                	if(a instanceof academicMember) {
	                		if(a.getId().equals(headId)) {
	                			academicMember a1=(academicMember)a;
	                			Department department1=(Department)department;
	                			department1.setHead(a1);
	                		}
	                	}
	                }
	                entityList.add(department);
	                i.addProgram();
	            }
	        } catch (IOException e) {
	            System.out.println("Dosya okuma hatası: " + e.getMessage());
	        }
	    }
	    public void loadProgramFromFile(String fileName) {
	        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] itemData = line.split(",");
	                String code = itemData[0];
	                String name = itemData[1];
	                String description = itemData[2];
	                String department=itemData[3];
	                String degreeLevel=itemData[4];
	                String totalCreditStr=itemData[5];
	                int totalCredit=Integer.parseInt(totalCreditStr);

	                AcademicEntity program = new Program(code, name, description, department,degreeLevel,totalCredit);//object from items
	                Program i=(Program)program;
	                for(AcademicEntity f :entityList) {
	                	if(f instanceof Course) {
	                		Course f1=(Course)f;
	                		if(f1.getProgramCode().equals(code)) {
	                			i.addCourse(f1);
	                		}
	                	}
	                }

	                

	                entityList.add(program);
	                
	            }
	        } catch (IOException e) {
	            System.out.println("Dosya okuma hatası: " + e.getMessage());
	        }
	    }
	    public void loadGradesFromFile(String fileName) {
	        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] itemData = line.split(",");
	                String gradee = itemData[0];
	                String studentId = itemData[1];
	                String courseCode = itemData[2];
	                
	                

	               Grades grade = new Grades(gradee, studentId, courseCode);
	               Grades gradeNumeric;//object from items
	               switch (gradee) {
	               case "A1": gradeNumeric= new Grades(4.0, studentId, courseCode);
	            	   numericGradeList.add(gradeNumeric);
	               break;
	               case "A2": gradeNumeric= new Grades(3.5, studentId, courseCode);
	            	   numericGradeList.add(gradeNumeric);
	               break;
	               case "B1":gradeNumeric= new Grades(3.0, studentId, courseCode); 
	            	   numericGradeList.add(gradeNumeric);
	               break;
	               case "B2":gradeNumeric= new Grades(2.5, studentId, courseCode); 
	            	   numericGradeList.add(gradeNumeric);
	               break;
	               case "C1":gradeNumeric= new Grades(2.0, studentId, courseCode); 
	            	   numericGradeList.add(gradeNumeric);
	               break;
	               case "C2":gradeNumeric= new Grades(1.5, studentId, courseCode); 
	            	   numericGradeList.add(gradeNumeric);
	               break;
	               case "D1":gradeNumeric= new Grades(1.0, studentId, courseCode);  
	            	   numericGradeList.add(gradeNumeric);
	               break;
	               case "D2":gradeNumeric= new Grades(0.5, studentId, courseCode);  
	            	   numericGradeList.add(gradeNumeric);
	               break;
	               case "F3": gradeNumeric= new Grades(0.0, studentId, courseCode);
	            	   numericGradeList.add(gradeNumeric);
	               break;
	                   // bilinmeyen notlar için
	           }

	                

	                gradeList.add(grade);
	            }
	        } catch (IOException e) {
	            System.out.println("Dosya okuma hatası: " + e.getMessage());
	        }
	    }
	    
	    
	    public List<Grades> getNumericGradeList() {
			return numericGradeList;
		}
		public void setNumericGradeList(List<Grades> numericGradeList) {
			this.numericGradeList = numericGradeList;
		}
		
	    public void processAssignmentsFromFile(String inputFile) {
	        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	             ) {  
	        	
	            String line;
	           
	            while ((line = reader.readLine()) != null) {
	                String[] commandData = line.split(",");
	                
	                String types = commandData[0];
	                String id=commandData[1];
	                String code=commandData[2];
	                
		            for(Persons k: personList) {
		            	if(k.getId().equals(id)) {
		            		for(AcademicEntity y:entityList) {
		    					if(y instanceof Course) {
		    					Course a=(Course)y;
		    					if(code.equals(a.getCode())) {
		    						k.addCourses(a);
		    						}
		    					}
		    				}
		            		}
		            	
		            }
	                
	                
	                
	                
	                
	                
	                
	               
	                
	                
	                
	                

	                
	               
	                

	                
	               
	                

	                
	                
	            }
	        } catch (IOException e) {
	            System.out.println("Komut dosyası okuma hatası: " + e.getMessage());
	        }
	    }
	    
	    

	    
	}



