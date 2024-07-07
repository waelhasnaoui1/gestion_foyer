package com.example.gestionfoyer.repositories;

import com.example.gestionfoyer.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservatiopnRepo extends JpaRepository<Reservation,String> {
}
