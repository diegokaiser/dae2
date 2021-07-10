package com.isil.service;

import com.isil.model.Usuario;
import com.isil.repository.UsuarioRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Getter
@RequiredArgsConstructor
public class IsilUserDetailsService implements UserDetailsService {
    private Integer tipoUsuario=0;
    private String correo="";
    private final UsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {

        Usuario currentUser = usuarioRepository.findByCorreo(correo);
        if(currentUser == null){
            throw new UsernameNotFoundException(correo);
        }
        System.out.println(currentUser.getIdTipoUsuario());
        tipoUsuario=currentUser.getIdTipoUsuario();
        this.correo=currentUser.getCorreo();
        System.out.println(tipoUsuario+"addadas");
        System.out.println(correo);
        Set<GrantedAuthority> ga = new HashSet<>();
        ga.add(new SimpleGrantedAuthority("Admin"));

        return new org.springframework.security.core.userdetails.User(currentUser.getCorreo(), currentUser.getContrasena(), ga);
    }

}
