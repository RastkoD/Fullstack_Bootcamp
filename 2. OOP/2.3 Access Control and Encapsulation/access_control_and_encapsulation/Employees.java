package access_control_and_encapsulation;

public class Employees {
	private String name, surname;
	private double jobCoef, days;
	
	public void setName(String n) {
		this.name = n;
	}
	
	public void setSurname(String s) {
		this.surname = s;
	}
	
	public void setCoef(double c) {
		this.jobCoef = c;
	}
	
	public void setDays(double d) {
		this.days = d;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public double getCoef() {
		return this.jobCoef;
	}
	
	public double getDays() {
		return this.days;
	}
	
	double calcPay() {
		return this.jobCoef * 100 * this.getDays();
	}
	
	void printPay() {
		System.out.println("Employee: " + this.getName() + " " + this.getSurname() + " has a salary of: " + this.calcPay());
	
	}
	
}
