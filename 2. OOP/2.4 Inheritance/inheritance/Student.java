package inheritance;

public class Student extends Person {
	protected double test1, test2;
	protected String indexNum;
	
	Student(String name, String surname, int age, String indexNum, double t1, double t2) {
		super(name, surname, age);
		this.indexNum = indexNum;
		this.test1 = t1;
		this.test2 = t2;
	}
	
	public void setIndex(String indexNum) {
		this.indexNum = indexNum;
	}

	public void setTest1(double t1) {
		this.test1 = t1;
	}
	
	public void setTest2(double t2) {
		this.test2 = t2;
	}
	
	public String getIndex() {
		return this.indexNum;
	}
	
	public double getTest1() {
		return this.test1;
	}
	
	public double getTest2() {
		return this.test2;
	}
	
	double calcAvg() {
		return (getTest1() + getTest2()) / 2; 
	}
	
	void printPoints() {
		System.out.println("Student " + getName() + " " + getSurname() + " (index: " + getIndex() + ")" + ": Test one result: " + getTest1() + ". Test Two result: " + getTest2() + " Average is: " + calcAvg());
	}
	

}
