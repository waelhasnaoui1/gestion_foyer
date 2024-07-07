package com.example.gestionfoyer.services;

import com.example.gestionfoyer.entities.Chambre;

import java.util.List;

public interface ChambreService {

    List<Chambre> retrieveAllChambres();
    Chambre addChambre(Chambre c);
    Chambre updateChambre (Chambre	c);
    Chambre retrieveChambre (long idChambre);


}
