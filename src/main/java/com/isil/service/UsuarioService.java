package com.isil.service;

import com.isil.model.Usuario;
import com.isil.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements BaseService<Usuario, Long> {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Optional<List<Usuario>> findAll() {
        return Optional.of(usuarioRepository.findAll());
    }

    @Override
    public Usuario saveOrUpdate(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public boolean deleteById(Long id) {
        return findById(id)
                .map(usuario -> {
                    usuarioRepository.delete(usuario);
                    return true;
                }).orElse(false);
    }

    public Usuario findByCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    //public boolean login(Long id) {
    //    return true;
   // }

}
