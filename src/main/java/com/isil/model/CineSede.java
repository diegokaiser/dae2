package com.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name="CineSede")
@Table(name = "CineSede")
public class CineSede {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCineSede")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "estado")
    private Integer estado;

    @Column(name = "idDistrito")
    private Integer distrito;

    @Column(name = "idCine")
    private Integer idCine;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fechaRegistro")
    private LocalDate fechaRegistro;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fechaModificacion")
    private LocalDate fechaModificacion;

    @Column(name = "admiModificacion")
    private String admiModificacion;



    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idCine", insertable = false, updatable = false)
    private Cine cine;

    @OneToMany(mappedBy = "cineSede", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Sala> sala;

}