package com.example.universitewebdis;

import com.example.universitewebdis.entites.Universite;
import com.example.universitewebdis.repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
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
            repository.save(new Universite(1,"Mariem", "ma@esprit.tn","Public"));
            repository.save(new Universite(2,"Sarra", "sa@esprit.tn","Prive"));
            repository.save(new Universite(3,"Mohamed",  "mo@esprit.tn","Public"));
// fetch
            repository.findAll().forEach(System.out::println);
        };
    }
}
