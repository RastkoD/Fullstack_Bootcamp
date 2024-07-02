package com.iktpreobuka.project_dealspot.services;

import java.time.LocalDate;
import java.util.List;

import com.iktpreobuka.project_dealspot.entities.BillEntity;
import com.iktpreobuka.project_dealspot.entities.OfferEntity;
import com.iktpreobuka.project_dealspot.entities.UserEntity;
import com.iktpreobuka.project_dealspot.entities.VoucherEntity;

public interface VoucherDao {

	Iterable<VoucherEntity> findAll();

	void save(VoucherEntity voucher);

	VoucherEntity findById(Long voucherId);

	void delete(VoucherEntity voucher);

	List<VoucherEntity> findByBuyer(UserEntity buyer);

	List<VoucherEntity> findByOffer(OfferEntity offer);

	List<VoucherEntity> findByExpirationDateAfter(LocalDate now);
	
	void createVoucherFromBill(BillEntity bill);

}
