package com.iktpreobuka.project_dealspot.entities;

import java.time.LocalDate;
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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Offer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OfferEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "offer_sequence_generator")
    @SequenceGenerator(name = "offer_sequence_generator", sequenceName = "offer_sequence", allocationSize = 1)
	@Column(name = "id", updatable = false)
	private Long id;
	@Column(name = "offer_name", columnDefinition = "TEXT")
	private String offerName;
	@Column(name = "offer_description", columnDefinition = "TEXT")
	private String offerDescription;
	@Column(name = "offer_created")
	private LocalDate offerCreated;
	@Column(name = "offer_expires")
	private LocalDate offerExpires;
	@Column(name = "regular_price")
	private double regularPrice;
	@Column(name = "action_price")
	private double actionPrice;
	@Column(name = "image_path", columnDefinition = "VARCHAR(255)")
	private String imagePath;
	@Column(name = "available_offers", columnDefinition = "INTEGER")
	private int availableOffers;
	@Column(name = "bought_offers", columnDefinition = "INTEGER")
	private int boughtOffers;
	@Column(name = "offer_status")
	@Enumerated(EnumType.STRING)
	private OfferStatus offerStatus;
	
	public enum OfferStatus {
        WAIT_FOR_APPROVING,
        APPROVED,
        DECLINED,
        EXPIRED
    }
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by_id")
	private UserEntity createdBy;
	
	@JsonIgnore
	@OneToMany(mappedBy = "offer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<BillEntity> bills;
	
	@JsonIgnore
	@OneToMany(mappedBy = "offer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VoucherEntity> vouchers;

	public OfferEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public String getOfferDescription() {
		return offerDescription;
	}

	public void setOfferDescription(String offerDescription) {
		this.offerDescription = offerDescription;
	}

	public LocalDate getOfferCreated() {
		return offerCreated;
	}

	public void setOfferCreated(LocalDate offerCreated) {
		this.offerCreated = offerCreated;
	}

	public LocalDate getOfferExpires() {
		return offerExpires;
	}

	public void setOfferExpires(LocalDate offerExpires) {
		this.offerExpires = offerExpires;
	}

	public double getRegularPrice() {
		return regularPrice;
	}

	public void setRegularPrice(double regularPrice) {
		this.regularPrice = regularPrice;
	}

	public double getActionPrice() {
		return actionPrice;
	}

	public void setActionPrice(double actionPrice) {
		this.actionPrice = actionPrice;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getAvailableOffers() {
		return availableOffers;
	}

	public void setAvailableOffers(int availableOffers) {
		this.availableOffers = availableOffers;
	}

	public int getBoughtOffers() {
		return boughtOffers;
	}

	public void setBoughtOffers(int boughtOffers) {
		this.boughtOffers = boughtOffers;
	}

	public OfferStatus getOfferStatus() {
		return offerStatus;
	}

	public void setOfferStatus(OfferStatus offerStatus) {
		this.offerStatus = offerStatus;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public UserEntity getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UserEntity createdBy) {
		this.createdBy = createdBy;
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
		return "OfferEntity [id=" + id + ", offerName=" + offerName + ", offerDescription=" + offerDescription
				+ ", offerCreated=" + offerCreated + ", offerExpires=" + offerExpires + ", regularPrice=" + regularPrice
				+ ", actionPrice=" + actionPrice + ", imagePath=" + imagePath + ", availableOffers=" + availableOffers
				+ ", boughtOffers=" + boughtOffers + ", offerStatus=" + offerStatus + ", category=" + category
				+ ", createdBy=" + createdBy + ", bills=" + bills + ", vouchers=" + vouchers + "]";
	}
	
}
