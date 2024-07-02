package com.iktpreobuka.dataaccess.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktpreobuka.dataaccess.entities.AddressEntity;
import com.iktpreobuka.dataaccess.repositories.AddressRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Service
public class AddressDaoImpl implements AddressDao {

	@PersistenceContext
	EntityManager em;

	@Autowired
	private AddressRepository addressRepository;

	@SuppressWarnings("unchecked")
	@Override
	public List<AddressEntity> findAddressesByUserName(String name) {

		//String sql = "select * from userentity u join addressentity a on u.address = a.address where u.name";

		String sql = "select a from AddressEntity a left join fetch a.users u where u.name = :name";//: parametar za dole Query

		Query query = em.createQuery(sql);
		query.setParameter("name", name);

		List<AddressEntity> result = new ArrayList<>();
		result = query.getResultList();

		return result;
	}

	@Override
	@Transactional
	public void save(AddressEntity address) {
		addressRepository.save(address);
	}

	@Override
	public AddressEntity findById(Long id) {
		return addressRepository.findById(id).orElse(null);
	}

	@Override
	public List<AddressEntity> findByCountryOrderByCountryAsc(String country) {
		return addressRepository.findByCountryOrderByCountryAsc(country);
	}

	@Override
	public List<AddressEntity> findByCity(String city) {
		return addressRepository.findByCity(city);
	}

	@Override
	@Transactional
	public void delete(AddressEntity address) {
		addressRepository.delete(address);
	}

	@Override
	public Iterable<AddressEntity> findAll() {
		return addressRepository.findAll();
	}

}