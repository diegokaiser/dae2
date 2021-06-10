package com.isil.loader;

import com.isil.model.CineSede;
import com.isil.repository.CineSedeRepository;
import com.isil.repository.PeliculaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeliculaLoader implements CommandLineRunner {

    private final PeliculaRepository peliculaRepository;

    public PeliculaLoader(PeliculaRepository peliculaRepository, CineSedeRepository cineSedeRepository) {
        this.peliculaRepository = peliculaRepository;
        this.cineSedeRepository = cineSedeRepository;
    }

    private final CineSedeRepository cineSedeRepository;

    @Override
    public void run(String... args) throws Exception {
        // List<Pelicula> peliculas = new ArrayList<>();
        // peliculas.add(new Pelicula(null,"spiderman","1h",null,"español","eeuu",1,1,"tio","accion",1,"sisi",1,"aa",1,"thro","sisi",null,null,null));
        // peliculas.add(new Pelicula(null,"0000000001","ISIL SA",null));
        // peliculas.add(new Pelicula(null,"0000000002","Bodega Don Pepe SA",null));
        // peliculaRepository.saveAll(peliculas);
        System.out.println("hola qui toy1 ");
    /*    List<CineSede> cineSedes= new ArrayList<>();
        cineSedes=cineSedeRepository.findByIdCine(1);
        cineSedes.forEach(System.out::println);*/
/*
        List<CineSede> cinesede=cineSedeRepository.getCineSedeByEstado(1);
        System.out.println("abeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeer");

        cinesede.forEach(System.out::println);
        System.out.println("abeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeer");

        System.out.println(cineSedeRepository.getCineSedeByEstado(1));
        System.out.println("hola qui toy 2 ");*/
    }
}
