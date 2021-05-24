package com.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.isil.model.Cine;

@Repository
public interface CineRepository extends JpaRepository<Cine, Long> {
}
