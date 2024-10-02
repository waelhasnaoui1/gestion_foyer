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
public class UniversitySeriveImpl implements UniversityService {


    private final UniversityRepo universityRepo;
    private final FoyerRepo foyerRepo;

    public UniversitySeriveImpl(UniversityRepo universityRepo, FoyerRepo foyerRepo) {
        this.universityRepo = universityRepo;
        this.foyerRepo = foyerRepo;
    }

    @Override
    public List<University> retrieveAllUniversities() {
        return universityRepo.findAll();
    }

    @Override
    public University addUniversite(University u) {

        return universityRepo.save(u);
    }

    @Override
    public University updateUniversite(University u) {

        University existUniversity = retrieveUniversite(u.getIdUniversite());

        if (existUniversity !=null){
            universityRepo.save(u);
        }
        return null;

    }

    @Override
    public University retrieveUniversite(long idUniversite) {
        return universityRepo.findById(idUniversite).orElseThrow(
                () -> new NotFoundException("the university doesnt exist")
        );
    }

    @Override
    public List<University> getALllUniversities() {
        return retrieveAllUniversities();
    }

    @Override
    public University getUniversityById(long idUniversity) {
        return retrieveUniversite(idUniversity);
    }

    @Override
    public void deleteUniversity(long idUniversity) {
        universityRepo.deleteById(idUniversity);
    }

    @Override
    public University affecterFoyerAUniversity(long idFoyer, String nomUniversite) {
        University existUniversity= universityRepo.findByNomUniversite(nomUniversite);
//        Foyer existFoyer = foyerService.retrieveFoyer(idFoyer);
        Foyer existFoyer = foyerRepo.findById(idFoyer).orElseThrow(()-> new NotFoundException("this foyer not exist"));;
        existUniversity.setFoyer(existFoyer);
        universityRepo.save(existUniversity);
        return existUniversity;

    }

    @Override
    public University desaffecterFoyerUniversity(long idUniversity) {
        University existUniversity= retrieveUniversite(idUniversity);
        existUniversity.setFoyer(null);
        universityRepo.save(existUniversity);
        return existUniversity;
    }
}
