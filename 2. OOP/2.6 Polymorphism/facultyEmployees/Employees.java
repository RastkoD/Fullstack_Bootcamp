package facultyEmployees;

public class Employees extends Person {
	private double jobCoef;
	protected double salary;
	
	Employees(String name, String surname, int age, double jobCoef) {
		super(name, surname, age);
		this.setCoef(jobCoef);
		this.setSalary(0);
	}
	
	protected void setCoef(double jobCoef) {
		this.jobCoef = jobCoef;
	}
	
	protected void setSalary(double salary) {
		this.salary = salary;
	}
	
	protected double getCoef() {
		return this.jobCoef;
	}
	
	protected double getSalary() {
		return this.salary;
	}

	public void calcSalary() {
		
	}
	
	public void printSalary() {
        System.out.println(getName() + " " + getSurname() + " - job coefficient: " + getCoef() + " has a salary of: " + getSalary() +".");
    }
	
}
