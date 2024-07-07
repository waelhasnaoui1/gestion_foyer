package com.example.gestionfoyer.services.implementation;

import com.example.gestionfoyer.entities.Reservation;
import com.example.gestionfoyer.services.ReservationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationImpl implements ReservationService {

    @Override
    public List<Reservation> retrieveAllReservation() {
        return null;
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        return null;
    }

    @Override
    public Reservation retrieveReservation(String idReservation) {
        return null;
    }
}
