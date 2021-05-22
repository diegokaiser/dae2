package com.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.isil.model.Usuario;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


}
