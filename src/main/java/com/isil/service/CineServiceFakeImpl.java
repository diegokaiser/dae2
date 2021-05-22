
package com.isil.service;

import com.isil.model.Cine;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("cineServiceFake")
public class CineServiceFakeImpl implements CineService {

    List<Cine> cines = new ArrayList<>(
            Arrays.asList(
                    new Cine(1, "Cine Planet", "Av. La Marina 123", "cine-planet.jpg", 3, 1, "", "", ""),
                    new Cine(2, "Cine Planet", "Av. Las Palmeras 123", "cine-planet.jpg", 3, 1, "", "", "")
            )
    );

    @Override
    public void create(Cine cine) {
        cines.add(cine);
    }

    @Override
    public Cine read(String idCine) {
        return cines.stream()
                .filter(s -> idCine.equals(s.getIdCine()))
                .findFirst()
                .orElseGet(null);
    }

    @Override
    public void update(Cine cine) {
        Cine currentStudent = read(cine.getIdCine().toString());
        if (currentStudent != null){
            int index = cines.indexOf(currentStudent);
            cines.set(index, cine);
        }
    }

    @Override
    public void delete(String documentNumber) {
        Cine currentStudent = read(documentNumber);
        cines.remove(currentStudent);
    }

    @Override
    public List<Cine> all() {
        return cines;
    }
}