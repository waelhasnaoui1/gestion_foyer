package com.example.gestionfoyer.repositories;

import com.example.gestionfoyer.entities.Chambre;
import com.example.gestionfoyer.entities.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChambreRepo extends JpaRepository<Chambre,Long> {

    List<Chambre> findByBlocFoyerUniversityNomUniversite(String nomUniversite);

    List<Chambre> findByBlocIdBlocAndTypeC(long idBloc, TypeChambre typeC);

    @Query("SELECT c from Chambre c WHERE c.bloc.idBloc =:idBloc and c.typeC =:typeChambre ")
    List<Chambre> findByBlocAndTypeCJPQL(long idBloc,TypeChambre typeChambre);

    @Query("SELECT c from Chambre c join Reservation r on(r member of c.reservationSet) where (c.bloc.idBloc:= idBloc and r.idReservation not like cast(year(current_date) as string)) order by c.idChambre limit 1 ")
    Chambre getForReservation(long idBloc);

}
