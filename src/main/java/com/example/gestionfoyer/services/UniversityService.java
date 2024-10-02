package com.example.gestionfoyer.services;

import com.example.gestionfoyer.entities.University;

import java.util.List;

public interface UniversityService {

    List<University> retrieveAllUniversities();
    University addUniversite (University u);
    University updateUniversite (University u);
    University retrieveUniversite (long idUniversite);

    List<University> getALllUniversities();

    University getUniversityById(long idUniversity);

    void deleteUniversity(long idUniversity);

    University affecterFoyerAUniversity(long idFoyer,String nomUniversite);

    University desaffecterFoyerUniversity(long idUniversity);

    //TODO:from last seance by amira

}
