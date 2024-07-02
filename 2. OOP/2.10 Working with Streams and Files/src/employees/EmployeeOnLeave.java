package employees;

class EmployeeOnSickLeave extends Employee {
    @Override
    public double calculateSalary(double hourlyRate) {
        return 0.8 * qualificationCoefficient * hourlyRate;
    }
}
