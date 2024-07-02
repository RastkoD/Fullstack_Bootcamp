package facultyEmployees;

public class Main {

	public static void main(String[] args) {	
		FacultyEmployee professor, assistant, staff;
		
		professor = new Professor("Samwise", "Gamgee", 35, 0, "Professor", 10);
		assistant = new Assistant("Peregrin", "Took", 28, 0, "Gandalf", 3);
		staff =  new NonTeachingStaff("Aragorn", "Elessar", 45, 0, "Administrator", 15); 
		
		professor.introduceYourself();
		professor.calcSalary();
		professor.printSalary();
		System.out.println();
		assistant.introduceYourself();
		assistant.calcSalary();
		assistant.printSalary();
		System.out.println();
		staff.introduceYourself();
		staff.calcSalary();
		staff.printSalary();	
	}

}
