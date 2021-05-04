package com.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pelicula {
    private Integer idPelicula;
    private String nombre;
    private String duracion;
    private String fechaEstreno;
    private String idioma;
    private String pais;
    private Integer subtitulos;
    private Integer doblada;
    private String descripcion;
    private String genero;
    private Integer destacado;
    private Integer status;
    private String created_at;
    private String updated_at;
    private String deleted_at;
}
