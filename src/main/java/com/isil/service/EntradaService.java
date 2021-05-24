package com.isil.service;


import com.isil.model.Entrada;
import com.isil.repository.EntradaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntradaService implements BaseService<Entrada, Long> {

    private final EntradaRepository entradaRepository;

    public EntradaService(EntradaRepository entradaRepository) {
        this.entradaRepository = entradaRepository;
    }

    @Override
    public Optional<Entrada> findById(Long id) {
        return entradaRepository.findById(id);
    }

    @Override
    public Optional<List<Entrada>> findAll() {
        return Optional.of(entradaRepository.findAll());
    }

    @Override
    public Entrada saveOrUpdate(Entrada entrada) {
        return entradaRepository.save(entrada);
    }

    @Override
    public boolean deleteById(Long id) {
        return findById(id)
                .map(entrada -> {
                    entradaRepository.delete(entrada);
                    return true;
                }).orElse(false);
    }
}
