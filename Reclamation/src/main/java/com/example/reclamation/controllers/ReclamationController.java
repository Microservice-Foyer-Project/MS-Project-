package com.example.reclamation.controllers;
import com.example.reclamation.entities.Reclamation;
import com.example.reclamation.services.ReclamationServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/reclamations")
public class ReclamationController {

    private final ReclamationServiceImp reclamationService;


    @PostMapping("/ajouter")
    public ResponseEntity<Reclamation> ajouterReclamation(@RequestBody Reclamation reclamation) {
        Reclamation nouvelleReclamation = reclamationService.ajouterReclamation(reclamation);
        return ResponseEntity.ok(nouvelleReclamation);
    }
    /*@GetMapping("/mesRec")
    public ResponseEntity<List<Reclamation>> ajouterReclamation(@RequestParam("email") String email,@RequestParam("etat") String etat) {
       List<Reclamation> lisR = reclamationService.listeReclamationsParEtudiant(email,etat);
        if (lisR != null) {
            return ResponseEntity.ok(lisR);  // 200 OK
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  // 404 Not Found
        }    }*/

    @GetMapping("/listeRec")
    public ResponseEntity<List<Reclamation>> getReclamation(@RequestParam("etat") String etat) {
        List<Reclamation> lisR = reclamationService.listeReclamations(etat);
        if (lisR != null) {
            return ResponseEntity.ok(lisR);  // 200 OK
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  // 404 Not Found
        }
    }
    @PutMapping("/modifier/{id}")
    public ResponseEntity<Reclamation> modifierReclamation(@RequestBody Reclamation reclamation,@PathVariable("id") Long id ) {
        return ResponseEntity.ok(reclamationService.modifierReclamation(reclamation,id));
    }
    @PutMapping("/changerEtat")
    public ResponseEntity<Reclamation> changerEtatReclamation(@RequestBody String etat,@RequestParam("id") Long id) {
        return ResponseEntity.ok(reclamationService.changerEtatReclamation(id,etat));
    }
}
