package banks;

public class Banks {
	static double[][] incomes = new double[10][12];

	public static void main(String[] args) {

		int choice;

		do {
			System.out.println("\n----- Choose -----");
			System.out.println("1. Enter income");
			System.out.println("2. Edit income");
			System.out.println("3. Display monthly income for the branch");
			System.out.println("4. Display income for individual branches for the month");
			System.out.println("5. Display the month with the highest income");
			System.out.println("6. Display total annual income");
			System.out.println("7. Display average income per branch");
			System.out.println("8. Exit");
			choice = TextIO.getInt();

			if (choice == 1) {
				enterIncome();
			} else if (choice == 2) {
				editIncome();
			} else if (choice == 3) {
				monthlyIncomeForBranch();
			} else if (choice == 4) {
				monthlyIncomeForAllBranches();
			} else if (choice == 5) {
				highestIncomeMonth();
			} else if (choice == 6) {
				anualIncome();
			} else if (choice == 7) {
				averageIncomePerBranch();
			} else if (choice == 8) {
				System.out.println("----------------------------------");
				System.out.println("Thank you for using the pogram");
				System.out.println("----------------------------------");
			} else {
				System.out.println("----------------------------------");
				System.out.println("Not an option. Please try again.");
				System.out.println("----------------------------------");
			}

		} while (choice != 8);
	}

	static void enterIncome() {
		System.out.println("Enter the branch number (1-10): ");
		int branch = TextIO.getInt();
		System.out.println("Enter the month number (1-12): ");
		int month = TextIO.getInt();
		System.out.println("Enter the income: ");
		double income = TextIO.getDouble();

		incomes[branch - 1][month - 1] = income;

		System.out.println("----------------------------------");
		System.out.println("Success!");
		System.out.println("----------------------------------");
	}

	static void editIncome() {
		System.out.println("Enter the branch number (1-10): ");
		int branch = TextIO.getInt();
		System.out.println("Enter the month number (1-12): ");
		int month = TextIO.getInt();
		System.out.println("Enter new income for branch " + branch + " for " + month + ". month");
		double newIncome = TextIO.getDouble();

		incomes[branch - 1][month - 1] = newIncome;

		System.out.println("----------------------------------");
		System.out.println("Success!");
		System.out.println("----------------------------------");
	}

	static void monthlyIncomeForBranch() {
		System.out.println("Enter the branch number (1-10): ");
		int branch = TextIO.getInt();

		System.out.println("----------------------------------");
		System.out.println("Monthly income for branch " + branch + ":");

		for (int i = 1; i <= 12; i++) {
			System.out.println("Month " + i + ": " + incomes[branch - 1][i - 1]);
		}
		System.out.println("----------------------------------");
	}

	static void monthlyIncomeForAllBranches() {
		System.out.println("Enter the month number (1-12): ");
		int month = TextIO.getInt();

		System.out.println("----------------------------------");
		System.out.println("Income for " + month + ". month is:");
		for (int i = 1; i <= 10; i++) {
			System.out.println("Branch " + i + ": " + incomes[i - 1][month - 1]);
		}
		System.out.println("----------------------------------");
	}

	static void highestIncomeMonth() {
		double maxIncome = incomes[0][0];
		int maxBranch = 1;
		int maxMonth = 1;

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 12; j++) {
				if (incomes[i][j] > maxIncome) {
					maxIncome = incomes[i][j];
					maxBranch = i + 1;
					maxMonth = j + 1;
				}
			}
		}

		System.out.println("----------------------------------");
		System.out.println("The highest income was achieved at the branch " + maxBranch + ", in the " + maxMonth
				+ ". month. Income was: " + maxIncome);
		System.out.println("----------------------------------");
	}

	static void anualIncome() {
		double anualIncome = 0;

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 12; j++) {
				anualIncome = anualIncome + incomes[i][j];
			}
		}

		System.out.println("----------------------------------");
		System.out.println("The total annual income of the bank is: " + anualIncome);
		System.out.println("----------------------------------");
	}

	static void averageIncomePerBranch() {
		// !!!
		for (int i = 0; i < 10; i++) {
			double avgIncome = 0;
			for (int j = 0; j < 12; j++) {
				avgIncome = avgIncome + incomes[i][j];
			}

			avgIncome = avgIncome / 12;

			System.out.println("----------------------------------");
			System.out.println("The average income for branch " + (i + 1) + " is: " + avgIncome);
			System.out.println("----------------------------------");
		}
	}

}
