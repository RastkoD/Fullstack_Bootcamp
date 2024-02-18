package students;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		Listing studentsList = new Listing();
        ArrayList<Student> students = (ArrayList<Student>) studentsList.readDataFromFile("spisakPolaznika.txt");

        System.out.println("-----------------------------");
        System.out.println("Original List:\n");
        studentsList.displayStudents(students);
        System.out.println("-----------------------------");
        
        students.sort(new Compare());

        System.out.println("-----------------------------");
        System.out.println("Sorted List:\n");
        studentsList.displayStudents(students);
        System.out.println("-----------------------------");

        studentsList.writeToOutputFile(students, "uredjeniSpisak.txt");
	}
}

