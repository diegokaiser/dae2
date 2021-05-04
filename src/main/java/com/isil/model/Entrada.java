package com.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Entrada {
    private Integer idEntrada;
    private Double precio;
    private String tipo;
    private Integer stock;
    private String idSala;
    private String idPelicula;
    private Integer status;
    private String created_at;
    private String updated_at;
    private String deleted_at;
}
