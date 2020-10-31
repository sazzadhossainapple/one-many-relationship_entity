package com.example.onetomany.service;

import com.example.onetomany.exception.ResourceDoseNotExistException;
import com.example.onetomany.model.City;
import com.example.onetomany.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;
    public List<City> getCities(){
        return cityRepository.findAll();
    }
    public City getCity(long id) throws ResourceDoseNotExistException {
        Optional<City> city = cityRepository.findById( id);
        if(!city.isPresent())
            throw new ResourceDoseNotExistException("City not found!");
        return city.get();
    }
    public City addCity(City city){
        return cityRepository.save(city);
    }
    public City updateCity(long id,City city){
        city.setCityId( id);
        return cityRepository.save(city);
    }
    public void deleteCity(long id){
        cityRepository.deleteById(id);
    }
}
