package com.example.gestionchambre.Repository;

import com.example.gestionchambre.Entity.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.gestionchambre.Entity.Chambre;

public interface ChambreRepository extends JpaRepository<Chambre,Integer> {

}
