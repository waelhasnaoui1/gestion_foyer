package com.example.gestionfoyer.services.implementation;

import com.example.gestionfoyer.entities.Bloc;
import com.example.gestionfoyer.entities.Chambre;
import com.example.gestionfoyer.exceptions.NotFoundException;
import com.example.gestionfoyer.repositories.BlocRepo;
import com.example.gestionfoyer.repositories.ChambreRepo;
import com.example.gestionfoyer.services.BlocService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class BlocServiceImpl implements BlocService {

    private final BlocRepo blocRepo;
    private final ChambreRepo chambreRepo;

    public BlocServiceImpl(BlocRepo blocRepo, ChambreRepo chambreRepo) {
        this.blocRepo = blocRepo;
        this.chambreRepo = chambreRepo;
    }

    @Override
    public List<Bloc> retrieveBlocs() {

        return blocRepo.findAll();

    }

    @Override
    public Bloc updateBloc(Bloc bloc) {

        Bloc foundBloc = getBlocById(bloc.getIdBloc());
        if(foundBloc == null ){
            throw new NotFoundException("Bloc with the id "+String.valueOf(bloc.getIdBloc()));
        }
        foundBloc.setNomBloc(bloc.getNomBloc());
        foundBloc.setFoyer(bloc.getFoyer());
        foundBloc.setCapaciteBloc(bloc.getCapaciteBloc());
        foundBloc.setNomBloc(bloc.getNomBloc());
        foundBloc.setChambres(bloc.getChambres());

        return blocRepo.save(foundBloc);


    }

    @Override
    public Bloc addBloc(Bloc bloc) {

        return blocRepo.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return blocRepo.findById(idBloc).orElseThrow(()-> new NotFoundException("Bloc with the id "+String.valueOf(idBloc)));

    }

    @Override
    public void removeBloc(long idBloc) {
        blocRepo.deleteById(idBloc);
    }

    @Override
    public Bloc getBlocById(long idBloc) {
        return blocRepo.findById(idBloc).orElseThrow(()-> new NotFoundException("Bloc with the id "+String.valueOf(idBloc)));
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {

        List<Chambre> chambres = chambreRepo.findAllById(numChambre);
        Bloc bloc = getBlocById(idBloc);
        bloc.setChambres(new HashSet<>(chambres));
        return blocRepo.save(bloc);

    }
}
