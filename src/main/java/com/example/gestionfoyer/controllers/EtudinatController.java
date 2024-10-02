package com.example.gestionfoyer.controllers;

import com.example.gestionfoyer.entities.Etudiant;
import com.example.gestionfoyer.repositories.EtudiantRepo;
import com.example.gestionfoyer.services.EtudiantService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/etudiants")
public class EtudinatController {

    EtudiantService etudiantService;

    EtudiantRepo etudiantRepository;
    @GetMapping
    ResponseEntity<String> hello (){
        return ResponseEntity.ok("working");
    }

    @PostMapping("add")
    public Etudiant addEtudiant(@Valid @RequestBody Etudiant etudiant){
        return etudiantRepository.save(etudiant);
    }
    // @Valid est une annotation utilisée pour effectuer une validation de bean sur l'objet annoté.
    //@RequestBody est une annotation indiquant qu'un paramètre de méthode doit être lié au corps de la requête HTTP.

    @GetMapping("getAll")
    public List<Etudiant> gettingAllEtudiant(){
        return etudiantService.getAllEtudiants();
    }
// renvoie une liste (List) d'objets de type Etudiant et porte le nom gettingAllEtudiant

    @GetMapping("get")
    public Etudiant gettingEtudiant(@RequestParam("idEtudiant") long idEtudiant){
        return etudiantService.getEtudiantById(idEtudiant);
    }
    //@GetMapping("get"): C'est une annotation Spring qui indique que
    // cette méthode sera appelée en réponse à une requête HTTP de type GET avec le chemin d'accès "/get".
    //renvoie un objet de type Etudiant et porte le nom gettingEtudiant.
    //Elle prend en paramètre un identifiant d'étudiant (idEtudiant) passé en tant que paramètre de requête (@RequestParam).

    @DeleteMapping("delete/{idEtudiant}")
    public void deletingEtudiant(@PathVariable("idEtudiant") long idEtudiant){
        etudiantService.removeEtudiant(idEtudiant);
    }
    //une API REST pour supprimer un étudiant en fonction de son identifiant.
    //cette méthode répondra aux requêtes DELETE à l'URL relative "/delete/{idEtudiant}"
    // où {idEtudiant} est un chemin variable
    //prend en paramètre l'identifiant de l'étudiant (idEtudiant)
    // extrait du chemin d'accès en utilisant l'annotation @PathVariable
    //http://localhost:8080/api/etudiants/delete/1

    @PutMapping("update")
    public Etudiant updatingEtudiant(@RequestBody Etudiant etudiant){
        return etudiantService.updateEtudiant(etudiant);
    }
}
