package com.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.isil.model.Usuario;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByCorreo(String correo);

    @Modifying
    @Query("update Usuario u set u.estado = :estado where u.id = :idUsuario")
    int editarUsuarioooo(@Param("estado") Long estado,
                                   @Param("idUsuario") Long idUsuario);
    @Modifying
    @Query("update Usuario u set u.estado = 0 where u.id = :id")
    int estadoUsuario(@Param("id") Long id);

}
