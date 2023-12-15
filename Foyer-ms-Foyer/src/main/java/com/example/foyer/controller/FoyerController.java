package com.example.foyer.controller;

import com.example.foyer.entitie.Foyer;
import com.example.foyer.service.impServiceFoyer;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/foyer")
public class FoyerController {
    impServiceFoyer FoyerserviceImpl;

    public FoyerController(impServiceFoyer impServiceFoyer) {
        this.FoyerserviceImpl = impServiceFoyer;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/add")
    Foyer addFoyer(@RequestBody Foyer foyer)
    {
        return FoyerserviceImpl.addFoyer(foyer);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/")
    List<Foyer> GetFoyer()
    {
        return FoyerserviceImpl.getAllFoyer();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    Optional<Foyer> GetFoyerById(@PathVariable Long id)
    {
        return FoyerserviceImpl.getFoyer(id);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/update")
    Foyer updateFoyer(@RequestBody Foyer foyer)
    {
        return FoyerserviceImpl.updateFoyer(foyer);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    void deleteFoyer(@PathVariable Long id )
    {
        FoyerserviceImpl.deleteFoyer(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/idFoyer/{id}")
    void getFoyerById(@PathVariable Long id )
    {
        FoyerserviceImpl.getFoyerById(id);
    }


    @GetMapping("/getFoyerParTypeSexe")
    public List<Foyer> getFoyerParTypeSexe()
    {
        return  FoyerserviceImpl.getFoyerParTypeSexe();

    }
    @GetMapping("/getFoyerParTypeMixte")
    public List<Foyer> getFoyerParTypeMixte()
    {
        return  FoyerserviceImpl.getFoyerParTypeMixte();

    }

}
