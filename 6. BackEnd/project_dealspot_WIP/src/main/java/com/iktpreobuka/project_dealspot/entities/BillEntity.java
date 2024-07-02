package com.iktpreobuka.project_dealspot.entities;

import java.time.LocalDate;

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
import jakarta.persistence.Table;

@Entity
@Table(name = "Bill")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BillEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bill_sequence_generator")
    @SequenceGenerator(name = "bill_sequence_generator", sequenceName = "bill_sequence", allocationSize = 1)
	@Column(name = "id", updatable = false)
	private Long id;
	@Column(name = "payment_made")
	private boolean paymentMade;
	@Column(name = "payment_canceled")
	private boolean paymentCanceled;
	@Column(name = "bill_created")
	private LocalDate billCreated;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "offer_id")
	private OfferEntity offer;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity user;

	public BillEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isPaymentMade() {
		return paymentMade;
	}

	public void setPaymentMade(boolean paymentMade) {
		this.paymentMade = paymentMade;
	}

	public boolean isPaymentCanceled() {
		return paymentCanceled;
	}

	public void setPaymentCanceled(boolean paymentCanceled) {
		this.paymentCanceled = paymentCanceled;
	}

	public LocalDate getBillCreated() {
		return billCreated;
	}

	public void setBillCreated(LocalDate billCreated) {
		this.billCreated = billCreated;
	}

	public OfferEntity getOffer() {
		return offer;
	}

	public void setOffer(OfferEntity offer) {
		this.offer = offer;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "BillEntity [id=" + id + ", paymentMade=" + paymentMade + ", paymentCanceled=" + paymentCanceled
				+ ", billCreated=" + billCreated + ", offer=" + offer + ", user=" + user + "]";
	}
	
	
	
}
