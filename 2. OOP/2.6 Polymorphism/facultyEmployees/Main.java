package facultyEmployees;

public class Main {

	public static void main(String[] args) {
		Professor teacher = new Professor("Samwise", "Gamgee", 35, 0, "Professor", 10);
		Assistant assistant = new Assistant("Peregrin", "Took", 28, 0, "Gandalf", 3);
		NonTeachingStaff staff = new NonTeachingStaff("Aragorn", "Elessar", 45, 0, "Administrator", 15);
		
		teacher.introduceYourself();
		teacher.calcSalary();
		teacher.printSalary();
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
