package students;

public class Student {
	String name;
	String surname;
	String ssn;

	public Student(String name, String surname, String ssn) {
		this.name = name;
		this.surname = surname;
		this.ssn = ssn;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setSSN(String ssn) {
		this.ssn = ssn;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public String getSSN() {
		return this.ssn;
	}


	@Override
	public String toString() {
		return getName() + " " + getSurname() + " " + getSSN();
	}
}
