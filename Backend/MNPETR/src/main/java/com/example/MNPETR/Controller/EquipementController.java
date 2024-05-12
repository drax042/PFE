package com.example.MNPETR.Controller;

import com.example.MNPETR.Model.Equipement;
import com.example.MNPETR.Service.EquipementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/equipements")
public class EquipementController {

    @Autowired
    public EquipementService equipementService;

    @GetMapping
    public List<Equipement> getAllEquipements() {
        return equipementService.getAllEquipements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipement> getEquipementById(@PathVariable Integer id) {
        Optional<Equipement> equipement = equipementService.getEquipementById(id);
        if (equipement.isPresent()) {
            return ResponseEntity.ok(equipement.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Equipement> addEquipement(@RequestBody Equipement equipement) {
        Equipement addedEquipement= equipementService.saveEquipement(equipement);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedEquipement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipement(@PathVariable Integer id) {
        Optional<Equipement> existingEquipement = equipementService.getEquipementById(id);
        if (existingEquipement.isPresent()) {
            equipementService.deleteEquipement(existingEquipement.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
