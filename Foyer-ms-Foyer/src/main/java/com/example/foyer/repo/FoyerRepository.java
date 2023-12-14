package com.example.foyer.repo;

import com.example.foyer.entitie.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoyerRepository extends JpaRepository<Foyer,Long>{
    Foyer findByNomFoyer(String nomFoyer);
    // List<Foyer> findFoyerByType(String typeFoyer);


}
