package com.isil.resource;

import com.isil.model.Pelicula;
import com.isil.service.PeliculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PeliculaResource {

    private final PeliculaService peliculaService;

    public PeliculaResource(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }


    @GetMapping("/peliculas")
    public ResponseEntity<List<Pelicula>> getAll() {
        return peliculaService.findAll()
                .map(peliculas -> peliculas.isEmpty() ? new ResponseEntity(HttpStatus.NO_CONTENT)
                        : new ResponseEntity(peliculas, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/peliculas/{id}")
    public ResponseEntity<Pelicula> getPelicula(@PathVariable int id) {
        return peliculaService.findById((long) id)
                .map(pelicula -> new ResponseEntity<>(pelicula, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/peliculas")
    public ResponseEntity<Pelicula> save(@RequestBody Pelicula user) {
        return new ResponseEntity<>(peliculaService.saveOrUpdate(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/deletePelicula/{id}")
    public ResponseEntity delete(@PathVariable int id) {

        if (peliculaService.deleteById((long) id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/peliculas/estado/{estado}")
    public ResponseEntity<List<Pelicula>> getByEstado(@PathVariable int estado) {
        return peliculaService.findAllByEstado(estado)
                .map(peliculas -> peliculas.isEmpty() ? new ResponseEntity(HttpStatus.NO_CONTENT)
                        : new ResponseEntity(peliculas, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NO_CONTENT));
    }


}
