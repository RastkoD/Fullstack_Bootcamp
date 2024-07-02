package com.iktpreobuka.dataaccess.services;

import java.util.Date;
import java.util.List;

import com.iktpreobuka.dataaccess.entities.UserEntity;

public interface UserDao {

	List<UserEntity> getUsersByEmail(String email);

	List<UserEntity> getUsersByNameOrderByEmailAsc(String name);

	List<UserEntity> getUsersByDateOfBirthOrderByNameAsc(Date dateOfBirth);

	List<UserEntity> getDistinctUsersByFirstLetterOfName(char firstLetter);

	List<UserEntity> getUsersByPhoneNumber(String phoneNumber);

	List<UserEntity> getUsersByAddress(String street, String city, String country);

	void addUserAddress(Long userId, Long addressId);

	void removeUserAddress(Long userId);

	UserEntity addNewUser(UserEntity newUser);

	UserEntity modifyUser(Long id, UserEntity modifiedUser);

	UserEntity deleteUser(Long id);

	UserEntity addAddressToAUser(Long id, Long addressId);

	UserEntity removeAddressFromUser(Long id);

	UserEntity addUserWithAddress(String name, String email, Date dateOfBirth, String phoneNumber, String jmbg,
			String idCardNumber, String street, String city, String country);

	Iterable<UserEntity> findAll();

	UserEntity findById(Long id);

	void save(UserEntity user);

}