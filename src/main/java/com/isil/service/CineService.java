package com.isil.service;


import com.isil.model.Cine;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CineService implements BaseService<Cine, Long> {

    @Override
    public Optional<Cine> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Cine>> findAll() {
        return Optional.empty();
    }

    @Override
    public Cine saveOrUpdate(Cine cine) {
        return null;
    }

    @Override
    public boolean deleteById(Long aLong) {
        return false;
    }
}
