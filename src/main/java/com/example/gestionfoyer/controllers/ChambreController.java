package com.example.gestionfoyer.controllers;

import com.example.gestionfoyer.entities.Chambre;
import com.example.gestionfoyer.entities.TypeChambre;
import com.example.gestionfoyer.services.ChambreService;
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
@RequestMapping("api/chambres")
public class ChambreController {

    ChambreService chambreService;

    @PostMapping("add")
    public Chambre addingChambre(@RequestBody Chambre chambre){
        return chambreService.addChambre(chambre);
    }

    @GetMapping("getAll")
    public List<Chambre> gettingAllChambre(){
        return chambreService.retrieveAllChambres();
    }

    @GetMapping("get")
    public Chambre gettingChambre(@RequestParam("idChambre") long idChambre){
        return chambreService.getChambreById(idChambre);
    }

    @DeleteMapping("delete/{idChambre}")
    public void deletingChambre(@PathVariable("idChambre") long idChambre){
        chambreService.deleteChambre(idChambre);
    }

    @PutMapping("update")
    public Chambre updatingChambre(@RequestBody Chambre chambre){
        return chambreService.updateChambre(chambre);
    }

    @GetMapping("get-par-nom-universite")
    public List<Chambre>  getChambresParNomUniversite( String nomUniversite) {
        return chambreService.getChambresParNomUniversite(nomUniversite);

    }
    @GetMapping("get-par-bloc-type-keyword")
    public List<Chambre> getChambresParBlocEtTypeKeyWord(@RequestParam("idBloc") long idBloc,@RequestParam("typeC") TypeChambre typeC)
    {
        return getChambresParBlocEtTypeKeyWord(idBloc,typeC);
    }
    @GetMapping("get-par-bloc-type-jpql")
    public List<Chambre> getChambresParBlocEtTypeJPQL(@RequestParam("idBloc") long idBloc,@RequestParam("typeC") TypeChambre typeC) {
        return chambreService.getChambresParBlocEtTypeJPQL(idBloc,typeC);
    }
    @GetMapping("get-non-reserve-par-nom-universite-typechambre")
    public List<Chambre>  getChambresNonReserveParNomUniversiteEtTypeChambre( @RequestParam("nomUniversite") String nomUniversite,
                                                                              @RequestParam("type") TypeChambre type) {
        return chambreService.getChambresNonReserveParNomUniversiteEtTypeChambre(nomUniversite,type);
    }
}
