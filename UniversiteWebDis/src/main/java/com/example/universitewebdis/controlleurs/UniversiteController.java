package com.example.universitewebdis.controlleurs;
import com.example.universitewebdis.entites.Universite;
import com.example.universitewebdis.service.IUniversiteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Universite")
public class UniversiteController {

     IUniversiteService universiteService;

    @GetMapping("")
    public List<Universite> getAllUniversites() {
        return universiteService.getAllUniversites();
    }

    @PostMapping(value="/add" , consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Universite> addUniversite(@RequestBody Universite universite) {
        return new ResponseEntity<>(universiteService.addUniversite(universite), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Universite> updateUniversite(@PathVariable Long id, @RequestBody Universite updatedUniversite) {
        return new ResponseEntity<>(universiteService.updateUniversite(id, updatedUniversite), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteUniversite(@PathVariable Long id) {
        universiteService.deleteUniversite(id);
    }

    @GetMapping("/{id}")
    public Universite getUniversite(@PathVariable Long id) {
        return universiteService.getUniversite(id);
    }

    //http://localhost:8080/Universite/search?nomUniversite=Mariem
    @GetMapping("/search")
    public Universite searchUniversitesByName(@RequestParam String nomUniversite) {
        return universiteService.searchUniversitesByName(nomUniversite);
    }



//http://localhost:8080/Universite/export/csv
    @GetMapping("/export/csv")
    public ResponseEntity<Resource> exportUniversitesToCSV() {
        // Générer le contenu CSV et le placer dans un objet Resource (par exemple, ByteArrayResource)
        Resource resource = universiteService.exportUniversitesToCSV();

        // Retourner la réponse avec le fichier CSV
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=universites.csv")
                .contentType(MediaType.parseMediaType("text/csv"))
                .body(resource);
    }


    @GetMapping("/filterByEtat")
    public List<Universite> getUniversitesByEtat(@RequestParam String etat) {
        return universiteService.getUniversitesByEtat(etat);
    }


}