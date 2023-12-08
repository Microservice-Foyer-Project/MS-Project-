package com.example.universitewebdis;

import com.example.universitewebdis.entites.Universite;
import com.example.universitewebdis.repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class UniversiteWebDisApplication {

    public static void main(String[] args) {
        SpringApplication.run(UniversiteWebDisApplication.class, args);
    }
    @Autowired
    private UniversiteRepository repository;
    @Bean
    ApplicationRunner init() {
        return (args) -> {
// save
            repository.save(new Universite(1,"Mariem", "Ch", "ma@esprit.tn"));
            repository.save(new Universite(2,"Sarra", "ab", "sa@esprit.tn"));
            repository.save(new Universite(3,"Mohamed", "ba", "mo@esprit.tn"));
// fetch
            repository.findAll().forEach(System.out::println);
        };
    }
}
