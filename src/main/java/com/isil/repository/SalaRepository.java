package com.isil.repository;

import com.isil.model.CineSede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.isil.model.Sala;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {
    @Transactional(readOnly =true)// para que solo lea y no modifique
    List<Sala> findByIdCineSede(Integer idCine);

}
