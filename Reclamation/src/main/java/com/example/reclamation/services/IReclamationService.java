package com.example.reclamation.services;


import com.example.reclamation.entities.Reclamation;

import java.util.List;

public interface IReclamationService {
    Reclamation ajouterReclamation(Reclamation reclamation);
    List<Reclamation>listeReclamations(String etat);
    Reclamation modifierReclamation(Reclamation reclamation,long idRec);
    Reclamation changerEtatReclamation(Long id,String etat);

}
