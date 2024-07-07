package com.example.gestionfoyer.repositories;

import com.example.gestionfoyer.entities.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepo extends JpaRepository<University,Long> {
}
