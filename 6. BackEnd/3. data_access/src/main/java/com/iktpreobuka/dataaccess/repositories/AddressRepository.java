package com.iktpreobuka.dataaccess.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.dataaccess.entities.AddressEntity;

public interface AddressRepository extends CrudRepository<AddressEntity, Long> {

	List<AddressEntity> findByCity(String city);

	List<AddressEntity> findByCountryOrderByCountryAsc(String country);

	AddressEntity findByStreetAndCityAndCountry(String street, String city, String country);
}