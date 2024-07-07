package com.example.gestionfoyer.services.implementation;

import com.example.gestionfoyer.entities.Etudiant;
import com.example.gestionfoyer.services.EtudiantService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantServiceImpl implements EtudiantService {

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return null;
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {
        return null;
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return null;
    }

    @Override
    public Etudiant retrieveEtudiant(long idEtudiant) {
        return null;
    }

    @Override
    public void removeEtudiant(long idEtudiant) {

    }
}
