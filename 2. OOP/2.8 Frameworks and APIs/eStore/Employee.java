package eStore;

public class Employee extends Person {
    private double jobCoef;
    protected double salary;
    
    public Employee(String name, String surname, int age, double jobCoef) {
        super(name, surname, age);
        this.jobCoef = jobCoef;
        this.salary = 0;
    }
    
    public void setCoef(double jobCoef) {
        this.jobCoef = jobCoef;
    }
    
    public void setSalary(int workDays) {
        salary = jobCoef * workDays;
    }
    
    public double getCoef() {
        return jobCoef;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public void printSalary() {
        System.out.println(getName() + " " + getSurname() + " - job coefficient: " + getCoef() + " has a salary of: " + getSalary() + ".");
    }
}
