package com.example.gestionfoyer.repositories;

import com.example.gestionfoyer.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepo extends JpaRepository<Etudiant,Long> {
}
