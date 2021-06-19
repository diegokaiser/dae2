package com.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.isil.model.Usuario;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Transactional(readOnly =true)// para que solo lea y no modifique
    Optional<Usuario> findByCorreoAndContrasena(String correo, String contrasena);
    //Usuario findByCorreo(String correo);
}
