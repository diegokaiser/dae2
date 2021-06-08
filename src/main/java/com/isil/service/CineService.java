package com.isil.service;

import org.springframework.stereotype.Service;
import com.isil.model.Cine;
import com.isil.repository.CineRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CineService implements BaseService<Cine, Long> {

    private final CineRepository cineRepository;

    public CineService(CineRepository cineRepository) {
        this.cineRepository = cineRepository;
    }


    @Override
    public Optional<Cine> findById(Long id) {
        return cineRepository.findById(id);
    }

    @Override
    public Optional<List<Cine>> findAll() {
        return Optional.of(cineRepository.findAll());
    }

    @Override
    public Cine saveOrUpdate(Cine cine) {
        return cineRepository.save(cine);
    }

    @Override
    public boolean deleteById(Long id) {
        return findById(id)
                .map(cine -> {
                    cineRepository.delete(cine);
                    return true;
                }).orElse(false);
    }
}
