package com.iktpreobuka.dataaccess.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.dataaccess.entities.UserEntity;
import com.iktpreobuka.dataaccess.services.UserDao;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {

	@Autowired
	private UserDao userDao;

	/* Kreiranje usera */
	@PostMapping
	public UserEntity addNewUser(@RequestBody UserEntity newUser) {
		return userDao.addNewUser(newUser);
	}

	/* vraćanje korisnika */
	@GetMapping
	public Iterable<UserEntity> getAllUsers() {
		return userDao.findAll();
	}

	/* vraćanje korisnika po ID */
	@GetMapping("/{id}")
	public UserEntity getUserById(@PathVariable Long id) {
		return userDao.findById(id);
	}

	/* ažuriranje korisnika */

	@PutMapping("/{id}")
	public UserEntity modifyUser(@PathVariable Long id,
			@RequestBody UserEntity modifiedUser) {
		return userDao.modifyUser(id, modifiedUser);
	}

	/* brisanje korisnika */
	@DeleteMapping("/{id}")
	public UserEntity deleteUser(@PathVariable Long id) {
		return userDao.deleteUser(id);
	}

	/* omogućiti pronalaženje korisnika po email adresi */

	@GetMapping("/by-email")
	public List<UserEntity> getUsersByEmail(@RequestParam String email) {
		return userDao.getUsersByEmail(email);
	}

	/* omogućiti pronalaženje korisnika po imenu, sort po email-u */

	@GetMapping("/by-name")
	public List<UserEntity> getUsersByName(@RequestParam String name) {
		return userDao.getUsersByNameOrderByEmailAsc(name);
	}

	/* omogućiti pronalaženje korisnika po datumu rođenja sortiranih u rastućem redosledu imena */

	@GetMapping("/by-dob")
	public List<UserEntity> getUsersByDOB(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateOfBirth) {
		return userDao.getUsersByDateOfBirthOrderByNameAsc(dateOfBirth);
	}

	/* omogućiti pronalaženje različitih imena korisnika po prvom slovu imena */

	@GetMapping("/by-name-first-letter")
	public List<UserEntity> getUsersByFirstLetterOfName(@RequestParam char firstLetter) {
		return userDao.getDistinctUsersByFirstLetterOfName(firstLetter);
	}

	/* povezivanje korisnika i adrese */

	@PutMapping("/{id}/address")
	public UserEntity addAddressToAUser(@PathVariable Long id,
			@RequestParam Long addressid) {
		return userDao.addAddressToAUser(id, addressid);
		// automatski ce biti sacuvana i adresa
	}

	/* uklanjanje adrese iz entiteta korisnika */

	@DeleteMapping("/{id}/address")
	public UserEntity removeAddressFromUser(@PathVariable Long id) {
		return userDao.removeAddressFromUser(id);
	}

	/* kreiranje korisnika i adrese */

	@PostMapping("/createWithAddress")
	public UserEntity addUserWithAddress(@RequestBody UserEntity newUser) {
		return userDao.addUserWithAddress(newUser.getName(), newUser.getEmail(), newUser.getDateOfBirth(),
				newUser.getPhoneNumber(), newUser.getJmbg(), newUser.getIdCardNumber(),
				newUser.getAddress().getStreet(), newUser.getAddress().getCity(), newUser.getAddress().getCountry());
	}

}