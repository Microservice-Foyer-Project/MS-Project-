package com.example.gestionchambre.Controller;

import com.example.gestionchambre.Entity.Chambre;
import com.example.gestionchambre.Service.ChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.gestionchambre.Entity.Chambre;
import com.example.gestionchambre.Service.ChambreService;

import java.util.List;

@RestController
@RequestMapping("/chambres")
public class ChambreRestAPI {

    @Autowired
    private ChambreService chambreService;
    private String hello="hello , i'm the chambre MS";
    @RequestMapping("/hello")
    public String sayHello(){
        return hello;
    }

    @RequestMapping("")
    public List<Chambre> getListChambre(){
        return chambreService.getAll();
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Chambre> createChambre(@RequestBody Chambre chambre) {
        return new ResponseEntity<>(chambreService.addChambre(chambre), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Chambre> updateChambre(@PathVariable(value = "id") int id,
                                         @RequestBody Chambre chambre){
        return new ResponseEntity<>(chambreService.updateChambre(id, chambre),
                HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteChambre(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(chambreService.deleteChambre(id), HttpStatus.OK);
    }
}
