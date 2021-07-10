package com.isil.repository;

import com.isil.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.isil.model.Entrada;

import java.util.List;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Long> {

    List<Entrada> findByIdPelicula(int idPelicula);
}
