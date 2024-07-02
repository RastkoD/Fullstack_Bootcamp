package institution;

public class Employees extends Person {
	private static final int WORKDAYS = 20;
	private double jobCoef, salary;
	
	Employees(String name, String surname, int age, double jobCoef) {
		super(name, surname, age);
		this.jobCoef = jobCoef;
		setSalary(WORKDAYS);
	}
	
	protected void setCoef(double jobCoef) {
		this.jobCoef = jobCoef;
	}
	
	protected double setSalary(int workdays) {
		return salary = getCoef() * workdays;
	}
	
	protected double getCoef() {
		return this.jobCoef;
	}
	
	protected double getSalary() {
		return this.salary;
	}
	
	public String toString() {
		return this.getName() + " " + this.getSurname() + ", with coefficient " + this.getCoef() + " has a salary of: " + this.getSalary();
	}
}
