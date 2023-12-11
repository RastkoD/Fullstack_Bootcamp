package subroutines_subprograms;

public class SumOfN {
	public static final int MAXELEMS = 30;

	public static void main(String[] args) {
		int choice = 0, n;
		int[] array = new int[MAXELEMS];
		double result = 0; 	
		boolean exit = false;
		String operation = "";

		do {
			System.out.println("Choose an operation");
			System.out.println("1. Array Sum");
			System.out.println("2. Array Average");
			System.out.println("3. Min Array Element");
			System.out.println("4. Max Array Element");
			System.out.println("5. Exit");
			choice = TextIO.getInt();

			n = getNumOfElems("Enter the number of array elments", "Number of array elements must be between 1 and 30!", 1, MAXELEMS);

			arrElements(array, n);

			if (choice == 1) {
				result = calcSum(array, n);
				operation = "Sum of array elements is: ";
			} else if (choice == 2) {
				result = calcAverage(array, n);
				operation = "Average of array elements is: ";
			} else if (choice == 3) {
				result = findMin(array, n);
				operation = "Minimum Array element is: ";
			} else if (choice == 4) {
				result = findMax(array, n);
				operation = "Maximum Array element is: ";
			} else if (choice == 5) {
				exit = true;
			} 

			showResult(operation, result);

		} while (!exit);

	}

	static int getNumOfElems(String inputMsg, String errMsg, int minElems, int maxElems) {
		int num = 0;

		do {
			System.out.println(inputMsg);
			num = TextIO.getInt();

			if(num < minElems || num > maxElems) {
				System.out.println(errMsg);
			}

		} while(num < minElems || num > maxElems);

		return num;
	}

	static void arrElements(int[] array, int n) {
		for (int i = 0; i < n; i++) {
			System.out.println("Enter the " + (i + 1) + ". array element");
			array[i] = TextIO.getInt();
		}

	}

	static double calcSum(int[] array, int n) {
		int s = 0;
		for (int i = 0; i < n; i++) {
			s += array[i];
		}

		return s;
	}

	static double calcAverage(int[] array, int n) {
		double sum = 0;
		double count = 0;

		for (int i = 0; i < n; i++) {
			sum += array[i];
			count++;
		}

		return sum / count;
	}

	static double findMin(int[] array, int n) {
		int min = array[0];

		for (int i = 0; i < n; i++) {
			if (min > array[i]) {
				min = array[i];
			}
		}

		return min;
	}

	static double findMax(int[] array, int n) {
		int max = array[0];

		for (int i = 0; i < n; i++) {
			if (max < array[i]) {
				max = array[i];
			}
		}

		return max;
	}

	static void showResult(String operation, double result) {
		System.out.println("\n---Result---");
		System.out.println(operation + result);
		System.out.println("--------------------------------------");
	}

}
