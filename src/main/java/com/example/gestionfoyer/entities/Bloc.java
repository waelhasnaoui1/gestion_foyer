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
public class Bloc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBloc;

    private String nomBloc;

    private long capaciteBloc;

    @OneToMany(mappedBy = "bloc")
    private Set<Chambre> chambres;

    @ManyToOne
    @JoinColumn(name = "foyer_id")
    private Foyer foyer;

}
