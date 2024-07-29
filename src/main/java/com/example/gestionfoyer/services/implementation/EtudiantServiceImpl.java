package com.example.gestionfoyer.services.implementation;

import com.example.gestionfoyer.entities.Etudiant;
import com.example.gestionfoyer.exceptions.NotFoundException;
import com.example.gestionfoyer.repositories.EtudiantRepo;
import com.example.gestionfoyer.services.EtudiantService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantServiceImpl implements EtudiantService {

    private final EtudiantRepo etudiantRepo;

    public EtudiantServiceImpl(EtudiantRepo etudiantRepo) {
        this.etudiantRepo = etudiantRepo;
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepo.findAll();
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {

        return null;
    }

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantRepo.save(etudiant);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepo.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(long idEtudiant) {

        return etudiantRepo.findById(idEtudiant).orElseThrow(()-> new NotFoundException("this student doesnt exist"));
    }

    @Override
    public void removeEtudiant(long idEtudiant) {
        etudiantRepo.deleteById(idEtudiant);
    }

    @Override
    public Etudiant getEtudiantById(long id) {
        return retrieveEtudiant(id);
    }
}
