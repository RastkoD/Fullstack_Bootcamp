package com.iktpreobuka.dataaccess.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity /* govori da je entity bean koje ce biti preveden hibernateom u odgovarajucu tabelu u bazu */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  /* uvek se dodaje */
public class UserEntity {

	@Id /* govori da sledi id - kljuc */
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence_generator")
	@SequenceGenerator(name = "user_sequence_generator", sequenceName = "user_sequence", allocationSize = 1)
	private Long id;
	/* automatski generisanje id kolone u DB */
	private String name;
	private String email;
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	@Column(name = "phone_number")
	private String phoneNumber;
	private String jmbg;
	@Column(name = "id_card_number")
	private String idCardNumber;

	/* cascadeType - sta ce biti snimljeno u bazi po snimanju ovog entiteta */
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "address") // ime kolone kao stranog kljuca
	private AddressEntity address;

	public UserEntity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getIdCardNumber() {
		return idCardNumber;
	}

	public void setIdCardNumber(String idCardNumber) {
		this.idCardNumber = idCardNumber;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}



}