package com.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.isil.model.Distrito;

@Repository
public interface DistritoRepository extends JpaRepository<Distrito, Long> {
}
