package com.isil.service;


import com.isil.model.CineSede;
import com.isil.model.Sala;
import com.isil.repository.SalaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService implements BaseService<Sala, Long> {

    private final SalaRepository salaRepository;

    public SalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    @Override
    public Optional<Sala> findById(Long id) {
        return salaRepository.findById(id);
    }

    @Override
    public Optional<List<Sala>> findAll() {
        return Optional.of(salaRepository.findAll());
    }

    @Override
    public Sala saveOrUpdate(Sala sala) {
        return salaRepository.save(sala);
    }

    @Override
    public boolean deleteById(Long id) {
        return findById(id)
                .map(sala -> {
                    salaRepository.delete(sala);
                    return true;
                }).orElse(false);
    }
    public Optional <List <Sala>> findByIdCineSede(Integer id) {
        return  Optional.of(salaRepository.findByIdCineSede(id));
    }

    public boolean estadoSala(Long id,Integer estado){
        return findById(id).map(
                sala -> {
                    sala.setEstado(estado);
                    saveOrUpdate(sala);
                    return true;
                }).orElse(false);
    }
}
