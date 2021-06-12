package com.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Distrito")
public class Distrito {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idDistrito")
    private Long idDistrito;

    @Column(name = "Nombre")
    private String Nombre;


    @OneToMany(mappedBy = "distrito", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private List<CineSede> CineSede;
}
