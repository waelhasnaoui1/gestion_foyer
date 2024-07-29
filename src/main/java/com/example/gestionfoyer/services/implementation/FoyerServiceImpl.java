package com.example.gestionfoyer.services.implementation;

import com.example.gestionfoyer.entities.Foyer;
import com.example.gestionfoyer.entities.University;
import com.example.gestionfoyer.exceptions.NotFoundException;
import com.example.gestionfoyer.repositories.FoyerRepo;
import com.example.gestionfoyer.repositories.UniversityRepo;
import com.example.gestionfoyer.services.FoyerService;
import com.example.gestionfoyer.services.UniversityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoyerServiceImpl implements FoyerService {

    private final FoyerRepo foyerRepo;
    private final UniversityService universityService;

    public FoyerServiceImpl(FoyerRepo foyerRepo, UniversityService universityService) {
        this.foyerRepo = foyerRepo;
        this.universityService = universityService;
    }

    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foyerRepo.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepo.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepo.save(f);
    }

    @Override
    public Foyer retrieveFoyer(long idFoyer) {

        return foyerRepo.findById(idFoyer).orElseThrow(()-> new NotFoundException("this foyer not exist"));
    }

    @Override
    public void removeFoyer(long idFoyer) {
        foyerRepo.deleteById(idFoyer);
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Foyer foundFoyer  = addFoyer(foyer);
        University existUniversity = universityService.retrieveUniversite(idUniversite);
        foundFoyer.setUniversity(existUniversity);
         return foyerRepo.save(foundFoyer);
    }
}
