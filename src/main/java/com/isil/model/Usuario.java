package com.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

 @Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Usuario")
public class Usuario {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idUsuario")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "correo")
    private String correo;

    @Column(name = "contrasena")
    private String contrasena;

    @Column(name = "tipoDocumento")
    private Integer tipoDocumento;

    @Column(name = "numeroDocumento")
    private String numeroDocumento;

    @Column(name = "idTipoUsuario")
    private Integer idTipoUsuario;

    @Column(name = "estado")
    private Integer estado;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fechaRegistro")
    private LocalDate fechaRegistro;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fechaModificacion")
    private LocalDate fechaModificacion;

    @Column(name = "admiModificacion")
    private String admiModificacion;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idTipoUsuario", insertable = false, updatable = false)
    private TipoUsuario tipoUsuario;

    // idTipoUsuario
    // 1 = Cliente
    // 2 = Admin
    // 3 = Superadmin
}



