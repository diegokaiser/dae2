package com.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.isil.model.UsuarioEntrada;

@Repository
public interface UsuarioEntradaRepository extends JpaRepository<UsuarioEntrada, Long> {
}
