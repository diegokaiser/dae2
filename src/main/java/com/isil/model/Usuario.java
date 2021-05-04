package com.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuario {
    private Integer idUsuario;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private Integer tipoDocumento;
    private String numeroDocumento;
    private Integer idTipoUsuario;
    private Integer status;
    private String created_at;
    private String updated_at;
    private String deleted_at;

    // idTipoUsuario
    // 1 = Cliente
    // 2 = Admin
    // 3 = Superadmin
}
