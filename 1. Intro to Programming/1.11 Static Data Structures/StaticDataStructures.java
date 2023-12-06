package static_data_structures;

public class StaticDataStructures {
	static final int MAXELEM = 50;

	static final int ROWS = 10;
	static final int COLUMNS = 20;

	public static void main(String[] args) {

		//Array practice
		/*
		int total = 0;
		int n;
		int maxValue = 0;
		int maxValuePos= 0;

		do {
			System.out.println("Enter number of elements of an array(1 - 50):");
			n = TextIO.getInt();
		} while (n < 0 || n > MAXELEM);

		int[] intArr = new int[n];

		for (int i = 0; i < n; i++) {
			System.out.println("Enter " + (i + 1) + ". number of the array");
			intArr[i] = TextIO.getlnInt();
		}

		for (int i = 0; i < n; i++) {
			total += intArr[i];

			if (intArr[i] > maxValue) {
				maxValue = intArr[i];
				maxValuePos = i + 1;
			}
		}

		System.out.println("Sum of array elements:");
	    System.out.println(total);

	    System.out.println("Max elements is: ");
	    System.out.println(maxValue + " at " + maxValuePos + ". position");
		 */

		//Matrix practice
		int rowNum = 1, colNum = 1, i, j;
		float average = 0;
		int[][] RealNumbersMatrix = new int[ROWS][COLUMNS];

		System.out.println("Enter the number of rows");
		rowNum = TextIO.getlnInt();

		System.out.println("Enter the number of columns");
		colNum = TextIO.getlnInt();

		for (i = 0; i < rowNum; i++) {
			for (j = 0; j < colNum; j++) {
				System.out.println("Enter the matrix element at the [" + (i + 1) + "][" + (j + 1) + "] position");
				RealNumbersMatrix[i][j] = TextIO.getlnInt(); 
			}
		}

		for (i = 0; i < rowNum; i++) {
			for (j = 0; j < colNum; j++) {
				average += RealNumbersMatrix[i][j];
			}
		}
		
		average /= (rowNum * colNum);
		System.out.println("Average value of matrix elements is: " + average);
	}
}	
