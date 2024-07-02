package com.iktpreobuka.project_dealspot.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktpreobuka.project_dealspot.entities.BillEntity;
import com.iktpreobuka.project_dealspot.entities.OfferEntity;
import com.iktpreobuka.project_dealspot.entities.UserEntity;
import com.iktpreobuka.project_dealspot.entities.VoucherEntity;
import com.iktpreobuka.project_dealspot.repositories.BillRepository;
import com.iktpreobuka.project_dealspot.repositories.VoucherRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class VoucherDaoImpl implements VoucherDao {

	@PersistenceContext
	EntityManager em;
	
	@Autowired
	VoucherRepository voucherRepository;
	
	@Autowired
	BillRepository billRepository;

	@Override
	public Iterable<VoucherEntity> findAll() {
		return voucherRepository.findAll();
	}

	@Override
	public void save(VoucherEntity voucher) {
		voucherRepository.save(voucher);
		
	}

	@Override
	public VoucherEntity findById(Long voucherId) {
		return voucherRepository.findById(voucherId).orElse(null);
	}

	@Override
	public void delete(VoucherEntity voucher) {
		voucherRepository.delete(voucher);
		
	}

	@Override
	public List<VoucherEntity> findByBuyer(UserEntity buyer) {
		return voucherRepository.findByBuyer(buyer);
	}

	@Override
	public List<VoucherEntity> findByOffer(OfferEntity offer) {
		return voucherRepository.findByOffer(offer);
	}

	@Override
	public List<VoucherEntity> findByExpirationDateAfter(LocalDate now) {
		return voucherRepository.findByExpirationDateAfter(now);
	}

	@Override
	public void createVoucherFromBill(BillEntity bill) {
		if(bill.isPaymentMade()) {			
			
             

		}
		
	}
}
