package com.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cine {
    private Integer idCine;
    private String nombre;
    private String direccion;
    private String logo;
    private Integer idDistrito;
    private Integer status;
    private String created_at;
    private String updated_at;
    private String deleted_at;
}
