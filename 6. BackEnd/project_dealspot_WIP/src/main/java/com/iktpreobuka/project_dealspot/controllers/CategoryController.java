package com.iktpreobuka.project_dealspot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.project_dealspot.entities.CategoryEntity;
import com.iktpreobuka.project_dealspot.repositories.CategoryRepository;
import com.iktpreobuka.project_dealspot.services.BillDao;
import com.iktpreobuka.project_dealspot.services.OfferDao;

@RestController
@RequestMapping(value = "/dealspot/categories")
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
    private OfferDao offerDao;

    @Autowired
    private BillDao billDao;

	@GetMapping
    public Iterable<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }

	/* 2.4 kreirati REST endpoint koji omogućava dodavanje
		nove kategorije */

	@PostMapping
    public CategoryEntity addCategory(@RequestBody CategoryEntity newCategory) {
        return categoryRepository.save(newCategory);
    }

	/* 2.5 kreirati REST endpoint koji omogućava izmenu
		postojeće kategorije */

	@PutMapping("/{id}")
    public CategoryEntity modifyCategory(@PathVariable Long id, @RequestBody CategoryEntity modifiedCategory) {
        return categoryRepository.findById(id)
                .map(category -> {
                    category.setCategoryName(modifiedCategory.getCategoryName());
                    category.setCategoryDescription(modifiedCategory.getCategoryDescription());
                    return categoryRepository.save(category);
                })
                .orElse(null);
    }

	/* 2.6 kreirati REST endpoint koji omogućava brisanje
		postojeće kategorije */

	@DeleteMapping("/{id}")
    public CategoryEntity deleteCategory(@PathVariable Long id) {
        
		CategoryEntity category = categoryRepository.findById(id).orElse(null);
		
		if(category != null) {
			
			if(offerDao.activeOfferInCategory(category) || billDao.activeBillInCategory(category)) {
				return null;
			}
			
			categoryRepository.delete(category);
		}
		
		return null;
    }

	/* 2.7 kreirati REST endpoint koji vraća kategoriju po
		vrednosti prosleđenog ID-a */
	@GetMapping("/{id}")
    public CategoryEntity getById(@PathVariable Long id) {
        return categoryRepository.findById(id).orElse(null);
    }
	
	@GetMapping("/by-category-name/{categoryName}")
    public List<CategoryEntity> getByCategoryName(@PathVariable String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }
}
