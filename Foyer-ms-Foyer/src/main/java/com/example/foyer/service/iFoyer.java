package com.example.foyer.service;

import com.example.foyer.entitie.Foyer;

import java.util.List;
import java.util.Optional;

public interface iFoyer {
    Foyer addFoyer(Foyer foyer) ;
    Optional<Foyer> getFoyer(long idFoyer );
    List<Foyer> getAllFoyer();
    void deleteFoyer(long idFoyer);
    Foyer updateFoyer(Foyer foyer);
    Optional<Foyer> getFoyerById(Long id );



    List<Foyer> getFoyerParTypeMixte();
    List<Foyer> getFoyerParTypeSexe();
}
