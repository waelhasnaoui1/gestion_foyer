package com.example.gestionfoyer.controllers;

import com.example.gestionfoyer.entities.Foyer;
import com.example.gestionfoyer.services.FoyerService;
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
@RequestMapping("api/foyers")
public class FoyerController {

    FoyerService foyerService;

    @PostMapping("add")
    public Foyer addingFoyer(@RequestBody Foyer foyer){
        return foyerService.addFoyer(foyer);
    }
    @GetMapping("getAll")
    public List<Foyer> gettingAllFoyer(){
        return foyerService.retrieveAllFoyers();
    }

    @GetMapping("get")
    public Foyer gettingFoyer(@RequestParam("idFoyer") long idFoyer){
        return foyerService.retrieveFoyer(idFoyer);
    }

    @DeleteMapping("delete/{idFoyer}")
    public void deletingFoyer(@PathVariable("idFoyer") long idFoyer){
        foyerService.removeFoyer(idFoyer);
    }

    @PutMapping("update")
    public Foyer updatingFoyer(@RequestBody Foyer foyer){
        return foyerService.updateFoyer(foyer);
    }
    @PostMapping("ajouter-affecter")
    Foyer ajouterFoyerEtAffecterAUniversite (@RequestBody Foyer foyer,
                                             @RequestParam("idUniversite") long idUniversite){
        return foyerService.ajouterFoyerEtAffecterAUniversite(foyer,idUniversite);
    }
}
