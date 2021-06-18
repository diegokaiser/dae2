package com.isil.repository;


import com.isil.model.Cine;
import com.isil.model.CineSede;
import com.isil.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface CineSedeRepository extends JpaRepository<CineSede, Long> {

/*    @Query("SELECT u FROM CineSede u WHERE u.idCine IN :idCine")
    List<CineSede> findAllByidCine(
            @Param("idCine") Integer idCine);*/

    @Transactional(readOnly =true)// para que solo lea y no modifique
       List<CineSede> findByIdCine(Integer idCine);


    @Transactional(readOnly =true)// para que solo lea y no modifique
    List<CineSede> findByIdCineSede(Long idCineSede);


}

