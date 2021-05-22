package com.isil.service;


import com.isil.model.Compra;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService implements BaseService<Compra, Long> {

    @Override
    public Optional<Compra> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Compra>> findAll() {
        return Optional.empty();
    }

    @Override
    public Compra saveOrUpdate(Compra compra) {
        return null;
    }

    @Override
    public boolean deleteById(Long aLong) {
        return false;
    }
}
