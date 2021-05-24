package com.isil.service;


import com.isil.model.Distrito;
import com.isil.repository.DistritoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistritoService implements BaseService<Distrito, Long> {

    private final DistritoRepository distritoRepository;

    public DistritoService(DistritoRepository distritoRepository) {
        this.distritoRepository = distritoRepository;
    }

    @Override
    public Optional<Distrito> findById(Long id) {
        return distritoRepository.findById(id);
    }

    @Override
    public Optional<List<Distrito>> findAll() {
        return Optional.of(distritoRepository.findAll());
    }

    @Override
    public Distrito saveOrUpdate(Distrito distrito) {
        return distritoRepository.save(distrito);
    }

    @Override
    public boolean deleteById(Long id) {
        return findById(id)
                .map(distrito -> {
                    distritoRepository.delete(distrito);
                    return true;
                }).orElse(false);
    }
}
