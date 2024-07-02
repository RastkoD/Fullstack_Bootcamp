package com.iktpreobuka.project_dealspot.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.project_dealspot.entities.CategoryEntity;
import com.iktpreobuka.project_dealspot.entities.OfferEntity;
import com.iktpreobuka.project_dealspot.entities.UserEntity;
import com.iktpreobuka.project_dealspot.repositories.CategoryRepository;
import com.iktpreobuka.project_dealspot.repositories.UserRepository;
import com.iktpreobuka.project_dealspot.services.BillDao;
import com.iktpreobuka.project_dealspot.services.OfferDao;

@RestController
@RequestMapping(value = "/dealspot/offers")
public class OfferController {

	@Autowired
	private OfferDao offerDao;
	
	@Autowired
	BillDao billDao;
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping
	public Iterable<OfferEntity> getAllOffers() {
		return offerDao.findAll();
	}

	/* 3.4 kreirati REST endpoint koji omogućava dodavanje
		nove ponude */

	/*
	@PostMapping
    public OfferEntity addOffer(@RequestBody OfferEntity newOffer) {
        newOffer.setOfferCreated(LocalDate.now());
        newOffer.setOfferExpires(LocalDate.now().plusDays(20));
        return offerRepository.save(newOffer);
    }
	 */

	@PostMapping("/{categoryId}/seller/{sellerId}")
	public OfferEntity addOffer(@PathVariable Long categoryId,
			@PathVariable Long sellerId,
			@RequestBody OfferEntity newOffer) {
		
		UserEntity seller = userRepository.findById(sellerId).orElse(null);
		
		if(seller == null || seller.getUserRole() != UserEntity.UserRole.ROLE_SELLER) {
			return null;
		}

		newOffer.setOfferCreated(LocalDate.now());
		newOffer.setOfferExpires(LocalDate.now().plusDays(10));

		return offerDao.save(newOffer);
	}


	/* 3.5 kreirati REST endpoint koji omogućava izmenu
		postojeće ponude */

	@PutMapping("/{offerId}")
	public OfferEntity modifyOffer(@PathVariable Long offerId, @RequestBody OfferEntity modifiedOffer) {

		OfferEntity offer = offerDao.findById(offerId);

		if(offer != null) {

			offer.setOfferName(modifiedOffer.getOfferName());
			offer.setOfferDescription(modifiedOffer.getOfferDescription());
			offer.setOfferCreated(modifiedOffer.getOfferCreated());
			offer.setOfferExpires(modifiedOffer.getOfferExpires());
			offer.setRegularPrice(modifiedOffer.getRegularPrice());
			offer.setActionPrice(modifiedOffer.getActionPrice());
			offer.setAvailableOffers(modifiedOffer.getAvailableOffers());
			offer.setBoughtOffers(modifiedOffer.getBoughtOffers());

			return offerDao.save(offer);
		}
		return null;
	}

	/* 3.6 kreirati REST endpoint koji omogućava brisanje
		postojeće ponude */

	@DeleteMapping("/{offerId}")
	public OfferEntity deleteOffer(@PathVariable Long offerId) {
		
		OfferEntity offer = offerDao.findById(offerId);
		
		if(offer != null) {
			offerDao.delete(offer);
		}
		return null;
	}

	/* 3.7 kreirati REST endpoint koji vraća ponudu po vrednosti
		prosleđenog ID-a */

	@GetMapping("/{offerId}")
	public OfferEntity getById(@PathVariable Long offerId) {
		return offerDao.findById(offerId);
	}

	/* 3.8 kreirati REST endpoint koji omogućava promenu
		vrednosti atributa offer status postojeće ponude */

	@PutMapping("/changeOffer/{offerId}/status/{newStatus}")
	public OfferEntity changeStatus(@PathVariable Long offerId, @PathVariable String newStatus) {
		
		OfferEntity offer = offerDao.findById(offerId);
		
		if(offer != null) {
			offer.setOfferStatus(OfferEntity.OfferStatus.valueOf(newStatus));
			
			if(newStatus.equals("EXPIRED")) {
				billDao.cancelBillsByOfferId(offerId);
			}
			
			return offerDao.save(offer);
		}
		return null;
	}

	/* 3.9 kreirati REST endpoint koji omogućava pronalazak svih
		ponuda čija se akcijska cena nalazi u odgovarajućem rasponu */

	@GetMapping("/findByPrice/{lowerPrice}/and/{upperPrice}")
	public List<OfferEntity> findByPriceRange(@PathVariable double lowerPrice, @PathVariable double upperPrice) {
		return offerDao.findByActionPriceBetween(lowerPrice, upperPrice);
	}
	
	/* 2.4 omogućiti izmenu kategorije ponude */
	
	@PutMapping("/{offerId}/category/{categoryId}")
	public OfferEntity updateOfferCategory(@PathVariable Long offerId,
			@PathVariable Long categoryId) {
		OfferEntity offer = offerDao.findById(offerId);
		if(offer != null) {
			CategoryEntity category = categoryRepository.findById(categoryId).orElse(null);
			if(category != null) {
				offer.setCategory(category);
				return offerDao.save(offer);
			}
		}
		return null;
	}
	
	/* 3.2 kreirati REST endpoint koji omogućava upload slike za kreiranu ponudu */
	
	
}
