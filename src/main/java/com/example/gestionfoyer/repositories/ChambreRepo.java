package com.example.gestionfoyer.repositories;

import com.example.gestionfoyer.entities.Chambre;
import com.example.gestionfoyer.entities.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChambreRepo extends JpaRepository<Chambre,Long> {

    List<Chambre> findByBlocFoyerUniversityNomUniversite(String nomUniversite);

    List<Chambre> findByBlocIdBlocAndTypeC(long idBloc, TypeChambre typeC);

    @Query("SELECT c from Chambre c WHERE c.bloc.idBloc =:idBloc and c.typeC =:typeChambre ")
    List<Chambre> findByBlocAndTypeCJPQL(long idBloc,TypeChambre typeChambre);

//    @Query("select c from Chambre c join Reservation r on (r member of c.reservations) where (c.bloc.idBloc = :idBloc and r.idReservation not like cast(year(current_date) as string)) order by c.idChambre limit 1")
//    Chambre getForReservation(long idBloc);
@Query(value = "SELECT c.* FROM Chambre c JOIN Reservation r ON r.chambre_id = c.id WHERE c.bloc_id = :idBloc AND r.idReservation NOT LIKE CONCAT(YEAR(CURRENT_DATE), '%') ORDER BY c.id LIMIT 1", nativeQuery = true)
Chambre getForReservation(@Param("idBloc") long idBloc);

//    @Query("select c from Chambre c join c.reservations r where c.bloc.idBloc = :idBloc and str(r.idReservation) not like concat(year(current_date), '%') order by c.idChambre")
//    Chambre getForReservation(@Param("idBloc") long idBloc);

//    Chambre findByReservationsIdReservation(String idReservation);

    @Query("select c from Chambre c join c.reservationSet r where r.idReservation = :idReservation")
    Chambre findByReservationsIdReservation(@Param("idReservation") String idReservation);

//    @Query("select c from Chambre c join Reservation r on r member of c.reservations where c.bloc.foyer.universite.nomUniversite = :nomUniversite and c.typeChambre = :type and r.idReservation not like cast(year(current_date) as string)")
//    List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type);

//    @Query(value = "SELECT c.* FROM Chambre c JOIN Reservation r ON r.chambre_id = c.id WHERE c.bloc_id IN (SELECT b.id FROM BLOC b JOIN FOYER f ON b.foyer_id = f.id JOIN UNIVERSITE u ON f.universite_id = u.id WHERE u.nomUniversite = :nomUniversite) AND c.typeChambre = :type AND r.idReservation NOT LIKE CONCAT(YEAR(CURDATE()), '%')", nativeQuery = true)
//    List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(@Param("nomUniversite") String nomUniversite, @Param("type") TypeChambre type, @Param("currentYear") String currentYear);

    @Query(value = "SELECT c.* FROM Chambre c JOIN Reservation r ON r.chambre_id = c.id WHERE c.bloc_id IN (SELECT b.id FROM BLOC b JOIN FOYER f ON b.foyer_id = f.id JOIN UNIVERSITE u ON f.universite_id = u.id WHERE u.nomUniversite = :nomUniversite) AND c.typeChambre = :type AND r.idReservation NOT LIKE CONCAT(YEAR(CURDATE()), '%')", nativeQuery = true)
    List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(@Param("nomUniversite") String nomUniversite, @Param("type") TypeChambre type);

//    @Query("select c from Chambre c join Reservation r on r member of c.reservations where r.idReservation not like cast(year(current_date) as string)")
//    List<Chambre> getChambresNonReserve();

    @Query(value = "SELECT c.* FROM Chambre c JOIN Reservation r ON r.chambre_id = c.id WHERE r.idReservation NOT LIKE CONCAT(YEAR(CURRENT_DATE), '%')", nativeQuery = true)
    List<Chambre> getChambresNonReserve();

//    @Query("SELECT c from Chambre c join Reservation r on(r member of c.reservationSet) where (c.bloc.idBloc:= idBloc and r.idReservation not like cast(year(current_date) as string)) order by c.idChambre limit 1 ")
//    Chambre getForReservation(long idBloc);

}
