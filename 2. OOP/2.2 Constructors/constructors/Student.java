package constructors;

public class Student {
	String name, surname;
	double test1, test2, average;
	
	Student() {}
	
	Student(String n, String s, double t1, double t2) {
		this.name = n;
		this.surname = s;
		this.test1 = t1;
		this.test2 = t2;
	}
	
	void calcAvg() {
		this.average = (test1 + test2) / 2; 
	}
	
	void printPoints() {
		System.out.println("Student " + this.name + " " + this.surname + ": Test one result: " + this.test1 + ". Test Two result: " + this.test2 + " Average is: " + this.average);
	}
	

}
