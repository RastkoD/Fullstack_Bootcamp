package inheritance;

public class Person {
	protected String name, surname;
	protected int age;
	
	Person() {}

	Person(String name, String surname, int age) {
		setName(name);
		setSurname(surname);
		setAge(age);
	}
	
	protected void setName(String name) {
		this.name = name;
	}
	
	protected void setSurname(String surname) {
		this.surname = surname;
	}
	
	protected void setAge(int age) {
		this.age = age;
	}
	
	protected String getName() {
		return this.name;
	}
	
	protected String getSurname() {
		return this.surname;
	}
	
	protected int getAge() {
		return this.age;
	}
	
	public void introduceYourself() {

		System.out.println("Name: " + getName() + " Surname: " + getSurname() + " Age: " + getAge() + " years old");

		}
}
