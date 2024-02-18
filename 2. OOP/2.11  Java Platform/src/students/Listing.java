package students;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Listing {

	 ArrayList<Student> readDataFromFile(String file) {
		 ArrayList<Student> students = new ArrayList<>();
		try (BufferedReader buffReader = new BufferedReader(new FileReader(file))) {
			String line;
			
			while ((line = buffReader.readLine()) != null) {
				String[] studentInfo = line.split(" ");
				if (studentInfo.length == 3) {
					Student student = new Student(studentInfo[0], studentInfo[1], studentInfo[2]);
					students.add(student);
				}
			}
		} catch (IOException e) {
			e.getMessage();
		}
		return students;
	}
	
	void displayStudents(ArrayList<Student> students) {
		for (Student student : students) {
			System.out.println(student);
		}
	}
	
	void writeToOutputFile(ArrayList<Student> students, String file) {
		try (BufferedWriter buffWriter = new BufferedWriter(new FileWriter(file))) {
			for (Student student : students) {
				buffWriter.write(student.toString());
				buffWriter.newLine();
			}
		} catch (IOException e) {
			e.getMessage();
		}
	}
}
