package com.example.gestionfoyer.services;

import com.example.gestionfoyer.entities.Chambre;
import com.example.gestionfoyer.entities.TypeChambre;

import java.util.List;

public interface ChambreService {

    List<Chambre> retrieveAllChambres();
    Chambre addChambre(Chambre c);
    Chambre updateChambre (Chambre	c);
    Chambre retrieveChambre (long idChambre);

    Chambre getChambreById(long idChambre);

    void deleteChambre(long idChambre);

    List<Chambre>  getChambresParNomUniversite( String nomUniversite) ;
    List<Chambre> getChambresParBlocEtTypeKeyWord(long idBloc, TypeChambre typeC) ;
    List<Chambre> getChambresParBlocEtTypeJPQL(long idBloc, TypeChambre typeC) ;
    List<Chambre>  getChambresNonReserveParNomUniversiteEtTypeChambre( String nomUniversite,TypeChambre type) ;

    void getChambresNonReserve();
}
