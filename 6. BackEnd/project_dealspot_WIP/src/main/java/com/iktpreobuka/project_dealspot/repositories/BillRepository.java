package com.iktpreobuka.project_dealspot.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.project_dealspot.entities.BillEntity;
import com.iktpreobuka.project_dealspot.entities.CategoryEntity;
import com.iktpreobuka.project_dealspot.entities.OfferEntity;
import com.iktpreobuka.project_dealspot.entities.UserEntity;

public interface BillRepository extends CrudRepository<BillEntity, Long> {

	List<BillEntity> findByUser(UserEntity buyer);

	List<BillEntity> findByBillCreatedBetween(LocalDate startDate, LocalDate endDate);

	List<BillEntity> findByOffer(OfferEntity offer);

	boolean existsByOfferCategoryAndPaymentMadeFalse(CategoryEntity category);

}
