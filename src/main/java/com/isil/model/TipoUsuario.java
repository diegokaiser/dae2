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
@Table(name = "TipoUsuario")
public class TipoUsuario {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idTipoUsuario")
    private Long idTipoUsuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

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
