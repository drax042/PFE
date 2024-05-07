package com.example.MNPETR.Controller;

import com.example.MNPETR.Model.OrdreDeTravail;
import com.example.MNPETR.Service.OrdreDeTravailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ordredetravail")
public class OrdreDeTravailController {
    private final OrdreDeTravailService ordreDeTravailService;

    @Autowired
    public OrdreDeTravailController(OrdreDeTravailService ordreDeTravailService) {
        this.ordreDeTravailService = ordreDeTravailService;
    }

    @GetMapping
    public List<OrdreDeTravail> getAllOrdreDeTravail() {
        return ordreDeTravailService.getAllOrdreDeTravail();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdreDeTravail> getOrdreDeTravailById(@PathVariable int id) {
        Optional<OrdreDeTravail> ordreDeTravail = ordreDeTravailService.getOrdreDeTravailById(id);
        return ordreDeTravail.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OrdreDeTravail> addOrdreDeTravail(@RequestBody OrdreDeTravail ordreDeTravail) {
        OrdreDeTravail savedOrdreDeTravail = ordreDeTravailService.saveOrdreDeTravail(ordreDeTravail);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrdreDeTravail);
    }
}
