package com.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.isil.model.Entrada;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Long> {
}
