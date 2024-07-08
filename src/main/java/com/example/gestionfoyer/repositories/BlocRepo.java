package com.example.gestionfoyer.repositories;

import com.example.gestionfoyer.entities.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlocRepo extends JpaRepository<Bloc,Long> {

    @Query("SELECT b FROM Bloc b WHERE b.foyer.university.idUniversite =: idUniversite")
    List<Bloc> findByFoyerUniversityIdUniversite(@Param("idUniversite") long idUniversite);

}
