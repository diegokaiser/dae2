package com.isil.service;


import com.isil.model.Sala;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService implements BaseService<Sala, Long> {

    @Override
    public Optional<Sala> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Sala>> findAll() {
        return Optional.empty();
    }

    @Override
    public Sala saveOrUpdate(Sala sala) {
        return null;
    }

    @Override
    public boolean deleteById(Long aLong) {
        return false;
    }
}
