package com.isil.repository;

import com.isil.model.Usuario;
import com.isil.service.PeliculaService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.isil.model.Pelicula;

import java.util.List;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

    List <Pelicula> findByEstado(Integer estado);
}
