package com.example.onetomany.controller;

import com.example.onetomany.exception.ResourceDoseNotExistException;
import com.example.onetomany.model.Country;
import com.example.onetomany.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<Country> getCountries(){
        return countryService.getCountries();
    }
    @GetMapping("/{id}")
    public Country getCountry(@PathVariable long id) throws ResourceDoseNotExistException {
        return countryService.getCountry(id);
    }
    @PostMapping
    public Country addCountry(@RequestBody Country country){
        return countryService.addCountry(country);
    }
    @PutMapping("/{id}")
    public Country addCountry(@PathVariable long id,@RequestBody Country country){
        return countryService.updateCountry(id,country);
    }
    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable long id){
        countryService.deleteCountry(id);
    }
}
