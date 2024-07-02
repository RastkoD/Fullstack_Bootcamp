package com.iktpreobuka.project_dealspot.services;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import com.iktpreobuka.project_dealspot.entities.BillEntity;
import com.iktpreobuka.project_dealspot.entities.CategoryEntity;
import com.iktpreobuka.project_dealspot.entities.OfferEntity;
import com.iktpreobuka.project_dealspot.entities.UserEntity;

public interface BillDao {

	Iterable<BillEntity> findAll();

	void save(BillEntity newBill);

	BillEntity findById(Long billId);

	void delete(BillEntity bill);

	List<BillEntity> findByUser(UserEntity buyer);

	Collection<? extends BillEntity> findByOffer(OfferEntity offer);

	List<BillEntity> findByBillCreatedBetween(LocalDate startDate, LocalDate endDate);
	
	boolean activeBillInCategory(CategoryEntity category);
	
	void cancelBillsByOfferId(Long offerId);
	
	void createVoucherFromBill(BillEntity bill);

}
