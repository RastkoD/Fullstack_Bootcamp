package com.iktpreobuka.project_dealspot.entities;

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
import jakarta.persistence.Table;

@Entity
@Table(name = "Category")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CategoryEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_sequence_generator")
    @SequenceGenerator(name = "category_sequence_generator", sequenceName = "category_sequence", allocationSize = 1)
	@Column(name = "id", updatable = false)
	private Long id;
	@Column(name = "category_name", nullable = false, columnDefinition = "TEXT")
	private String categoryName;
	@Column(name = "category_description", nullable = false, columnDefinition = "TEXT")
	private String categoryDescription;
	
	@JsonIgnore
	@OneToMany(mappedBy = "category", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private List<OfferEntity> offers;

	public CategoryEntity() {
		super();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public List<OfferEntity> getOffers() {
		return offers;
	}

	public void setOffers(List<OfferEntity> offers) {
		this.offers = offers;
	}

	@Override
	public String toString() {
		return "CategoryEntity [id=" + id + ", categoryName=" + categoryName + ", categoryDescription="
				+ categoryDescription + ", offers=" + offers + "]";
	}

	
}
