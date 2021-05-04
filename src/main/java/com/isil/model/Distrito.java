package com.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Distrito {
    private Integer idDistrito;
    private String nombre;
    private Integer status;
    private String created_at;
    private String updated_at;
    private String deleted_at;

}
