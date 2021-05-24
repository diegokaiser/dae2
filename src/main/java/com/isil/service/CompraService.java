package com.isil.service;


import com.isil.model.Compra;
import com.isil.repository.CompraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService implements BaseService<Compra, Long> {

    private final CompraRepository compraRepository;

    public CompraService(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    @Override
    public Optional<Compra> findById(Long id) {
        return compraRepository.findById(id);
    }

    @Override
    public Optional<List<Compra>> findAll() {
        return Optional.of(compraRepository.findAll());
    }

    @Override
    public Compra saveOrUpdate(Compra compra) {
        return compraRepository.save(compra);
    }

    @Override
    public boolean deleteById(Long id) {
        return findById(id)
                .map(compra -> {
                    compraRepository.delete(compra);
                    return true;
                }).orElse(false);
    }
}
