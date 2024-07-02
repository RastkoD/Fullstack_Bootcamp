package com.iktpreobuka.dataaccess.services;

import java.util.List;

import com.iktpreobuka.dataaccess.entities.AddressEntity;


public interface AddressDao {

	List<AddressEntity> findAddressesByUserName(String username);

	void save(AddressEntity address);

	AddressEntity findById(Long id);

	List<AddressEntity> findByCountryOrderByCountryAsc(String country);

	List<AddressEntity> findByCity(String city);

	void delete(AddressEntity address);

	Iterable<AddressEntity> findAll();
}