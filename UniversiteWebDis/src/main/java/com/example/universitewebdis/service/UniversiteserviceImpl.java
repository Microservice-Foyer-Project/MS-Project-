package com.example.universitewebdis.service;

import com.example.universitewebdis.entites.Universite;
import com.example.universitewebdis.repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversiteserviceImpl  implements IUniversiteService {


    @Autowired
    private UniversiteRepository universiteRepository;

    public List<Universite> getAllUniversites() {
        return universiteRepository.findAll();
    }

    public Universite addUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    public Universite updateUniversite(Long id, Universite newUniversite) {
        if (universiteRepository.findById(id).isPresent()) {
            Universite existingUniversite = universiteRepository.findById(id).get();
            existingUniversite.setNomUniversite(newUniversite.getNomUniversite());
            existingUniversite.setAdresse(newUniversite.getAdresse());
            existingUniversite.setEtatUniversite(newUniversite.getEtatUniversite());

            // Mettez à jour les autres champs si nécessaire

            return universiteRepository.save(existingUniversite);
        } else {
            return null;
        }
    }

    public void deleteUniversite(Long id) {
        if (universiteRepository.findById(id).isPresent()) {
            universiteRepository.deleteById(id);
        }
        // Ne retourne pas de valeur ici
    }

    public Universite searchUniversitesByName(String nomUniversite) {
        return universiteRepository.findByNomUniversiteContainingIgnoreCase(nomUniversite);
    }


    public Resource exportUniversitesToCSV() {
        // Implémentez la logique pour générer le contenu CSV
        String csvContent = universiteRepository.exportToCSV();

        // Créez un objet Resource avec le contenu CSV
        ByteArrayResource resource = new ByteArrayResource(csvContent.getBytes());

        return resource;
    }


    @Override
    public List<Universite> getUniversitesByEtat(String etat) {
        return universiteRepository.findByEtatUniversite(etat);
    }


    @Override
    public Universite getUniversite(Long id) {
        return universiteRepository.findById(id).orElse(null);
    }
}