package com.iktpreobuka.serialization_project.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.iktpreobuka.serialization_project.security.Views;

public class AddressEntity {
	@JsonView(Views.Private.class)//sve je Private jer je tako stavljeno u UserEntity
	private Integer id;
	@JsonView(Views.Admin.class)//...ali zbog primera da moze i ovo da se izostavi
	private String street;
	@JsonView(Views.Private.class)
	private String city;
	@JsonView(Views.Private.class)
	private String country;
	private Integer version;
	
	//@JsonManagedReference//rešavanje rekurzije - znaci nemoj da prekidas(koji kraj veze je prikaziv a koji nije)
	@JsonBackReference//sada ovako zbog views
	private List<UserEntity> users = new ArrayList<>();

	public AddressEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddressEntity(Integer id, String street, String city, String country, Integer version, List<UserEntity> users) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
		this.country = country;
		this.version = version;
		this.users = users;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer i) {
		this.id = i;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}
	
	
}
