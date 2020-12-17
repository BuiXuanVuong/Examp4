package com.example.demo.service;

import com.example.demo.model.City;

public interface CityService {

    Iterable<City> findAll();

    City findById(Long id);

    void save(City city);

    void remove(Long id);
}
