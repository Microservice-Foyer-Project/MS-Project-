package com.example.reclamation.services;


import com.example.reclamation.entities.Reclamation;
import com.example.reclamation.repositories.ReclamationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReclamationServiceImp implements IReclamationService{

    private final ReclamationRepository reclamationRepository;

    @Override
    public Reclamation ajouterReclamation(Reclamation reclamation) {
       // Optional<Utilisateur> e = utilisateurRepository.findByEmail(email);

        reclamation.setEtat("envoyé");
        return reclamationRepository.save(reclamation);
    }
    @Override
    public Reclamation modifierReclamation(Reclamation reclamation,long id) {
        Reclamation rec  = reclamationRepository.findById(id).orElse(null);
        rec.setSujet(reclamation.getSujet());
        rec.setDescription(reclamation.getDescription());
            return reclamationRepository.save(rec);
    }

    @Override
    public Reclamation changerEtatReclamation(Long id, String etat) {
        Reclamation reclamation = reclamationRepository.findById(id).orElse(null);
        reclamation.setEtat(etat);
        return reclamationRepository.save(reclamation);
    }



    @Override
    public List<Reclamation> listeReclamations(String etat) {
        return reclamationRepository.findByEtatIsNot(etat);
    }


}