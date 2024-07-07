package com.example.gestionfoyer.services;

import com.example.gestionfoyer.entities.Reservation;

import java.util.List;

public interface ReservationService {

    List<Reservation> retrieveAllReservation();
    Reservation updateReservation (Reservation res);
    Reservation retrieveReservation (String idReservation);

}
