package subroutines_subprograms;

public class Persons {
	static final int MAXPERSONS = 40;

	public static void main(String[] args) {
		int choice = 0, numOfPersons = 0;
		String sortedBy = "";
		String[][] personsArr = new String[MAXPERSONS][4];

		System.out.println("Persons sorting program");
		numOfPersons = enterNumOfPersons();
		enterPersons(personsArr, numOfPersons);

		System.out.println("Sort by(enter the number):");
		System.out.println("1. Name");
		System.out.println("2. Surname");
		System.out.println("3. SSN");
		System.out.println("4. City");
		choice = TextIO.getInt();

		do {
			if (choice == 1) {
				sortInput(personsArr, numOfPersons, choice);
				sortedBy = "name";
			} else if (choice == 2) {
				sortInput(personsArr, numOfPersons, choice);
				sortedBy = "surname";
			} else if (choice == 3) {
				sortInput(personsArr, numOfPersons, choice);
				sortedBy = "SSN";
			} else if (choice == 4) {
				sortInput(personsArr, numOfPersons, choice);
				sortedBy = "city";
			} else {
				System.out.println("Choose one from 1-4");
			}
		} while (choice <= 0 || choice > 4);

		printPersons(personsArr, numOfPersons, sortedBy);
	}

	static int enterNumOfPersons() {
		int numInput = 0;
		do {
			System.out.println("Enter the number of persons to be sorted(1 - 40)");
			numInput = TextIO.getInt();

		} while (numInput <= 0 || numInput > 40);

		return numInput;

	}

	static void enterPersons(String[][] personsArr, int numOfPersons) {
		int i;
		for (i = 0; i < numOfPersons; i++) {
			System.out.println((i + 1) + ". Person's Info");
			System.out.println("Name:");
			personsArr[i][0] = TextIO.getlnWord();
			System.out.println("Surname:");
			personsArr[i][1] = TextIO.getlnWord();
			System.out.println("SSN:");
			personsArr[i][2] = TextIO.getlnWord();
			System.out.println("City:");
			personsArr[i][3] = TextIO.getlnWord();
			System.out.println("-----------------------------------");
		}
	}

	static void sortInput(String[][] personsArr, int numOfPersons, int choice) {
		for (int i = 0; i < numOfPersons - 1; i++) {
			for (int j = i + 1; j < numOfPersons; j++) {
				if (personsArr[i][choice - 1].compareTo(personsArr[j][choice - 1]) > 0) {
					sortPersons(personsArr, i, j);
				}
			}
		}
	}

	static void sortPersons(String[][] personsArr, int who, int whom) {
		String tempPerson;
		for (int i = 0; i < 4; i++) {
			tempPerson = personsArr[who][i];
			personsArr[who][i] = personsArr[whom][i];
			personsArr[whom][i] = tempPerson;
		}
	}

	static void printPersons(String[][] personsArr, int numOfPersons, String sortedBy) {
		for (int i = 0; i < numOfPersons; i++) {
			System.out.println("Persons sorted by " + sortedBy);
			System.out.println((i + 1) + ". Name: " + personsArr[i][0] + ", Surname: " + personsArr[i][1] + " (ssn: " + personsArr[i][2] + "), from: " + personsArr[i][3] + ".");
		}
	}
}
