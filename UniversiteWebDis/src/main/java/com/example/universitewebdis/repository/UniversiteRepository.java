package com.example.universitewebdis.repository;

import com.example.universitewebdis.entites.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.io.IOException;
import java.util.List;

public interface UniversiteRepository extends JpaRepository<Universite, Long> {

    @Query("select u From Universite u where u.nomUniversite=:nomU")
    Universite retreiveByNom(@Param("nomU") String nomUni);

    Universite findByNomUniversite(String nom); //keyword

    Universite findByNomUniversiteContainingIgnoreCase(String nom);

    @Query("SELECT u FROM Universite u")
    List<Universite> findAll(); // Remplacez findAllUniversitesForExport par findAll

    default String exportToCSV() {
        List<Universite> universites = findAll();

        // Implémentez la logique pour convertir les données en format CSV
        // Vous pouvez utiliser une bibliothèque comme OpenCSV pour simplifier cela

        // Exemple très basique (vous pouvez utiliser une bibliothèque CSV pour une gestion plus robuste)
        StringBuilder csvContent = new StringBuilder();
        csvContent.append("idUniversite,nomUniversite,adresse,etatUniversite\n");
        for (Universite universite : universites) {
            csvContent.append(String.format("%d,%s,%s,%s\n",
                    universite.getIdUniversite(),
                    universite.getNomUniversite(),
                    universite.getAdresse(),
                    universite.getEtatUniversite()));
        }

        return csvContent.toString();
    }


    List<Universite> findByEtatUniversite(String etat);

}
