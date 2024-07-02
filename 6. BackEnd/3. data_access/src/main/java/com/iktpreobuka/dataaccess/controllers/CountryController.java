/*package com.iktpreobuka.dataaccess.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.dataaccess.entities.CountryEntity;
import com.iktpreobuka.dataaccess.repositories.CountryRepository;

@RestController
@RequestMapping("/api/v1/countries")
public class CountryController {
	
	@Autowired
	private CountryRepository countryRepository;

	 @GetMapping
	    public Iterable<CountryEntity> getAllCountries() {
	        return countryRepository.findAll();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<CountryEntity> getCountryById(@PathVariable Integer id) {
	        Optional<CountryEntity> country = countryRepository.findById(id);
	        return country.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public CountryEntity createCountry(@RequestBody CountryEntity newCountry) {
	        return countryRepository.save(newCountry);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<CountryEntity> updateCountry(@PathVariable Integer id, @RequestBody CountryEntity updatedCountry) {
	        if (countryRepository.existsById(id)) {
	            updatedCountry.setId(id);
	            return ResponseEntity.ok(countryRepository.save(updatedCountry));
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteCountry(@PathVariable Integer id) {
	        if (countryRepository.existsById(id)) {
	            countryRepository.deleteById(id);
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
}*/
