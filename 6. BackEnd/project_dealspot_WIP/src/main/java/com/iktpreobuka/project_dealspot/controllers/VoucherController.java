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

import com.iktpreobuka.project_dealspot.entities.OfferEntity;
import com.iktpreobuka.project_dealspot.entities.UserEntity;
import com.iktpreobuka.project_dealspot.entities.VoucherEntity;
import com.iktpreobuka.project_dealspot.repositories.UserRepository;
import com.iktpreobuka.project_dealspot.services.OfferDao;
import com.iktpreobuka.project_dealspot.services.VoucherDao;

@RestController
@RequestMapping(value = "/dealspot/vouchers")
public class VoucherController {
	
	@Autowired
	VoucherDao voucherDao;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	OfferDao offerDao;
	
	@GetMapping
    public Iterable<VoucherEntity> getAllVouchers() {
        return voucherDao.findAll();
    }
	
	@PostMapping("/{offerId}/buyer/{buyerId}")
	public VoucherEntity addVoucher(@PathVariable Long offerId,
			@PathVariable Long buyerId) {
		
		OfferEntity offer = offerDao.findById(offerId);
		UserEntity buyer = userRepository.findById(buyerId).orElse(null);
		
		if(offer == null || buyer == null || buyer.getUserRole() != UserEntity.UserRole.ROLE_CUSTOMER) {
			return null;
		}

		VoucherEntity voucher = new VoucherEntity();
		
		voucher.setExpirationDate(LocalDate.now().plusDays(5));
		voucher.setUsed(false);
		voucher.setOffer(offer);
		voucher.setBuyer(buyer);
		
		voucherDao.save(voucher);

		return voucher;
		
	}
	
	@PutMapping("/{voucherId}")
	public VoucherEntity modifyVoucher(@PathVariable Long voucherId,
			@RequestBody VoucherEntity modifiedVoucher) {
		
		VoucherEntity voucher = voucherDao.findById(voucherId);
		
		if(voucher != null) {
			voucher.setExpirationDate(modifiedVoucher.getExpirationDate());
			voucher.setUsed(modifiedVoucher.isUsed());
			
			voucherDao.save(voucher);
			
			return voucher;
		}
		
		return null;
	}
	
	@DeleteMapping("/{voucherId}")
	public VoucherEntity deleteVoucher(@PathVariable Long voucherId) {
		
		VoucherEntity voucher = voucherDao.findById(voucherId);
		
		if(voucher != null) {
			
			voucherDao.delete(voucher);
			
			return voucher;
		}
		
		return null;
	}
	
	/* 4.7 kreirati REST endpoint za pronalazak svih vaučera određenog kupca */
	
	@GetMapping("/findByBuyer/{buyerId}")
	public List<VoucherEntity> findVoucherByBuyer(@PathVariable Long buyerId) {

		UserEntity buyer = userRepository.findById(buyerId).orElse(null);

		if(buyer != null) {
			List<VoucherEntity> voucher = voucherDao.findByBuyer(buyer);
			return voucher;
		}
		return null;
	}
	
	/* 4.8 kreirati REST endpoint za pronalazak svih vaučera određene ponude */
	
	@GetMapping("/findByOffer/{offerId}")
	public List<VoucherEntity> findVoucherByOffer(@PathVariable Long offerId) {
		
		OfferEntity offer = offerDao.findById(offerId);
		
		if(offer != null) {
			List<VoucherEntity> voucher = voucherDao.findByOffer(offer);
			
			return voucher;
		}
		return null;
	}
	
	/* 4.9 kreirati REST endpoint za pronalazak svih vaučera koji nisu istekli */
	
	@GetMapping("/findNonExpiredVoucher")
	public List<VoucherEntity> findNonExpiredVoucher() {
		
		List<VoucherEntity> voucher = voucherDao.findByExpirationDateAfter(LocalDate.now());
		
		return voucher;
	}
}
