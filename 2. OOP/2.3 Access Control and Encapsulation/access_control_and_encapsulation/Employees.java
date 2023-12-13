package access_control_and_encapsulation;

public class Employees {
	private String name, surname;
	private double jobCoef;
	int days;

	Employees() {};

	Employees(String n, String s, double jC) {
		this.name = n;
		this.surname = s;
		this.jobCoef = jC;
	}

	public void setName(String n) {
		this.name = n;
	}

	public void setSurname(String s) {
		this.surname = s;
	}

	public void setJobCoef(double jC) {
		this.jobCoef = jC;
	}
	
	public void setDays(int d) {
		this.days = d;
	}
	
	public String getName() {
		return this.name;
	}

	public String getSurname() {
		return this.surname;
	}

	public double getJobCoef() {
		return this.jobCoef;
	}
	
	public int getDays() {
		return this.days;
	}

	double calcSalary() {
		return getJobCoef() * getDays() * 100;
	}

	void printEmployee() {
		System.out.println("Employee: " + getName() + " " + getSurname() + " has a salary of: " + calcSalary());
	}
}
