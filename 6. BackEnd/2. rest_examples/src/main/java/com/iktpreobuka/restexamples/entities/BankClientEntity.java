package com.iktpreobuka.restexamples.entities;

public class BankClientEntity {
	protected int id;
	protected String name;
	protected String surname;
	protected String email;
	protected int age;
	protected String address;
	
	public BankClientEntity() {}

	public BankClientEntity(int id, String name, String surname, String email, int age, String address) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.age = age;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "BankClientEntity [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", age="
				+ age + ", address=" + address + "]";
	}

	public void setCreditRating(String creditRating) {
		
		
	}

	
}
