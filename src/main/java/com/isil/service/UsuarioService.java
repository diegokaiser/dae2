package com.isil.service;

import com.isil.model.Usuario;
import com.isil.repository.UsuarioRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Configuration
public class UsuarioService implements BaseService<Usuario, Long> {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
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
        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));//setea la contra encriptada
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


   public boolean estadoUsuario(Long id,Integer estado){
       return findById(id).map(
               usuario -> {
                   usuario.setEstado(estado);
                   saveOrUpdate(usuario);
                   return true;
               }).orElse(false);
   }





}
