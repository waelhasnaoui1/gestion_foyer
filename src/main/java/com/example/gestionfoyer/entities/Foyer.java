package com.example.gestionfoyer.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Foyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFoyer;

    private String nomFoyer;

    private long capaciteFoyer;

    @OneToMany(mappedBy = "foyer")
    private Set<Bloc> blocs;

    @OneToOne(mappedBy = "foyer")
    private University university;
}
