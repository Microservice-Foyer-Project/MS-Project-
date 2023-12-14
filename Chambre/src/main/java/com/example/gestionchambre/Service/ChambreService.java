package com.example.gestionchambre.Service;

import com.example.gestionchambre.Entity.Chambre;
import com.example.gestionchambre.Repository.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.gestionchambre.Entity.Chambre;
import com.example.gestionchambre.Repository.ChambreRepository;

import java.util.List;

@Service
public class ChambreService {
    @Autowired
    private ChambreRepository chambreRepository;
    public Chambre addChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    public List<Chambre> getAll(){
        return chambreRepository.findAll();
    }
    public Chambre updateChambre(int id, Chambre newChambre) {
        if (chambreRepository.findById(id).isPresent()) {
            Chambre existingCandidat = chambreRepository.findById(id).get();
            existingCandidat.setDescription((newChambre.getDescription())) ;
            existingCandidat.setNbrLits(newChambre.getNbrLits());
            existingCandidat.setNumeroChambre(newChambre.getNumeroChambre());
            return chambreRepository.save(existingCandidat);
        } else
            return null;
    }

    public String deleteChambre(int id) {
        if (chambreRepository.findById(id).isPresent()) {
            chambreRepository.deleteById(id);
            return "chambre supprimé";
        } else
            return "chambre supprimé";
    }
}
