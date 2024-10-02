package com.example.gestionfoyer.repositories;

import com.example.gestionfoyer.entities.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepo extends JpaRepository<University,Long> {

    @Query("SELECT u FROM University u WHERE u.nomUniversite = :nomUniversite")
    University findByNomUniversite(@Param("nomUniversite") String nomUniversite);
}
