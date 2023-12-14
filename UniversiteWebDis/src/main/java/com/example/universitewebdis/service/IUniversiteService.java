package com.example.universitewebdis.service;

import com.example.universitewebdis.entites.Universite;
import org.springframework.core.io.Resource;
import java.util.List;

public interface IUniversiteService {

    Universite addUniversite(Universite universite);

    Universite getUniversite(Long id);

    List<Universite> getAllUniversites();

    void deleteUniversite(Long id);

    Universite updateUniversite(Long id, Universite newUniversite);
    Universite searchUniversitesByName(String nom);
    public Resource exportUniversitesToCSV();
    List<Universite> getUniversitesByEtat(String etat);


}