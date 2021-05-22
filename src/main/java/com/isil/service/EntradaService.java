package com.isil.service;


import com.isil.model.Entrada;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntradaService implements BaseService<Entrada, Long> {

    @Override
    public Optional<Entrada> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Entrada>> findAll() {
        return Optional.empty();
    }

    @Override
    public Entrada saveOrUpdate(Entrada entrada) {
        return null;
    }

    @Override
    public boolean deleteById(Long aLong) {
        return false;
    }
}
