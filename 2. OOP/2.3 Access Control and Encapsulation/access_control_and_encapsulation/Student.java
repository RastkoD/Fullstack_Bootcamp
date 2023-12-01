package access_control_and_encapsulation;

public class Student {
	private String name, surname; 
	private double test1, test2; 

	public void setName(String n) {
		this.name = n;

	}

	public void setSurname(String s) {
		this.surname = s;
	}

	public void setTestOne(double t1) {
		this.test1 = t1;
	}

	public void setTestTwo(double t2) {
		this.test2 = t2;
	}

	public String getName() {
		return this.name;
	}

	public String getSurname() {
		return this.surname;
	}

	public double getTestOne() {
		return this.test1;
	}

	public double getTestTwo() {
		return this.test2;
	}



	public double calcAvg() { 
		return (this.getTestOne() + this.getTestTwo()) / 2;
	}

	public void printAvg(){
		System.out.println("Student " + this.getName() +" "+ this.getSurname() + " - average of two test results is: " + calcAvg());
	}	
}
