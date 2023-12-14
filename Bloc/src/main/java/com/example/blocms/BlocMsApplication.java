package com.example.blocms;

import com.example.blocms.entities.Bloc;
import com.example.blocms.repositories.BlocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class BlocMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlocMsApplication.class, args);
    }

    @Autowired
    private BlocRepository repository;

    @Bean
    ApplicationRunner init() {
        return (args) -> {
            //save
            repository.save(new Bloc(1,"bloc1",12));
            repository.save(new Bloc(2, "bloc2", 20));
            repository.save(new Bloc(3, "bloc3", 20));
            // fetch
            repository.findAll().forEach(System.out::println);
        };
    }

}
