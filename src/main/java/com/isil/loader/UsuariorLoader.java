package com.isil.loader;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.isil.model.Usuario;
import com.isil.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class UsuariorLoader implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        /*List<Usuario> usuario = new ArrayList<>(
                Arrays.asList(
                        new Usuario(null, "Fiorella", "Rey", "fiorella.rey@gmail.com","123456", 1, "789456123", 1, 1,null, null , passwordEncoder.encode("123456")),
                        new Usuario(null, "Josue", "Flores", "josue.flores@gmail.com","123456", 1, "789456123", 1, 1,null, null , passwordEncoder.encode("123456")),
                        new Usuario(null, "Diego", "Caceres", "diego.caceres@gmail.com","123456", 1, "789456123", 1, 1,null, null , passwordEncoder.encode("123456"))
                )
        );

        usuarioRepository.saveAll(usuario);*/
    }
}
