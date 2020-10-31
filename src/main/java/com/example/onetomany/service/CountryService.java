package com.example.onetomany.service;

import com.example.onetomany.exception.ResourceDoseNotExistException;
import com.example.onetomany.model.Country;
import com.example.onetomany.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getCountries(){
        return countryRepository.findAll();
    }
    public Country getCountry(long id) throws ResourceDoseNotExistException {
        Optional<Country> country = countryRepository.findById(id);
        if(!country.isPresent())
            throw new ResourceDoseNotExistException("Country not found!");
        return country.get();
    }
    public Country addCountry(Country country){
        return countryRepository.save(country);
    }
    public Country updateCountry(long id,Country country){
        country.setCountryId(id);
        return countryRepository.save(country);
    }
    public void deleteCountry(long id){
        countryRepository.deleteById(id);
    }
}
