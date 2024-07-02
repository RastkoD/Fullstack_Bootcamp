package com.iktpreobuka.dataaccess.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Version;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  /* uvek se dodaje */
public class AddressEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_sequence_generator")
    @SequenceGenerator(name = "address_sequence_generator", sequenceName = "address_sequence", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String country;
    
	@Version
	private Integer version;
	
	@JsonIgnore /* prekida lanac da ne bi islo u nedogled user:address:pa opet user koji zivi na address:pa opet njegov address i tako */
	@OneToMany(mappedBy = "address", fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
									  //Vazno, pogledaj
	
	private List<UserEntity> users = new ArrayList<UserEntity>();
	
	public AddressEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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