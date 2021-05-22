package com.isil.service;


import com.isil.model.Cine;
import java.util.List;

public interface CineService {

    void create(Cine cine);
    Cine read(String idCine);
    void update(Cine cine);
    void delete(String idCine);

    List<Cine> all();
}
