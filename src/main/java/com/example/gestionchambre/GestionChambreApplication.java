package com.example.gestionchambre;

import com.example.gestionchambre.Entity.Chambre;
import com.example.gestionchambre.Repository.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GestionChambreApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionChambreApplication.class, args);
    }
    @Autowired
    private ChambreRepository repository;
    @Bean
    ApplicationRunner init(){
        return (args)->{
            //save
            repository.save(new Chambre(106,"bien",1));
            repository.save(new Chambre(201,"bien",3));
            repository.save(new Chambre(302,"bien",2));
            repository.findAll().forEach(System.out::println);
        };
    }
}
