package com.isil.service;


import com.isil.model.UsuarioEntrada;
import com.isil.repository.UsuarioEntradaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioEntradaService implements BaseService<UsuarioEntrada, Long> {

    private final UsuarioEntradaRepository usuarioEntradaRepository;

    public UsuarioEntradaService(UsuarioEntradaRepository usuarioEntradaRepository) {
        this.usuarioEntradaRepository = usuarioEntradaRepository;
    }

    @Override
    public Optional<UsuarioEntrada> findById(Long id) {
        return usuarioEntradaRepository.findById(id);
    }

    @Override
    public Optional<List<UsuarioEntrada>> findAll() {
        return Optional.of(usuarioEntradaRepository.findAll());
    }

    @Override
    public UsuarioEntrada saveOrUpdate(UsuarioEntrada usuarioEntrada) {
        return usuarioEntradaRepository.save(usuarioEntrada);
    }

    @Override
    public boolean deleteById(Long id) {
        return findById(id)
                .map(usuarioEntrada -> {
                    usuarioEntradaRepository.delete(usuarioEntrada);
                    return true;
                }).orElse(false);
    }
}
