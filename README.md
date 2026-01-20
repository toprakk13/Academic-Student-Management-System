# Academic Student Management System 🎓📊

This project is a comprehensive **Java-based Academic Student Management System** that simulates core university academic processes. It models the relationships between departments, programs, courses, students, and academic staff using **Object-Oriented Programming (OOP)** principles.  
The system reads structured data from text files, constructs the academic hierarchy, and performs grading, GPA calculation, and reporting operations.

---

## Features

### Hierarchical Academic Modeling
- **AcademicEntity (Abstract Class):**  
  Base class for all academic units such as `Department`, `Program`, and `Course`.
- **Relational Structure:**  
  - A **Department** can contain multiple **Programs**
  - A **Program** can contain multiple **Courses**

### Data Reading & Processing
- Input data is read from structured text files using the `fileRead` utility class.
- Supported files include:
  - `persons.txt`
  - `courses.txt`
  - `grades.txt`
  - `departments.txt`
  - `programs.txt`

### Grade & GPA Calculation
- Student grades are stored in the `Grades` class.
- GPA is calculated by **weighting course grades with course credits**.

### Reporting
- Classes implementing the `StudentManagementSystem` interface generate standardized academic reports.
- Supports student-based and course-based summaries.

---

## Project Structure
src/
├── Main.java
├── AcademicEntity.java
├── Department.java
├── Program.java
├── Course.java
├── Persons.java
├── Students.java
├── AcademicMember.java
├── Grades.java
├── fileRead.java
### File Descriptions
- **Main.java**  
  Entry point of the application. Loads data and controls program flow.
- **AcademicEntity.java**  
  Abstract base class containing common attributes (ID, name).
- **Department / Program / Course**  
  Represent academic units and their hierarchical relationships.
- **Students / AcademicMember**  
  User roles derived from the `Persons` class.
- **Grades.java**  
  Stores exam and assignment grades.
- **fileRead.java**  
  Handles all file reading and parsing operations.

---

## Input File Formats

The system processes the following input files:

- **departments.txt**  
  Department definitions.
- **programs.txt**  
  Program definitions and their associated departments.
- **courses.txt**  
  Course code, credit value, and associated program.
- **persons.txt**  
  Student and academic staff identity information.
- **grades.txt**  
  Student ID-based course grades.

---

## Compilation & Execution

To compile and run the project:

```bash
javac src/*.java
java src.Main
