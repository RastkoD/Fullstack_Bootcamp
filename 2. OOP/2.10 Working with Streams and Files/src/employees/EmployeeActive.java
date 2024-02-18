package employees;

import java.io.BufferedReader;
import java.io.IOException;

class ActiveEmployee extends Employee {
    private double variableCoefficient;

    @Override
    public double calculateSalary(double hourlyRate) {
        return (qualificationCoefficient + variableCoefficient) * hourlyRate;
    }

    public void loadVariableCoefficient(BufferedReader reader) throws IOException {
        String variableCoefficientString = readLineSafe(reader);
        if (variableCoefficientString != null) {
            variableCoefficient = Double.parseDouble(variableCoefficientString.trim());
        }
    }
}
