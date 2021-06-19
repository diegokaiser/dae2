package com.isil.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.isil.model.Usuario;
import com.isil.repository.UsuarioRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CineUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;


    public UserDetails loadUserByUsername(String correo, String contrasena) throws UsernameNotFoundException {

        Optional<Usuario> currentUsuario = usuarioRepository.findByCorreoAndContrasena(correo, contrasena);
        if(currentUsuario == null){
            throw new UsernameNotFoundException(correo);
        }

        Set<GrantedAuthority> ga = new HashSet<>();
        ga.add(new SimpleGrantedAuthority("Admin"));

        return new org.springframework.security.core.userdetails.User(currentUsuario.get().getCorreo(), currentUsuario.get().getContrasena(), ga);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
