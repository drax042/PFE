package com.example.MNPETR.Controller;

import com.example.MNPETR.Model.Composant;
import com.example.MNPETR.Service.ComposantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/composants")
public class ComposantController {
    @Autowired
    private ComposantService composantService;

    @GetMapping
    public List<Composant> getAllComposants() {
        return composantService.getAllComposants();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Composant> getComposantById(@PathVariable Integer id) {
        Optional<Composant> composant = composantService.getComposantById(id);
        if (composant.isPresent()) {
            return ResponseEntity.ok(composant.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/nom/{nom}")
    public List<Composant> getComposantsByNom(@PathVariable String nom) {
        return composantService.getComposantByNomComposant(nom);
    }

    @PostMapping
    public ResponseEntity<Composant> addComposant(@RequestBody Composant composant) {
        Composant savedComposant = composantService.saveComposant(composant);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedComposant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComposant(@PathVariable Integer id) {
        Optional<Composant> existingComposant = composantService.getComposantById(id);
        if (existingComposant.isPresent()) {
            composantService.deleteComposant(existingComposant.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
