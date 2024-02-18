package eStore;

public class Person {
	protected String name, surname;
	protected int age;

	Person() {}

	public Person(String name, String surname, int age) {
		this.name = name;
		this.surname = surname;
		this.age = age;
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
		System.out.println("Name: " + name + ", surname: " + surname + ", age: " + age + " years old.");
	}
}
