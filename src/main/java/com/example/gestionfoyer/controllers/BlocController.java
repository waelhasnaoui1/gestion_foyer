package com.example.gestionfoyer.controllers;

import com.example.gestionfoyer.entities.Bloc;
import com.example.gestionfoyer.services.BlocService;
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
@RequestMapping("api/blocs")
//@Tag()
public class BlocController {

    BlocService blocService;

//    @Operation(description="method pour ajouter des blocs",summary="ajouter un bloc",operationId="1")
    @PostMapping("add")
    public Bloc addingBloc(@RequestBody Bloc bloc){
        return blocService.addBloc(bloc);
    }

    @GetMapping("getAll")
    public List<Bloc> gettingAllBloc(){
        return blocService.retrieveBlocs();
    }

    @GetMapping("get")
    public Bloc gettingBloc(@RequestParam("idBloc") long idBloc){
        return blocService.getBlocById(idBloc);
    }

    @DeleteMapping("delete/{idBloc}")
    public void deletingBloc(@PathVariable("idBloc") long idBloc){
        blocService.removeBloc(idBloc);
    }

    @PutMapping("update")
    public Bloc updateBloc(@RequestBody Bloc bloc){
        return blocService.updateBloc(bloc);
    }

    @PutMapping("affecter-chambre-bloc")
    public Bloc affecterChambresABloc(
            @RequestBody List<Long> numChambre,
            @RequestParam("idBloc") long idBloc
    ){
        return blocService.affecterChambresABloc(numChambre,idBloc);
    }

}
