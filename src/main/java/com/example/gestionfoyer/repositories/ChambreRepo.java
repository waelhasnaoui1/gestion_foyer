package com.example.gestionfoyer.repositories;

import com.example.gestionfoyer.entities.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChambreRepo extends JpaRepository<Chambre,Long> {
}
