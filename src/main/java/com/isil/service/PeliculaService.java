package com.isil.service;


import com.isil.model.Pelicula;
import com.isil.repository.PeliculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService implements BaseService<Pelicula, Long> {

    private final PeliculaRepository peliculaRepository;

    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    @Override
    public Optional<Pelicula> findById(Long id) {
        return peliculaRepository.findById(id);
    }

    @Override
    public Optional<List<Pelicula>> findAll() {
        return Optional.of(peliculaRepository.findAll());
    }

    @Override
    public Pelicula saveOrUpdate(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    @Override
    public boolean deleteById(Long id) {
        return findById(id)
                .map(pelicula -> {
                    peliculaRepository.delete(pelicula);
                    return true;
                }).orElse(false);
    }
}
