package com.iktpreobuka.uploadexample.entities;

public class UserEntity {
	private String name;
	private String email;
	private String city;
	private double expenses;
	
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserEntity(String name, String email, String city, double expenses) {
		super();
		this.name = name;
		this.email = email;
		this.city = city;
		this.expenses = expenses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getExpenses() {
		return expenses;
	}

	public void setExpenses(double expenses) {
		this.expenses = expenses;
	}

	@Override
	public String toString() {
		return "UserEntity [name = " + name + ", email = " + email + ", city = " + city + ", expenses = " + expenses + "]";
	}
	
}
