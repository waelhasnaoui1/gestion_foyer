package com.example.gestionfoyer.services.implementation;

import com.example.gestionfoyer.entities.Chambre;
import com.example.gestionfoyer.entities.TypeChambre;
import com.example.gestionfoyer.exceptions.NotFoundException;
import com.example.gestionfoyer.repositories.ChambreRepo;
import com.example.gestionfoyer.services.ChambreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ChambreServiceImpl implements ChambreService {

    private final ChambreRepo chambreRepo;

    public ChambreServiceImpl(ChambreRepo chambreRepo) {
        this.chambreRepo = chambreRepo;
    }


    @Override
    public List<Chambre> retrieveAllChambres() {

        return chambreRepo.findAll();
    }

    @Override
    public Chambre addChambre(Chambre chambre) {

        return chambreRepo.save(chambre);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return chambreRepo.save(c);
    }

    @Override
    public Chambre retrieveChambre(long idChambre) {

        return getChambreById(idChambre);

    }

    @Override
    public Chambre getChambreById(long idChambre) {
        return chambreRepo.findById(idChambre).orElseThrow(()-> new NotFoundException("chambre with the id "+String.valueOf(idChambre)));
    }

    @Override
    public void deleteChambre(long idChambre) {
        chambreRepo.deleteById(idChambre);
    }

    @Override
    public List<Chambre> getChambresParNomUniversite(String nomUniversite) {
        return chambreRepo.findByBlocFoyerUniversityNomUniversite(nomUniversite);
    }

    @Override
    public List<Chambre> getChambresParBlocEtTypeKeyWord(long idBloc, TypeChambre typeC) {
        return chambreRepo.findByBlocIdBlocAndTypeC(idBloc,typeC);
    }

    @Override
    public List<Chambre> getChambresParBlocEtTypeJPQL(long idBloc, TypeChambre typeC) {
        return chambreRepo.findByBlocAndTypeCJPQL(idBloc,typeC);
    }

    @Override

    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type) {
        return null;
    }

    @Override
    @Scheduled(cron ="*/30  * * * * * ")
    public void getChambresNonReserve() {
        log.info(chambreRepo.getChambresNonReserve().toString());
    }


}
