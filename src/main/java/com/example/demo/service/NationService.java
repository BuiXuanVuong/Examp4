package com.example.demo.service;

;
import com.example.demo.model.Nation;

public interface NationService {

    Iterable<Nation> findAll();

    Nation findById(Long id);

    void save(Nation nation);

    void remove(Long id);
}
