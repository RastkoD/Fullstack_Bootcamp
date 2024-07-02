package control_structures;

public class Homework {

	public static void main(String[] args) {
		
		/*
		// 1.Average students

		double studentsAvg;
		int students, courses, prompt;
		courses = 0;
		students = 0;
		//studentsAvg = students / courses;


		do {
            		System.out.print("Enter the number of students on the course (1 - 160), enter 0 when done");
            		prompt = TextIO.getlnInt();

            		if (prompt >= 1 && prompt <= 160) {
                		courses++;
                		students += prompt; 
		  
                		System.out.println(students);
                		System.out.println(courses);

            		} else if (prompt != 0) {
	                	System.out.println("PLEASE enter a number between 1 and 160");
            		}
        	} while (prompt != 0);

		// Math.round
		studentsAvg = students / courses;
		System.out.println("Average number of students is: " + studentsAvg);
		 */


		/*
		// 2. By 7
		int n; 
		int totalBySeven = 0;

		do {
			System.out.println("Enter a number between 6 and 142");
			n = TextIO.getInt();

			if (n != -1) {
                		if (n < 6 || n > 142) {
                    			System.out.println("Number must be between 6 and 142");
                		} else {
                    			if (n % 7 == 0) {
                        		totalBySeven++;
                    			}
                		}
            		}

		} while (n != -1);

		System.out.println("Number of input numbers that are divisible by 7 is: " + totalBySeven);
		 */		


		/*
		// 3. Min

		System.out.println("Enter a number ");
		int n = TextIO.getlnInt();

		if (n <= 0) {
			System.out.println("Bigger than 0");
		}

		int[] nums = new int[n];

		System.out.println("Enter " + n + " numbers (-10 to 100):");
		for (int i = 0; i < n; i++) {
		    int num = TextIO.getlnInt();

			if (num < -10 || num > 100) {
		    		System.out.println("Numbr must be between -10 and 100.");
			}

		     	nums[i] = num;
		 }

		int min = nums[0];

		for (int i = 1; i < n; i++) {
			if (nums[i] < min) {
				min = nums[i];
		    	}
		}

		System.out.println("Smallest numbers is " + min);
		 */


		/*
		// 4. Avg grade
		double average = 0;
		double total = 0;
        	double numberOfGrades = 0;
        	int grade;



        	do {
        		System.out.println("Enter grade between 5 and 10 (enter 0 to finish):");
           		grade = TextIO.getInt();

            		if (grade != 0) {
            			if (grade < 5 || grade > 10) {
                			System.out.println("Grade must be between 5 and 10:");
                		} else {
                			total += grade;
                			numberOfGrades++;
                		}
            		}

        	} while (grade != 0);

        	if (numberOfGrades > 0) {
        		average = total / numberOfGrades;
            		System.out.println("Average grade is: " + average);

       		} else {
            		System.out.println("No valid grades entered");
        	}
		 */

		/*
		// 5. % by 3 from n
		int q;
		double percent = 0;
		double count = 0;

		System.out.println("Enter the quantity of numbers: ");
		q = TextIO.getlnInt();

		for (int i = 1; i <= q; i++) {
			int n = 0;

			System.out.println("Enter the " + i + ". number(15-62)");
			n = TextIO.getlnInt();

			if (n < 15 || n > 62) {
				System.out.println("PLEASE enter the number between 15-62");
				i--;
			} else {

				if (n % 3 == 0) {
					count++;
				}
			}

		}

		percent = (count / q) * 100;
		System.out.print("Percent of enterend number divisible by 3 is: " + percent);
		 */
	}
}

