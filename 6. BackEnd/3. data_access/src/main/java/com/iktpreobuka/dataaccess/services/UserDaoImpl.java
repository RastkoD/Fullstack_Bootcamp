package com.iktpreobuka.dataaccess.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktpreobuka.dataaccess.entities.AddressEntity;
import com.iktpreobuka.dataaccess.entities.UserEntity;
import com.iktpreobuka.dataaccess.repositories.AddressRepository;
import com.iktpreobuka.dataaccess.repositories.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Service
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager em;

	/* pronalazak repo se vrsi auto, ako ga nema da se 
	instancira i podese parametri i bude spreman za koriscenje*/
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public List<UserEntity> getUsersByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public List<UserEntity> getUsersByNameOrderByEmailAsc(String name) {
		return userRepository.findByNameOrderByEmailAsc(name);
	}

	@Override
	public List<UserEntity> getUsersByDateOfBirthOrderByNameAsc(Date dateOfBirth) {
		return userRepository.findByDateOfBirthOrderByNameAsc(dateOfBirth);
	}

	@Override
	public List<UserEntity> getDistinctUsersByFirstLetterOfName(char firstLetter) {
		return userRepository.findDistinctByNameStartingWithIgnoreCase(firstLetter);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> getUsersByPhoneNumber(String phoneNumber) {
		String sql = "SELECT u FROM UserEntity u WHERE u.phoneNumber = :phoneNumber";
		Query query = em.createQuery(sql);
		query.setParameter("phoneNumber", phoneNumber);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> getUsersByAddress(String street, String city, String country) {
		String sql = "SELECT u FROM UserEntity u WHERE u.address.street = :street AND u.address.city = :city AND u.address.country = :country";
		Query query = em.createQuery(sql);
		query.setParameter("street", street);
		query.setParameter("city", city);
		query.setParameter("country", country);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void addUserAddress(Long userId, Long addressId) {
		UserEntity user = userRepository.findById(userId).orElse(null);
		if (user != null) {
			user.setAddress(addressRepository.findById(addressId).orElse(null));
			userRepository.save(user);
		}
	}

	@Override
	@Transactional
	public void removeUserAddress(Long userId) {
		UserEntity user = userRepository.findById(userId).orElse(null);
		if (user != null) {
			user.setAddress(null);
			userRepository.save(user);
		}
	}

	@Override
	public UserEntity addNewUser(UserEntity newUser) {
		return userRepository.save(newUser);
	}

	@Override
	public UserEntity modifyUser(Long id, UserEntity modifiedUser) {
		UserEntity user = userRepository.findById(id).orElse(null);
		if (user != null) {
			user.setName(modifiedUser.getName());
			user.setEmail(modifiedUser.getEmail());
			user.setDateOfBirth(modifiedUser.getDateOfBirth());
			user.setPhoneNumber(modifiedUser.getPhoneNumber());
			user.setJmbg(modifiedUser.getJmbg());
			user.setIdCardNumber(modifiedUser.getIdCardNumber());
			userRepository.save(user);
		}
		return user;
	}

	@Override
	public UserEntity deleteUser(Long id) {
		UserEntity user = userRepository.findById(id).orElse(null);
		if (user != null) {
			userRepository.delete(user);
		}
		return user;
	}

	@Override
	@Transactional
	public UserEntity addAddressToAUser(Long id, Long addressId) {
		UserEntity user = userRepository.findById(id).orElse(null);
		if (user != null) {
			user.setAddress(addressRepository.findById(addressId).orElse(null));
			userRepository.save(user);
		}
		return user;
	}

	@Override
	@Transactional
	public UserEntity removeAddressFromUser(Long id) {
		UserEntity user = userRepository.findById(id).orElse(null);
		if (user != null) {
			user.setAddress(null);
			userRepository.save(user);
		}
		return user;
	}

	@Override
	@Transactional
	public UserEntity addUserWithAddress(String name, String email, Date dateOfBirth, String phoneNumber, String jmbg,
			String idCardNumber, String street, String city, String country) {
		UserEntity user = new UserEntity();
		user.setName(name);
		user.setEmail(email);
		user.setDateOfBirth(dateOfBirth);
		user.setPhoneNumber(phoneNumber);
		user.setJmbg(jmbg);
		user.setIdCardNumber(idCardNumber);

		user.setAddress(addressRepository.findByStreetAndCityAndCountry(street, city, country));
		if (user.getAddress() == null) {
			AddressEntity address = new AddressEntity();
			address.setStreet(street);
			address.setCity(city);
			address.setCountry(country);
			addressRepository.save(address);
			user.setAddress(address);
		}

		return userRepository.save(user);
	}

	@Override
	public Iterable<UserEntity> findAll() {
		return userRepository.findAll();
	}

	@Override
	public UserEntity findById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public void save(UserEntity user) {
		userRepository.save(user);

	}
}