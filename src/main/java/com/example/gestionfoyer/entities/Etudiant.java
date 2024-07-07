package com.example.gestionfoyer.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Etudiant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEtudiant;

    private String nomEtudiant;

    private String prenomEtudiant;

    private long cin;

    private String ecole;

    private Date dataNaissance;

    @JsonBackReference
    @ManyToMany(mappedBy = "etudiants")
    @ToString.Exclude
    private Set<Reservation> reservations;

}
