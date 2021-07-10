package com.isil.resource;

import com.isil.model.Usuario;
import com.isil.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioResource {

    private final UsuarioService usuarioService;

    public UsuarioResource(UsuarioService productService) {
        this.usuarioService = productService;
    }


    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getAll() {
        return usuarioService.findAll()
                .map(usuarios -> usuarios.isEmpty() ? new ResponseEntity(HttpStatus.NO_CONTENT)
                        : new ResponseEntity(usuarios, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable int id) {
        return usuarioService.findById((long) id)
                .map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> save(@RequestBody Usuario user) {
        return new ResponseEntity<>(usuarioService.saveOrUpdate(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteUsuario/{id}")
    public ResponseEntity delete(@PathVariable int id) {

        if (usuarioService.deleteById((long) id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


}
