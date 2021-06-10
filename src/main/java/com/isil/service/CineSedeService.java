package com.isil.service;

import com.isil.model.Cine;
import com.isil.model.CineSede;
import com.isil.repository.CineSedeRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CineSedeService implements BaseService<CineSede, Long> {


    private final CineSedeRepository cineSedeRepository;

    public CineSedeService(CineSedeRepository cineSedeRepository) {
        this.cineSedeRepository = cineSedeRepository;
    }


    @Override
    public Optional<CineSede> findById(Long id) {
        return cineSedeRepository.findById(id);
    }

    @Override
    public Optional<List<CineSede>> findAll() {
        return Optional.of(cineSedeRepository.findAll());
    }

/*    public Optional<List<CineSede>> findAllById(Integer cineSede) {

        return Optional.of(cineSedeRepository.findAll(cineSede));
    }*/


    @Override
    public CineSede saveOrUpdate(CineSede cineSedeSede) {
        return cineSedeRepository.save(cineSedeSede);
    }

    @Override
    public boolean deleteById(Long id) {
        return findById(id)
                .map(cineSedeSede -> {
                    cineSedeRepository.delete(cineSedeSede);
                    return true;
                }).orElse(false);
    }
    public List <CineSede> findAllByidCine(Integer id) {
        return  cineSedeRepository.findByIdCine(id);
    }

    public boolean estadoCineSede(Long id,Integer estado){
        return findById(id).map(
                cineSede -> {
                    cineSede.setEstado(estado);
                    saveOrUpdate(cineSede);
                    return true;
                }).orElse(false);
    }

}
