package com.iktpreobuka.validation_example.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.validation_example.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

}
