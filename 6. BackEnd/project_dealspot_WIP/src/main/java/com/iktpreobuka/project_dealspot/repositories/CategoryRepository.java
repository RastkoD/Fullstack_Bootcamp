package com.iktpreobuka.project_dealspot.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.project_dealspot.entities.CategoryEntity;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {
	
	List<CategoryEntity> findByCategoryName(String categoryName);
}
