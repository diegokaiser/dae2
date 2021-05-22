package com.isil.service;


import com.isil.model.Pelicula;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService implements BaseService<Pelicula, Long> {

    @Override
    public Optional<Pelicula> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Pelicula>> findAll() {
        return Optional.empty();
    }

    @Override
    public Pelicula saveOrUpdate(Pelicula pelicula) {
        return null;
    }

    @Override
    public boolean deleteById(Long aLong) {
        return false;
    }
}
