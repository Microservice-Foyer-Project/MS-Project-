package com.example.reclamation.repositories;
import com.example.reclamation.entities.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {
    //List<Reclamation> findByEtudiantAndEtat(Utilisateur e,String etat);
    // Ajoutez d'autres méthodes personnalisées si nécessaire
   // List<Reclamation> findByEtudiantAndEtatIsNot(Utilisateur e,String etat);

    List<Reclamation> findByEtatIsNot(String etat);
}