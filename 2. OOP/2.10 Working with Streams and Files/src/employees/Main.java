package employees;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("spisak.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("plate.txt"))) {

            double hourlyRate = Double.parseDouble(reader.readLine());
            int numberOfEmployees = Integer.parseInt(reader.readLine());

            for (int i = 0; i < numberOfEmployees; i++) {
                String lineType = reader.readLine();

                if ("+".equals(lineType)) {
                    ActiveEmployee activeEmployee = new ActiveEmployee();
                    activeEmployee.loadData(reader);
                    activeEmployee.loadVariableCoefficient(reader);
                    activeEmployee.writeData(writer, hourlyRate);
                } else if ("-".equals(lineType)) {
                    EmployeeOnSickLeave employeeOnSickLeave = new EmployeeOnSickLeave();
                    employeeOnSickLeave.loadData(reader);
                    employeeOnSickLeave.writeData(writer, hourlyRate);
                }

                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}