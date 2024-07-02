package com.iktpreobuka.project_dealspot.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktpreobuka.project_dealspot.entities.CategoryEntity;
import com.iktpreobuka.project_dealspot.entities.OfferEntity;
import com.iktpreobuka.project_dealspot.repositories.OfferRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class OfferDaoImpl implements OfferDao {

	@PersistenceContext
	EntityManager em;
	
	@Autowired
	OfferRepository offerRepository;

	@Override
	public Iterable<OfferEntity> findAll() {
		return offerRepository.findAll();
	}

	@Override
	public OfferEntity save(OfferEntity newOffer) {
		return offerRepository.save(newOffer);
	}

	@Override
	public OfferEntity findById(Long offerId) {
		return offerRepository.findById(offerId).orElse(null);
	}

	@Override
	public void delete(OfferEntity offer) {
		offerRepository.delete(offer);
		
	}

	@Override
	public List<OfferEntity> findByActionPriceBetween(double lowerPrice, double upperPrice) {
		return offerRepository.findByActionPriceBetween(lowerPrice, upperPrice);
	}

	@Override
	public void updateAvailableAndBoughtOffers(Long offerId, 
			int availableOfferUpdate, int boughtOfferUpdate) {
		
		OfferEntity offer = offerRepository.findById(offerId).orElse(null);
		
		if(offer != null) {
			offer.setAvailableOffers(offer.getAvailableOffers() + availableOfferUpdate);
			offer.setBoughtOffers(offer.getBoughtOffers() + boughtOfferUpdate);
			
			offerRepository.save(offer);
		}
	}

	@Override
	public boolean activeOfferInCategory(CategoryEntity category) {
		return offerRepository.existsByCategoryAndOfferExpiresAfter(category, LocalDate.now());
	}

}
