package com.example.gestionfoyer.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String idReservation;

    private Date anneeUniversitaire;

    private Boolean estValide;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "id_reservation"),
    inverseJoinColumns = @JoinColumn(name = "id_etudiant")
    )
    @JsonManagedReference
    @ToString.Exclude
    private Set<Etudiant> etudiants;
}
