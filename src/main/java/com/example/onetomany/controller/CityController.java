package com.example.onetomany.controller;

import com.example.onetomany.exception.ResourceDoseNotExistException;
import com.example.onetomany.model.City;
import com.example.onetomany.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "city")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public List<City> getCities(){
        return cityService.getCities();
    }
    @GetMapping("/{id}")
    public City getCity(@PathVariable long id) throws ResourceDoseNotExistException {
        return cityService.getCity(id);
    }
    @PostMapping
    public City addCity(@RequestBody City city){
        return cityService.addCity(city);
    }
    @PutMapping("/{id}")
    public City addCity(@PathVariable long id,@RequestBody City city){
        return cityService.updateCity(id,city);
    }
    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable long id){
        cityService.deleteCity(id);
    }
}
