package com.example.gestionfoyer.controllers;

import com.example.gestionfoyer.entities.University;
import com.example.gestionfoyer.services.UniversityService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/univeristes")
public class UniversiteController {

    UniversityService universiteService;

    @PostMapping("add")
    public University addingUniversite(@RequestBody University universite){
        return universiteService.addUniversite(universite);
    }
    @GetMapping("getAll")
    public List<University> gettingAllUniversite(){
        return universiteService.getALllUniversities();
    }

    @GetMapping("get")
    public University gettingUniversite(@RequestParam("idUniversite") long idUniversite){
        return universiteService.getUniversityById(idUniversite);
    }

    @DeleteMapping("delete/{idUniversite}")
    public void deletingUniversite(@PathVariable("idUniversite") long idUniversite){
        universiteService.deleteUniversity(idUniversite);
    }

    @PutMapping("update")
    public University updatingUniversite(@RequestBody University universite){
        return universiteService.updateUniversite(universite);
    }

    @PutMapping("affecter-foyer-universite")
    public University affecterFoyerAUniversite (@RequestParam("idFoyer") long idFoyer,
                                                @RequestParam("nomUniversite") String nomUniversite){
        return universiteService.affecterFoyerAUniversity(idFoyer,nomUniversite);
    }
    @PutMapping("desaffecter-foyer-universite")
    public University desaffecterFoyerAUniversite (@RequestParam("idUniversite") long idUniversite){
        return universiteService.desaffecterFoyerUniversity(idUniversite);

    }
}
