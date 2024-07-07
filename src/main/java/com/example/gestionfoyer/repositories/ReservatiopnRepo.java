package com.example.gestionfoyer.repositories;

import com.example.gestionfoyer.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservatiopnRepo extends JpaRepository<Reservation,String> {
}
