package subroutines_subprograms;

public class SimpleCalc {

	public static void main(String[] args) {
		int choice = 0;
		double x = 0, y = 0, result = 0;
		boolean exit = false;
		String operation = "";

		do {
			System.out.println("Choose an operation");
			System.out.println("1. Sum");
			System.out.println("2. Subtract");
			System.out.println("3. Multiply");
			System.out.println("4. Divide");
			System.out.println("5. Exit");
			choice = TextIO.getInt();

			System.out.println("Enter the first number");
			x = TextIO.getInt();

			System.out.println("Enter the second number");
			y = TextIO.getInt();

			if (choice == 1) {
				result = sum(x, y);
				operation = "+";
			} else if (choice == 2) {
				result = subtraction(x, y);
				operation = "-";
			} else if (choice == 3) {
				result = multiply(x, y);
				operation = "*";
			} else if (choice == 4) {
				result = divide(x, y);
				operation = "/";
			} else if (choice == 5) {
				exit = true;
			} 

			showResult(x, y, operation, result);

		} while (!exit);

	}

	static double sum(double x, double y) {
		return x + y;
	}

	static double subtraction(double x, double y) {
		return x - y;
	}

	static double multiply(double x, double y) {
		return x * y;
	}

	static double divide(double x, double y) {
		if (y != 0) {
			return x / y;
		} else {
			System.out.println("Division by zero is not allowed");
			return Double.NaN; 
		}
	}

	static void showResult(double x, double y, String operation, double result) {
		System.out.println("\n---Result---");
		System.out.printf("\n%2.2f %s %2.2f = %2.2f\n", x, operation, y, result);
		System.out.println("--------------------------------------");
	}

}
