package com.iktpreobuka.project_dealspot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.project_dealspot.entities.UserEntity;
import com.iktpreobuka.project_dealspot.repositories.UserRepository;

@RestController
@RequestMapping(value = "/dealspot/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	/* 1.3 kreirati REST endpoint koji vraća listu korisnika
		aplikacije */

	@GetMapping
	public Iterable<UserEntity> getAllUsers() {
	    return userRepository.findAll();
	}

	/* kreirati REST endpoint koji vraća korisnika po
		vrednosti prosleđenog ID-a */

	@GetMapping("/{userId}")
	public UserEntity getById(@PathVariable Long userId) {

		return userRepository.findById(userId).orElse(null);
	}

	/* 1.5 kreirati REST endpoint koji omogućava dodavanje
		novog korisnika */

	@PostMapping
	public UserEntity addUser(@RequestBody UserEntity newUser) {

		newUser.setUserRole(UserEntity.UserRole.ROLE_CUSTOMER);

		return userRepository.save(newUser);
	}

	/* 1.6 kreirati REST endpoint koji omogućava izmenu
		postojećeg korisnika */

	@PutMapping("/{userId}")
    public UserEntity modifyUser(@PathVariable Long userId, @RequestBody UserEntity modifiedUser) {
        return userRepository.findById(userId).map(user -> {
                    user.setFirstName(modifiedUser.getFirstName());
                    user.setLastName(modifiedUser.getLastName());
                    user.setUsername(modifiedUser.getUsername());
                    user.setEmail(modifiedUser.getEmail());
                    return userRepository.save(user);
                }).orElse(null);
    }

	/* 1.7 kreirati REST endpoint koji omogućava izmenu
		atributa user_role postojećeg korisnika */

	@PutMapping("/change/{userId}/role/{role}")
	public UserEntity updateUserRole(@PathVariable Long userId, @PathVariable String newRole) {

		return userRepository.findById(userId).map(user -> {
					user.setUserRole(UserEntity.UserRole.valueOf(newRole));
					return userRepository.save(user);
				}).orElse(null);
	}

	/* 1.8 kreirati REST endpoint koji omogućava izmenu
		vrednosti atributa password postojećeg korisnika */ 

	@PutMapping("/changePassword/{userId}")
	public UserEntity changePassword(@PathVariable Long id,
			@RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword") String newPassword) {

		return userRepository.findById(id).map(user -> {
			if(user.getPassword().equals(oldPassword) && !user.getPassword().equals(newPassword)) {
				user.setPassword(newPassword);
				return userRepository.save(user);
			}
			return null;
		}).orElse(null);

	}

	/* 1.9 kreirati REST endpoint koji omogućava brisanje
		postojećeg korisnika */

	 @DeleteMapping("/{userId}")
	    public UserEntity deleteUser(@PathVariable Long userId) {
	        return userRepository.findById(userId).map(user -> {
	                    userRepository.delete(user);
	                    return user;
	                }).orElse(null);
	    }

	/* 1.10 kreirati REST endpoint koji vraća korisnika po
		vrednosti prosleđenog username-a */

	 @GetMapping("/by-username/{username}")
	    public UserEntity getByUsername(@PathVariable String username) {
	        return userRepository.findByUsername(username);
	    }
}



