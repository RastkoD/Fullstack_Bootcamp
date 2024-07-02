package com.iktpreobuka.dataaccess.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.dataaccess.entities.AddressEntity;
import com.iktpreobuka.dataaccess.entities.UserEntity;
import com.iktpreobuka.dataaccess.services.AddressDao;
import com.iktpreobuka.dataaccess.services.UserDao;

@RestController
@RequestMapping(path = "/api/v1/addresses")
public class AddressController {

	@Autowired
	private AddressDao addressDao;

	@Autowired
	private UserDao userDao;

	@RequestMapping(method = RequestMethod.GET, value = "/user/{username}")
	public List<AddressEntity> findAddressesByName(@PathVariable String username) {
		return addressDao.findAddressesByUserName(username);
	}

	@RequestMapping(method = RequestMethod.POST)
	public AddressEntity addNewAddress(@RequestParam String street, @RequestParam String city,
			@RequestParam String country) {
		AddressEntity address = new AddressEntity();
		address.setStreet(street);
		address.setCity(city);
		address.setCountry(country);
		addressDao.save(address);
		return address;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<AddressEntity> getAllAddresses() {
		return addressDao.findAll();
	}

	/* vracanje adrese po id */

	@GetMapping("/{id}")
	public AddressEntity getAddressById(@PathVariable Long id) {
		return addressDao.findById(id);
	}

	/* azuriranje adrese */

	@PutMapping("/{id}")
	public AddressEntity modifyAddress(@PathVariable Long id,
			@RequestBody AddressEntity modifiedAddress) {
		AddressEntity address = addressDao.findById(id);

		if (address != null) {
			address.setStreet(modifiedAddress.getStreet());
			address.setCity(modifiedAddress.getCity());
			address.setCountry(modifiedAddress.getCountry());
			addressDao.save(address);
			return address;
		}

		return null;
	}

	/* brisanje adrese */

	@DeleteMapping("/{id}")
	public AddressEntity deleteAddress(@PathVariable Long id) {
		AddressEntity address = addressDao.findById(id);

		if (address != null) {
			addressDao.delete(address);
			return address;
		}

		return null;
	}

	/* pronalaženje adrese po gradu */

	@GetMapping("/by-city")
	public List<AddressEntity> getAddressesByCity(@RequestParam String city) {
		return addressDao.findByCity(city);
	}

	/* omogućiti pronalaženje adrese po državi */

	@GetMapping("/by-country")
	public List<AddressEntity> getAddressesByCountry(@RequestParam String country) {
		return addressDao.findByCountryOrderByCountryAsc(country);
	}

	/* dodavanje korisnika u adresama */

	@PutMapping("/{addressid}/user/{userid}")
	public AddressEntity addUserToAddress(@PathVariable Long addressid,
			@PathVariable Long userid) {
		AddressEntity address = addressDao.findById(addressid);
		UserEntity user = userDao.findById(userid);

		if (address != null && user != null) {
			address.getUsers().add(user);
			addressDao.save(address);/*probaj obrisati addressDao i address.getusers*/
			user.setAddress(address);
			userDao.save(user);
			return address;
		}

		return null;
	}

	/* brisanje korisnika u adresama */

	@DeleteMapping("/{addressid}/user/{userid}")
	public AddressEntity removeUserFromAddress(@PathVariable Long addressid,
			@PathVariable Long userid) {
		AddressEntity address = addressDao.findById(addressid);
		UserEntity user = userDao.findById(userid);

		if (address != null && user != null) {
			address.getUsers().remove(user);
			addressDao.save(address);/*probaj obrisati addressDao i address.getusers*/
			user.setAddress(null);
			userDao.save(user);
			return address;
		}

		return null;
	}
/*
	Uraditi sledeće stavke:
		• 3.1* državu i grad izdvojiti kao posebne entitete i povezati sa
		adresom
		• jedna adresa pripada tačno jednom gradu
		• jedan grad može imati više adresa
		• jedan grad pripada tačno jednoj državi
		• jedna država može imati više gradova
		• 3.2* za svaki od entiteta napraviti REST kontrolere
		• koji podržavaju standardne CRUD operacije*/
}