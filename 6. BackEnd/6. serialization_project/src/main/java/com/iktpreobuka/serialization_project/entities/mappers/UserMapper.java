package com.iktpreobuka.serialization_project.entities.mappers;

import org.springframework.stereotype.Component;

import com.iktpreobuka.serialization_project.entities.UserEntity;
import com.iktpreobuka.serialization_project.entities.dto.UserRegisterDTO;

@Component
public class UserMapper {
	/* entities-userDTO */
	public UserEntity toEntity(UserRegisterDTO dto) {
		if(dto == null) {
			return null;
		}
		
		UserEntity entity = new UserEntity();
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		 
		
		return entity;
	}
	
	public UserRegisterDTO toDto(UserEntity entity) {
		if(entity == null) {
			return null;
		}
		
		UserRegisterDTO dto = new UserRegisterDTO();
		dto.setName(entity.getName());
		dto.setEmail(entity.getEmail());
		
		
		return dto;
	}
	
	/* onda ubacuje u userController */
}
