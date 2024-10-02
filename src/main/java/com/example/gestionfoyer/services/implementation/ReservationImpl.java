package com.example.gestionfoyer.services.implementation;

import com.example.gestionfoyer.entities.*;
import com.example.gestionfoyer.repositories.BlocRepo;
import com.example.gestionfoyer.repositories.ChambreRepo;
import com.example.gestionfoyer.repositories.EtudiantRepo;
import com.example.gestionfoyer.repositories.ReservatiopnRepo;
import com.example.gestionfoyer.services.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ReservationImpl implements ReservationService {

    private final ReservatiopnRepo reservationRepository;
    private final EtudiantRepo etudiantRepository;

    private final ChambreRepo chambreRepository;

    private final BlocRepo blocRepository;

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

    @Override
    public Reservation ajouterReservation(long idBloc, long cinEtudiant) {
        if (reservationRepository.findForReservation(idBloc) != null) {
            Reservation reservation = reservationRepository.findForReservation(idBloc);
            reservation.getEtudiants().add(etudiantRepository.findByCinEtudiant(cinEtudiant));
            Chambre chambre = chambreRepository.findByReservationsIdReservation(reservation.getIdReservation());
            if ((chambre.getTypeC().equals(TypeChambre.TRIPLE) && reservation.getEtudiants().size() == 3)
                    || chambre.getTypeC().equals(TypeChambre.DOUBLE)) {
                reservation.setEstValide(false);
            }
            return reservationRepository.save(reservation);
        } else {
            Set<Etudiant> etudiants = new HashSet<Etudiant>();
            etudiants.add(etudiantRepository.findByCinEtudiant(cinEtudiant));
            Reservation reservation = Reservation.builder().anneeUniversitaire(new Date()).etudiants(etudiants).build();
            Chambre chambre = chambreRepository.getForReservation(idBloc);
            Bloc bloc = blocRepository.findById(idBloc).get();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            String idReservation = chambre.getIdChambre() + bloc.getNomBloc() + calendar.get(Calendar.YEAR);
            reservation.setIdReservation(idReservation);
            if (chambre.getTypeC().equals(TypeChambre.SIMPLE)) {
                reservation.setEstValide(false);
            } else {
                reservation.setEstValide(true);
            }
            Reservation reservation1 = reservationRepository.save(reservation);
            chambre.getReservationSet().add(reservation);
            chambreRepository.save(chambre);
            return reservation1;
        }

    }

    @Override
    public Reservation annulerReservation(long cinEtudiant) {
        Reservation reservation = reservationRepository
                .findByEtudiantsCinEtudiantAndAnneeUniversitaire(cinEtudiant, Year.now().getValue());
        Etudiant etudiant = etudiantRepository.findByCinEtudiant(cinEtudiant);
        reservation.getEtudiants().remove(etudiant);
        reservation.setEstValide(true);
        return reservationRepository.save(reservation);

    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversite, String nomUniversite) {
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(anneeUniversite);
        return reservationRepository.findByAnneeUniversitaire_YearAndNomUnuiversite(calendar.get(Calendar.YEAR), nomUniversite);
    }

    @Override
    public void deleteReservation(String idReservation) {
        reservationRepository.deleteById(idReservation);
    }
}
