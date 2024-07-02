package com.iktpreobuka.project_dealspot.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "User")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence_generator")
    @SequenceGenerator(name = "user_sequence_generator", sequenceName = "user_sequence", allocationSize = 1)
	@Column(name = "id", updatable = false)
	private Long id;
	@Column(name = "first_name", columnDefinition = "TEXT")
	private String firstName;
	@Column(name = "last_name", columnDefinition = "TEXT")
	private String lastName;
	@Column(name = "username", columnDefinition = "TEXT")
	private String username;
	@Column(name = "password", columnDefinition = "TEXT")
	private String password;
	@Column(name = "email", columnDefinition = "TEXT")
	private String email;
	@Column(name = "user_role")
	@Enumerated(EnumType.STRING)
	private UserRole userRole;

	public enum UserRole {
		ROLE_CUSTOMER,
		ROLE_ADMIN,
		ROLE_SELLER
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "createdBy", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private List<OfferEntity> createdOffers;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<BillEntity> bills;

	@JsonIgnore
	@OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VoucherEntity> vouchers;

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public List<OfferEntity> getCreatedOffers() {
		return createdOffers;
	}

	public void setCreatedOffers(List<OfferEntity> createdOffers) {
		this.createdOffers = createdOffers;
	}

	public List<BillEntity> getBills() {
		return bills;
	}

	public void setBills(List<BillEntity> bills) {
		this.bills = bills;
	}

	public List<VoucherEntity> getVouchers() {
		return vouchers;
	}

	public void setVouchers(List<VoucherEntity> vouchers) {
		this.vouchers = vouchers;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", email=" + email + ", userRole=" + userRole + ", createdOffers="
				+ createdOffers + ", bills=" + bills + ", vouchers=" + vouchers + "]";
	}
	
	
}
