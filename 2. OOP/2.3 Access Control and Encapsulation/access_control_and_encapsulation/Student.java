package access_control_and_encapsulation;

public class Student {
	private String name, surname;
	private double test1, test2, average;
	
	Student() {}
	
	Student(String n, String s, double t1, double t2) {
		this.name = n;
		this.surname = s;
		this.test1 = t1;
		this.test2 = t2;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setTest1(double t1) {
		this.test1 = t1;
	}
	
	public void setTest2(double t2) {
		this.test2 = t2;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public double getTest1() {
		return this.test1;
	}
	
	public double getTest2() {
		return this.test2;
	}
	
	void calcAvg() {
		this.average = (getTest1() + getTest2()) / 2; 
	}
	
	void printPoints() {
		System.out.println("Student " + getName() + " " + getSurname() + ": Test one result: " + getTest1() + ". Test Two result: " + getTest2() + " Average is: " + this.average);
	}
	

}
