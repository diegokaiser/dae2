package com.isil.service;


import com.isil.model.TipoUsuario;
import com.isil.repository.TipoUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoUsuarioService implements BaseService<TipoUsuario, Long> {

    private final TipoUsuarioRepository tipoUsuarioRepository;

    public TipoUsuarioService(TipoUsuarioRepository tipoUsuarioRepository) {
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }

    @Override
    public Optional<TipoUsuario> findById(Long id) {
        return tipoUsuarioRepository.findById(id);
    }

    @Override
    public Optional<List<TipoUsuario>> findAll() {
        return Optional.of(tipoUsuarioRepository.findAll());
    }

    @Override
    public TipoUsuario saveOrUpdate(TipoUsuario tipoUsuario) {
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    @Override
    public boolean deleteById(Long id) {
        return findById(id)
                .map(tipoUsuario -> {
                    tipoUsuarioRepository.delete(tipoUsuario);
                    return true;
                }).orElse(false);
    }
}
