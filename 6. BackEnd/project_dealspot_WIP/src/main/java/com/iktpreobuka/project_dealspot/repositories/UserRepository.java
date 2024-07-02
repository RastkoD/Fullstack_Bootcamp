package com.iktpreobuka.project_dealspot.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.project_dealspot.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

	UserEntity findByUsername(String username);
}
