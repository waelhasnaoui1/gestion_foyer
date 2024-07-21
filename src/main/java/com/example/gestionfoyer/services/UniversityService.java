package com.example.gestionfoyer.services;

import com.example.gestionfoyer.entities.University;

import java.util.List;

public interface UniversityService {

    List<University> retrieveAllUniversities();
    University addUniversite (University u);
    University updateUniversite (University u);
    University retrieveUniversite (long idUniversite);

    //TODO:from last seance by amira

}
