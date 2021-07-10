package com.isil.resource;

import com.isil.model.CineSede;
import com.isil.service.CineSedeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CineSedeResource {

    private final CineSedeService cineSedeService;

    public CineSedeResource(CineSedeService cineSedeService) {
        this.cineSedeService = cineSedeService;
    }


    @GetMapping("/cineSede")
    public ResponseEntity<List<CineSede>> getAll() {
        return cineSedeService.findAll()
                .map(cineSede -> cineSede.isEmpty() ? new ResponseEntity(HttpStatus.NO_CONTENT)
                        : new ResponseEntity(cineSede, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/cineSede/{id}")
    public ResponseEntity<CineSede> getCineSede(@PathVariable int id) {
        return cineSedeService.findById((long) id)
                .map(cineSede -> new ResponseEntity<>(cineSede, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/cineSede")
    public ResponseEntity<CineSede> save(@RequestBody CineSede cineSede) {
        return new ResponseEntity<>(cineSedeService.saveOrUpdate(cineSede), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteCineSede/{id}")
    public ResponseEntity delete(@PathVariable int id) {

        if (cineSedeService.deleteById((long) id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/cineSede/cine/{cineId}")
    public ResponseEntity<List<CineSede>> getByCategory(@PathVariable int cineId) {
        return cineSedeService.findByIdCine(cineId)
                .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
