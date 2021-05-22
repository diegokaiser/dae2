package com.isil.service;


import com.isil.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioEntradaService implements BaseService<Usuario, Long> {

    @Override
    public Optional<Usuario> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Usuario>> findAll() {
        return Optional.empty();
    }

    @Override
    public Usuario saveOrUpdate(Usuario usuario) {
        return null;
    }

    @Override
    public boolean deleteById(Long aLong) {
        return false;
    }
}
