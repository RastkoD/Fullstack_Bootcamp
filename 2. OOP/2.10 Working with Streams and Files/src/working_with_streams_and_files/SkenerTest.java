package working_with_streams_and_files;
import java.util.Scanner;

public class SkenerTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your SSN: ");
		String SSN = sc.next();
		System.out.println("Enter your name: ");
		String name = sc.next();
		System.out.println("Enter your salary: ");
		double salary = sc.nextDouble();
		System.out.println("SSN: " + SSN + " Name: " + name + " Salary: " + salary);

		sc.close();
	}

}
