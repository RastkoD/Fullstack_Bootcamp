package inheritance;

public class Employees extends Person {
	protected double jobCoef, salary;

	Employees(String name, String surname, int age, double jC) {
		super(name, surname, age);
		this.jobCoef = jC;
	}

	public void setJobCoef(double jC) {
		this.jobCoef = jC;
	}
	
	public double getJobCoef() {
		return this.jobCoef;
	}

	void calcSalary(int days) {
		salary = getJobCoef() * days * 100;
	}

	void printEmployee() {
		System.out.println("Employee: " + getName() + " " + getSurname() + " has a salary of: " + salary);
	}
}
