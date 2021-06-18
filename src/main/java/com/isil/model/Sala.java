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
@Entity
@Table(name = "Sala")
public class Sala {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idSala")
    private Long idSala;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "idCineSede")
    private Integer idCineSede;

    @Column(name = "capacidad")
    private Integer capacidad;

    @Column(name = "tipoSala")
    private String tipoSala;

    @Column(name = "estado")
    private Integer estado;

/*
    @DateTimeFormat(pattern = "dd-MM-yyyy")
*/
    @Column(name = "fechaRegistro")
    private LocalDate fechaRegistro;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fechaModificacion")
    private LocalDate fechaModificacion;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "admiModificacion")
    private String admiModificacion;

    @OneToMany(mappedBy = "sala", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Entrada> entradas;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idCineSede", insertable = false, updatable = false)
    private CineSede cineSede;

}
