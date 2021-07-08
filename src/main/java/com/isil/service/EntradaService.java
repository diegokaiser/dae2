package com.isil.service;


import com.isil.model.Entrada;
import com.isil.model.Pelicula;
import com.isil.repository.EntradaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntradaService implements BaseService<Entrada, Long> {

    private final EntradaRepository entradaRepository;

    public EntradaService(EntradaRepository entradaRepository) {
        this.entradaRepository = entradaRepository;
    }

    @Override
    public Optional<Entrada> findById(Long id) {
        return entradaRepository.findById(id);
    }
    public Optional <List<Entrada>> findByIdPelicula(Integer id) {
        return Optional.of(entradaRepository.findByIdPelicula(id));
    }
    @Override
    public Optional<List<Entrada>> findAll() {
        return Optional.of(entradaRepository.findAll());
    }

    @Override
    public Entrada saveOrUpdate(Entrada entrada) {
        return entradaRepository.save(entrada);
    }

    @Override
    public boolean deleteById(Long id) {
        return findById(id)
                .map(entrada -> {
                    entradaRepository.delete(entrada);
                    return true;
                }).orElse(false);
    }

    public boolean estadoEntrada(Long id,Integer estado){
        return findById(id).map(
                entrada -> {
                    entrada.setEstado(estado);
                    saveOrUpdate(entrada);
                    return true;
                }).orElse(false);
    }
}
