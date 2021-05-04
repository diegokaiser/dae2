package com.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sala {
    private Integer idSala;
    private String numero;
    private Integer capacidad;
    private String tipoSala;
    private String idCine;
    private Integer status;
    private String created_at;
    private String updated_at;
    private String deleted_at;
}
