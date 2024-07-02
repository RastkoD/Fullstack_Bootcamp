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

import com.iktpreobuka.dataaccess.entities.CityEntity;
import com.iktpreobuka.dataaccess.repositories.CityRepository;

@RestController
@RequestMapping("/api/v1/cities")
public class CityController {
    @Autowired
    private CityRepository cityRepository;

    @GetMapping
    public Iterable<CityEntity> getAllCities() {
        return cityRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityEntity> getCityById(@PathVariable Integer id) {
        Optional<CityEntity> city = cityRepository.findById(id);
        return city.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CityEntity createCity(@RequestBody CityEntity newCity) {
        return cityRepository.save(newCity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CityEntity> updateCity(@PathVariable Integer id, @RequestBody CityEntity updatedCity) {
        if (cityRepository.existsById(id)) {
            updatedCity.setId(id);
            return ResponseEntity.ok(cityRepository.save(updatedCity));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable Integer id) {
        if (cityRepository.existsById(id)) {
            cityRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}*/
