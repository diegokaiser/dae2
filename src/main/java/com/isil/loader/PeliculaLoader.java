package com.isil.loader;

import com.isil.model.Pelicula;
import com.isil.repository.PeliculaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class PeliculaLoader implements CommandLineRunner {

    private final PeliculaRepository peliculaRepository;

    public PeliculaLoader(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        List<Pelicula> peliculas = new ArrayList<>();
        peliculas.add(new Pelicula(null,"spiderman","1h",null,"español","eeuu",1,1,"tio","accion",1,"sisi",1,"aa",1,"thro","sisi",null,null,null));
      //  peliculas.add(new Pelicula(null,"0000000001","ISIL SA",null));
     //   peliculas.add(new Pelicula(null,"0000000002","Bodega Don Pepe SA",null));


        peliculaRepository.saveAll(peliculas);
    }
}
