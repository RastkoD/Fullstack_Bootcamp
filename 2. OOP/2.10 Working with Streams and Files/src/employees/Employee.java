package employees;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

abstract class Employee {
    protected String firstName;
    protected String lastName;
    protected String JMBG;
    protected String bankAccountNumber;
    protected double qualificationCoefficient;

    public abstract double calculateSalary(double hourlyRate);

    public void loadData(BufferedReader reader) throws IOException {
        firstName = readLineSafe(reader);
        lastName = readLineSafe(reader);
        JMBG = readLineSafe(reader);
        bankAccountNumber = readLineSafe(reader);

        String qualificationCoefficientString = readLineSafe(reader);
        if (qualificationCoefficientString != null) {
            qualificationCoefficient = Double.parseDouble(qualificationCoefficientString.trim());
        }
    }

    public void writeData(BufferedWriter writer, double hourlyRate) throws IOException {
        writer.write(firstName);
        writer.newLine();
        writer.write(lastName);
        writer.newLine();
        writer.write(JMBG);
        writer.newLine();
        writer.write(bankAccountNumber);
        writer.newLine();
        writer.write(Double.toString(qualificationCoefficient));
        writer.newLine();
        writer.write(Double.toString(calculateSalary(hourlyRate)));
        writer.newLine();
    }

    protected String readLineSafe(BufferedReader reader) throws IOException {
        return reader.readLine();
    }
}
