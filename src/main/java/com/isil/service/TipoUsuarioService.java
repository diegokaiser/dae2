package com.isil.service;


import com.isil.model.TipoUsuario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoUsuarioService implements BaseService<TipoUsuario, Long> {

    @Override
    public Optional<TipoUsuario> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Optional<List<TipoUsuario>> findAll() {
        return Optional.empty();
    }

    @Override
    public TipoUsuario saveOrUpdate(TipoUsuario tipoUsuario) {
        return null;
    }

    @Override
    public boolean deleteById(Long aLong) {
        return false;
    }
}
