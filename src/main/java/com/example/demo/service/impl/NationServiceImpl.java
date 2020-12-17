package com.example.demo.service.impl;

import com.example.demo.model.City;
import com.example.demo.model.Nation;
import com.example.demo.repository.NationRepository;
import com.example.demo.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;

public class NationServiceImpl implements NationService {

    @Autowired
    NationRepository nationRepository;

    @Override
    public Iterable<Nation> findAll() {
        return nationRepository.findAll();
    }

    @Override
    public Nation findById(Long id) {
        return nationRepository.findOneById(id);
    }

    @Override
    public void save(Nation nation) {
        nationRepository.save(nation);
    }

    @Override
    public void remove(Long id) {
        nationRepository.deleteById(id);
    }
}
