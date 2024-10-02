package com.example.gestionfoyer.repositories;

import com.example.gestionfoyer.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepo extends JpaRepository<Etudiant,Long> {

    @Query("select e from Etudiant e where e.cin=:cinEtudiant")
    Etudiant findByCinEtudiant(long cinEtudiant);

}
