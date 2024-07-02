package com.iktpreobuka.project_dealspot.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.project_dealspot.entities.CategoryEntity;
import com.iktpreobuka.project_dealspot.entities.OfferEntity;

public interface OfferRepository extends CrudRepository<OfferEntity, Long> {
	
	List<OfferEntity> findByActionPriceBetween(double lowerPrice, double upperPrice);

	boolean existsByCategoryAndOfferExpiresAfter(CategoryEntity category, LocalDate now);
}
