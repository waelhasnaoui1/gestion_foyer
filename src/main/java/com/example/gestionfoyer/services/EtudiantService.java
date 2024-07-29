package com.example.gestionfoyer.services;

import com.example.gestionfoyer.entities.Etudiant;

import java.util.List;

public interface EtudiantService {

    List<Etudiant> getAllEtudiants();

    List<Etudiant> addEtudiants (List<Etudiant> etudiants);
    Etudiant addEtudiant (Etudiant etudiant);
    Etudiant updateEtudiant (Etudiant e);

    Etudiant retrieveEtudiant(long idEtudiant);

    void removeEtudiant(long idEtudiant);

    Etudiant getEtudiantById (long id);


}
