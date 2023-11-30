package waiter;

public class Waiter {
    static final int ALL_DRINKS = 10;
    static final int WORK_HOURS = 8;

    static double[][] incomeTotal = new double[ALL_DRINKS][WORK_HOURS];

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n----- Choose -----");
            System.out.println("1. Enter income");
            System.out.println("2. Edit income");
            System.out.println("3. Display income per hour for selected drink type");
            System.out.println("4. Display income per drink type for selected hourh");
            System.out.println("5. display the best-selling drink");
            System.out.println("6. Display total daily income");
            System.out.println("7. Display average income for each hour");
            System.out.println("8. Exit");
            choice = TextIO.getInt();

            if (choice == 1) {
                enterIncome();
            } else if (choice == 2) {
                editIncome();
            } else if (choice == 3) {
                incomePerHourForDrink();
            } else if (choice == 4) {
                incomePerDrinkForHour();
            } else if (choice == 5) {
                bestSellingDrink();
            } else if (choice == 6) {
                totalDailyIncome();
            } else if (choice == 7) {
                averageIncomePerHour();
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
        System.out.println("Enter work hour (1- " + WORK_HOURS + "): ");
        int hour = TextIO.getInt();

        if (hour < 1 || hour > WORK_HOURS) {
            System.out.println("Invalid entry. Try again.");
        }

        System.out.print("Enter drink type (1-" + ALL_DRINKS + "): ");
        int drink = TextIO.getInt();

        if (drink < 1 || drink > ALL_DRINKS) {
            System.out.println("Invalid entry. Try again.");
        }

        System.out.println("Enter income:");
        double income = TextIO.getDouble();

        incomeTotal[drink - 1][hour - 1] += income;
        System.out.println("----------------------------------");
        System.out.println("Success!");
        System.out.println("----------------------------------");
    }

    static void editIncome() {
        System.out.println("Enter work hour (1- " + WORK_HOURS + "): ");
        int hour = TextIO.getInt();

        if (hour < 1 || hour > WORK_HOURS) {
            System.out.println("Invalid entry. Try again.");
        }

        System.out.print("Enter drink type (1-" + ALL_DRINKS + "): ");
        int drink = TextIO.getInt();

        if (drink < 1 || drink > ALL_DRINKS) {
            System.out.println("Invalid entry. Try again.");
        }

        System.out.println("Enter updated income:");
        double income = TextIO.getDouble();

        incomeTotal[drink - 1][hour - 1] = income;
        System.out.println("----------------------------------");
        System.out.println("Success!");
        System.out.println("----------------------------------");
    }

    static void incomePerHourForDrink() {
        System.out.print("Enter drink type (1-" + ALL_DRINKS + "): ");
        int drink = TextIO.getInt();
        if (drink < 1 || drink > ALL_DRINKS) {
            System.out.println("Invalid entry. Try again.");
        }

        System.out.println("----------------------------------");
        System.out.println("Income per hour " + drink + ":");
        for (int i = 1; i <= WORK_HOURS; i++) {
            System.out.println("Hour " + i + ": " + incomeTotal[drink - 1][i - 1]);
        }
        System.out.println("----------------------------------");
    }

    static void incomePerDrinkForHour() {
        System.out.println("Enter work hour (1- " + WORK_HOURS + "): ");
        int hour = TextIO.getInt();

        if (hour < 1 || hour > WORK_HOURS) {
            System.out.println("Invalid entry. Try again.");
        }

        System.out.println("Hourly income per drink " + hour + ":");
        for (int i = 1; i <= ALL_DRINKS; i++) {
            System.out.println("Drink type " + i + ": " + incomeTotal[i - 1][hour - 1]);
        }
    }

    static void bestSellingDrink() {
        int bestSeller = 0;
        double biggestIncome = 0;

        for (int i = 0; i < ALL_DRINKS; i++) {
            double incomeForDrink = 0;
            for (int j = 0; j < WORK_HOURS; j++) {
                incomeForDrink += incomeTotal[i][j];
            }

            if (incomeForDrink > biggestIncome) {
                biggestIncome = incomeForDrink;
                bestSeller = i + 1;
            }
        }

        System.out.println("Best selling drink: " + bestSeller);
        System.out.println("Total income from best selling drink: " + biggestIncome);
    }

    static void totalDailyIncome() {
        double totalDailyIncome = 0;
        for (int i = 0; i < ALL_DRINKS; i++) {
            for (int j = 0; j < WORK_HOURS; j++) {
                totalDailyIncome += incomeTotal[i][j];
            }
        }

        System.out.println("Daily income: " + totalDailyIncome);
    }

    // !!!
    static void averageIncomePerHour() {
        for (int i = 0; i < WORK_HOURS; i++) {
            double hourlyIncome = 0;
            for (int j = 0; j < ALL_DRINKS; j++) {
                hourlyIncome += incomeTotal[j][i];
            }

            double avgIncomePerHour = hourlyIncome / ALL_DRINKS;
            System.out.println("Average income per hour " + (i + 1) + ": " + avgIncomePerHour);
        }
    }
}
