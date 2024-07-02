package com.iktpreobuka.project_dealspot.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.project_dealspot.entities.BillEntity;
import com.iktpreobuka.project_dealspot.entities.CategoryEntity;
import com.iktpreobuka.project_dealspot.entities.OfferEntity;
import com.iktpreobuka.project_dealspot.entities.UserEntity;
import com.iktpreobuka.project_dealspot.repositories.CategoryRepository;
import com.iktpreobuka.project_dealspot.repositories.UserRepository;
import com.iktpreobuka.project_dealspot.services.BillDao;
import com.iktpreobuka.project_dealspot.services.OfferDao;

@RestController
@RequestMapping(value = "/dealspot/bills")
public class BillController {

	@Autowired
	BillDao billDao;

	@Autowired
	OfferDao offerDao;

	@Autowired
	UserRepository userRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping
	public Iterable<BillEntity> getAllBills() {
		return billDao.findAll();
	}

	@PostMapping("/{offerId}/buyer/{buyerId}")
	public BillEntity addBill(@PathVariable Long offerId,
			@PathVariable Long buyerId) {

		OfferEntity offer = offerDao.findById(offerId);
		UserEntity buyer = userRepository.findById(buyerId).orElse(null);

		if(offer == null || buyer == null || offer.getAvailableOffers() <= 0) {
			return null;
		}
		
		offerDao.updateAvailableAndBoughtOffers(offer.getId(), - 1, 1);
		
		offerDao.save(offer);

		BillEntity newBill = new BillEntity();
		newBill.setPaymentMade(false);
		newBill.setPaymentCanceled(false);
		newBill.setBillCreated(LocalDate.now());
		newBill.setOffer(offer);
		newBill.setUser(buyer);

		billDao.save(newBill);

		return newBill;

	}

	@PutMapping("/{billId}")
	public BillEntity modifyBill(@PathVariable Long billId,
			@RequestParam boolean paymentMade,
			@RequestParam boolean paymentCanceled) {

		BillEntity bill = billDao.findById(billId);

		if(bill != null) {
			bill.setPaymentMade(paymentMade);
			bill.setPaymentCanceled(paymentCanceled);
			
			if(paymentCanceled) {
				OfferEntity offer = bill.getOffer();
				
				if(offer != null) {
					offerDao.updateAvailableAndBoughtOffers(offer.getId(), 1, - 1);
				}
			}

			billDao.save(bill);
			billDao.createVoucherFromBill(bill);
			
			return bill;
		}
		return null;
	}

	@DeleteMapping("/{billId}")
	public BillEntity deleteBill(@PathVariable Long billId) {

		BillEntity bill = billDao.findById(billId);

		if(bill != null) {

			billDao.delete(bill);
			return bill;
		}
		return null;
	}

	/* 3.7 kreirati REST endpoint za pronalazak svih računa	određenog kupca */

	@GetMapping("/findByBuyer/{buyerId}")
	public List<BillEntity> findBillByBuyer(@PathVariable Long buyerId) {

		UserEntity buyer = userRepository.findById(buyerId).orElse(null);

		if(buyer != null) {
			List<BillEntity> bills = billDao.findByUser(buyer);
			return bills;
		}
		return null;
	}

	/* 3.8 kreirati REST endpoint za pronalazak svih računa određene kategorije */

	@GetMapping("/findByCategory/{categoryId}")
	public List<BillEntity> findBillByCategory(@PathVariable Long categoryId) {

		CategoryEntity category = categoryRepository.findById(categoryId).orElse(null);
		List<BillEntity> bills = new ArrayList<>();

		if(category != null) {

			for(OfferEntity offer : category.getOffers()) {
				bills.addAll(billDao.findByOffer(offer));
			}

			return bills;
		}
		return null;
	}
	
	/* 3.9 kreirati REST endpoint za pronalazak svih računa koji
		su kreirani u odgovarajućem vremenskom periodu */
	
	@GetMapping("/findByDate/{startDate}/and/{endDate}")
	public List<BillEntity> findBillByDate(
			@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy")
			LocalDate startDate,
			@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy")
			LocalDate endDate) {
		
		List<BillEntity> bills = billDao.findByBillCreatedBetween(startDate, endDate);
		
		return bills;
	}
}
