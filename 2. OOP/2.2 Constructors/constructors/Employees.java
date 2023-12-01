package constructors;

public class Employees {
	String name, surname;
	double jobCoef, salary;
	
	Employees() {};
	
	Employees(String n, String s, double jc) {
		this.name = n;
		this.surname = s;
		this.jobCoef = jc;
	}
	
	void calcSalary(int days) {
		this.salary = this.jobCoef * days * 100;
	}
	
	void printEmployee() {
		System.out.println("Employee: " + this.name + " " + this.surname + " has a salary of: " + this.salary);
	}
}
