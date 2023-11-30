package highway;

public class Highway_RastkoD {
	static final int TOLLS = 10;
	static final int DAYS = 30;

	static double[][] highwayTolls = new double[TOLLS][DAYS];

	/*
	DEMO

    static final int TOLLS = 4;
    static final int DAYS = 5;
    static double[][] highwayTolls= new double[][] {{1, 2, 3, 4, 5}, //15
		 											{2, 4, 6, 8, 10}, //30
		 											{3, 6, 9, 12, 15}, //45
		 											{4, 8, 12, 16, 20}}; //60
		 										//  10  20 30 40 50 
	 */

	public static void main(String[] args) {

		int choice;

		do {
			System.out.println("\n----- Menu -----");
			System.out.println("1. Enter the number of cars for the chosen day and tollbooth");
			System.out.println("2. Display the total number of cars that have passed through the selected tollbooth");
			System.out.println("3. Display all the days on which the total number of cars that have passed exceeds specified number");
			System.out.println("4. Display the total number of cars that passed through the tollbooths this month");
			System.out.println("5. Display the full info table");
			System.out.println("6. Exit");

			choice = TextIO.getInt();

			if (choice == 1) {
				enterNumOfCars();
			} else if (choice == 2) {
				displayCarsForToll();
			} else if (choice == 3) {
				displayDays();
			} else if (choice == 4) {
				totalCarsThisMonth();
			} else if (choice == 5) {
				printMatrix(highwayTolls, "TOLLS", "DAYS");
			} else if (choice == 6) {
				System.out.println("----------------------------------");
				System.out.println("Thank you for using the pogram");
				System.out.println("----------------------------------");
			} else {
				System.out.println("----------------------------------");
				System.out.println("Not an option. Please try again.");
				System.out.println("----------------------------------");
			}

		} while (choice != 6);

	}

	static int getInt(String msg, String errMsg, int lowest, int highest){
		int val = 0;
		do {
			System.out.println(msg);
			val = TextIO.getlnInt();
			if (val < lowest || val > highest) {
				System.out.println(errMsg);
			}
		}while (val < lowest || val > highest);

		return val;
	}


	static void enterNumOfCars() {
		int toll, day;
		char again;

		do {

			toll = getInt("Choose a tollbooth", 
					"Must be between 1-" + TOLLS, 
					1, TOLLS);
			day = getInt("Choose a day", 
					"Must be between 1-" + DAYS, 
					1, DAYS);
			System.out.println("Number of cars through toll number " + toll + " on the " + day + ". day is:");
			highwayTolls[toll-1][day-1] = TextIO.getlnDouble();

			System.out.println("To enter another number of cars enter 'y' or 'n' to go back to the menu");
			again = TextIO.getlnChar();
		}while(again == 'y' || again == 'Y');	

	}

	static void displayCarsForToll() {
		int toll;
		char again;

		do {
			int totalForToll = 0;
			toll = getInt("Choose a tollbooth", 
					"Must be between 1-" + TOLLS, 
					1, TOLLS);

			System.out.println("--------------------------------------------------------------------");
			System.out.println("Total number of cars that passed through toll number " + toll + " this month is:");

			for (int i = 0; i < TOLLS; i++) {
				for (int j = 0; j < DAYS; j++) {
					if (toll == (i + 1)) {
						totalForToll += highwayTolls[i][j];
					}
				}					
			}

			System.out.println(totalForToll);
			System.out.println("--------------------------------------------------------------------");

			System.out.println("To display total number of cars for another toll enter 'y' or 'n' to go back to the menu");
			again = TextIO.getlnChar();
		}while(again == 'y' || again == 'Y');	
	};

	static void displayDays() {
		int specNumber;
		char again;

		do {
			int totalForDay;
			boolean daysFound = false;
			System.out.println("Enter the number");
			specNumber = TextIO.getInt();

			System.out.println("--------------------------------------------------------------------");
			System.out.println("Day(s) on which more than " + specNumber + " cars went through tollbooths:");

			for (int i = 0; i < DAYS; i++) {
				totalForDay = 0;
				for (int j = 0; j < TOLLS; j++) {
					totalForDay += highwayTolls[j][i];
				}
				if (totalForDay > specNumber) {
					System.out.println("Day " + (i + 1) + ": " + totalForDay + " cars");
					daysFound = true;
				} 
			}		

			if (!daysFound) {
				System.out.println("ZERO days found with more than " + specNumber + " cars.");
				System.out.println("--------------------------------------------------------------------");
			}

			System.out.println("--------------------------------------------------------------------");

			System.out.println("To specify another number enter 'y' or 'n' to go back to the menu");
			again = TextIO.getlnChar();
		}while(again == 'y' || again == 'Y');	
	};

	static void totalCarsThisMonth() {
		int totalCarsThisMonth = 0;

		for (int i = 0; i < TOLLS; i++) {
			for (int j = 0; j < DAYS; j++) {
				totalCarsThisMonth += highwayTolls[i][j];
			}					
		}
		System.out.println("------------------------------------------------------------------------------------------------------");
		System.out.println("Total number of cars that passed through " + TOLLS + " tollbooths in the past " + DAYS + " days is: " + totalCarsThisMonth);
		System.out.println("------------------------------------------------------------------------------------------------------");
	};


	static void printMatrix(double[][] ht, String row, String column) {
		int i,j;

		int rowLength = row.length();

		printEmptyBoxes(rowLength * DAYS);
		System.out.println(column);

		System.out.println(row);

		for (i = 0; i < TOLLS; i++) {
			printEmptyBoxes(rowLength + 2);
			for (j = 0; j < DAYS; j++)
				System.out.printf("%10.2f", ht[i][j]);
			System.out.println();
		}
	}

	static void printEmptyBoxes(int numOfEmptyBoxes) {
		for (int i = 0; i < numOfEmptyBoxes; i++)
			System.out.print(" ");
	}

}