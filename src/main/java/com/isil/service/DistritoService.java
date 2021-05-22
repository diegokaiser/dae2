package com.isil.service;


import com.isil.model.Distrito;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistritoService implements BaseService<Distrito, Long> {

    @Override
    public Optional<Distrito> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Distrito>> findAll() {
        return Optional.empty();
    }

    @Override
    public Distrito saveOrUpdate(Distrito distrito) {
        return null;
    }

    @Override
    public boolean deleteById(Long aLong) {
        return false;
    }
}
