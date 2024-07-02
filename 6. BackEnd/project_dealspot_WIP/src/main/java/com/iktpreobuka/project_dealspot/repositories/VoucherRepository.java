package com.iktpreobuka.project_dealspot.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.project_dealspot.entities.OfferEntity;
import com.iktpreobuka.project_dealspot.entities.UserEntity;
import com.iktpreobuka.project_dealspot.entities.VoucherEntity;

public interface VoucherRepository extends CrudRepository<VoucherEntity, Long> {

	Iterable<VoucherEntity> findAll();

	List<VoucherEntity> findByBuyer(UserEntity buyer);

	List<VoucherEntity> findByOffer(OfferEntity offer);

	List<VoucherEntity> findByExpirationDateAfter(LocalDate now);

}
