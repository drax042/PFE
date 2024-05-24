package com.example.MNPETR.Controller;

import com.example.MNPETR.Model.Enum.StatusEquipement;
import com.example.MNPETR.Model.Equipement;
import com.example.MNPETR.Model.Piece;
import com.example.MNPETR.Repository.PieceRepo;
import com.example.MNPETR.Service.EquipementService;
import com.example.MNPETR.Service.PieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/equipements")
public class EquipementController {

    @Autowired
    public EquipementService equipementService;

    @Autowired
    public PieceRepo pieceRepo;

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

    @GetMapping("/status")
    public ResponseEntity<List<Equipement>> getEquipementByStatus(@RequestParam StatusEquipement status) {
        List<Equipement> equipements = equipementService.getEquipementByStatus(status);
        if (equipements != null && !equipements.isEmpty()) {
            return ResponseEntity.ok(equipements);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/status")
    public ResponseEntity<Equipement> updateEquipementStatus(@PathVariable Integer id, @RequestParam StatusEquipement newStatusEquipement) {
        Optional<Equipement> OptionalEquipement = equipementService.getEquipementById(id);
        if (OptionalEquipement.isPresent()) {
            Equipement equipement = OptionalEquipement.get();
            equipement.setStatusEquipement(newStatusEquipement);
            Equipement updatedEquipement = equipementService.saveEquipement(equipement);
            return ResponseEntity.ok(updatedEquipement);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping
    public ResponseEntity<Equipement> addEquipement(@RequestBody Equipement equipement) {
        Set<Piece> pieces = equipement.getPieces().stream()
                .map(p -> pieceRepo.findById(p.getId()).orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
        equipement.setPieces(pieces);
        Equipement addedEquipement = equipementService.saveEquipement(equipement);
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
