package com.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Usuario")
public class Cine {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCine")
    private Long idCine;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "estado")
    private Integer estado;

    @Column(name = "idUsuario")
    private String logo;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fechaRegistro")
    private LocalDate fechaRegistro;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fechaModificacion")
    private LocalDate fechaModificacion;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "admiModificacion")
    private LocalDate admiModificacion;
}
