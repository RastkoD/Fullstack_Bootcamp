package com.iktpreobuka.project_dealspot.services;

import java.util.List;

import com.iktpreobuka.project_dealspot.entities.CategoryEntity;
import com.iktpreobuka.project_dealspot.entities.OfferEntity;

public interface OfferDao {

	Iterable<OfferEntity> findAll();

	OfferEntity save(OfferEntity newOffer);

	OfferEntity findById(Long offerId);

	void delete(OfferEntity offer);

	List<OfferEntity> findByActionPriceBetween(double lowerPrice, double upperPrice);
	
	void updateAvailableAndBoughtOffers(Long offerId, int availableOffers, int boughtOffers);
	
	boolean activeOfferInCategory(CategoryEntity category);

}
