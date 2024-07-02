package com.iktpreobuka.project_dealspot.services;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktpreobuka.project_dealspot.entities.BillEntity;
import com.iktpreobuka.project_dealspot.entities.CategoryEntity;
import com.iktpreobuka.project_dealspot.entities.OfferEntity;
import com.iktpreobuka.project_dealspot.entities.UserEntity;
import com.iktpreobuka.project_dealspot.entities.VoucherEntity;
import com.iktpreobuka.project_dealspot.repositories.BillRepository;
import com.iktpreobuka.project_dealspot.repositories.VoucherRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class BillDaoImpl implements BillDao {

	@PersistenceContext
	EntityManager em;
	
	@Autowired
	BillRepository billRepository;
	
	@Autowired
	VoucherRepository voucherRepository;

	@Override
	public Iterable<BillEntity> findAll() {
		return billRepository.findAll();
	}

	@Override
	public void save(BillEntity newBill) {
		billRepository.save(newBill);
		
	}

	@Override
	public BillEntity findById(Long billId) {
		return billRepository.findById(billId).orElse(null);
	}

	@Override
	public void delete(BillEntity bill) {
		billRepository.delete(bill);
		
	}

	@Override
	public List<BillEntity> findByUser(UserEntity buyer) {
		return billRepository.findByUser(buyer);
	}

	@Override
	public Collection<? extends BillEntity> findByOffer(OfferEntity offer) {
		return billRepository.findByOffer(offer);
	}

	@Override
	public List<BillEntity> findByBillCreatedBetween(LocalDate startDate, LocalDate endDate) {
		return billRepository.findByBillCreatedBetween(startDate, endDate);
	}

	@Override
	public boolean activeBillInCategory(CategoryEntity category) {
		return billRepository.existsByOfferCategoryAndPaymentMadeFalse(category);
	}

	@Override
	public void cancelBillsByOfferId(Long offerId) {
		OfferEntity offer = em.find(OfferEntity.class, offerId);
		
		if(offer != null) {
			List<BillEntity> bills = billRepository.findByOffer(offer);
			
			for(BillEntity bill : bills) {
				bill.setPaymentCanceled(true);
				billRepository.save(bill);
			}
		}
		
	}

	@Override
	public void createVoucherFromBill(BillEntity bill) {
		if(bill.isPaymentMade()) {
			VoucherEntity voucher = new VoucherEntity();
			
			voucher.setExpirationDate(bill.getBillCreated().plusDays(10));
			voucher.setUsed(false);
			voucher.setOffer(bill.getOffer());
			voucher.setBuyer(bill.getUser());
			
            voucherRepository.save(voucher);
		}
		
	}
}
