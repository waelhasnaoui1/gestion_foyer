package com.example.gestionfoyer.services;

import com.example.gestionfoyer.entities.Reservation;

import java.util.Date;
import java.util.List;

public interface ReservationService {

    List<Reservation> retrieveAllReservation();
    Reservation updateReservation (Reservation res);
    Reservation retrieveReservation (String idReservation);

    Reservation ajouterReservation(long idBloc,long cinEtudiant);

    Reservation annulerReservation(long cinEtudiant);

    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversite, String nomUniversite);

    void deleteReservation(String idReservation);
}
