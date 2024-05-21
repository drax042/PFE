package com.example.MNPETR.Controller;

import com.example.MNPETR.Model.DemandeDeTravail;
import com.example.MNPETR.Model.Enum.StatusDT;
import com.example.MNPETR.Model.Enum.StatusEquipement;
import com.example.MNPETR.Model.Equipement;
import com.example.MNPETR.Service.DemandeDeTravailService;

import com.example.MNPETR.Service.EquipementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/demanedeDeTravails")
public class DemandeDeTravailController {
    @Autowired
    public DemandeDeTravailService demandeDeTravailService;

    @Autowired
    public EquipementService equipementService;

    @GetMapping
    public List<DemandeDeTravail> getAllDemandeDeTravails() {
        return demandeDeTravailService.getAllDemandeDeTravail();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DemandeDeTravail> getDemandeDeTravailById(@PathVariable Integer id) {
        Optional<DemandeDeTravail> demandeDeTravail= demandeDeTravailService.getDemandeDeTravailByID(id);
        if (demandeDeTravail.isPresent()) {
            return ResponseEntity.ok(demandeDeTravail.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{date}")
    public ResponseEntity<List<DemandeDeTravail>> getDemandeDeTravailByDate(@PathVariable String datedt) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat( "dd/MM/yyyy");
        Date date = formatter.parse(datedt);
        List<DemandeDeTravail> demandeDeTravail = demandeDeTravailService.getDemandeDeTravailByDateDT(date);
        if (!demandeDeTravail.isEmpty()) {
            return ResponseEntity.ok(demandeDeTravail);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/status")
    public ResponseEntity<List<DemandeDeTravail>> getDemandeDeTravailByStatus(@RequestParam String status) {
        List<DemandeDeTravail> demandeDeTravails=demandeDeTravailService.getDemandeDeTravailByStatus(status);
        if (!demandeDeTravails.isEmpty()) {
            return ResponseEntity.ok(demandeDeTravails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

   @PostMapping
    public ResponseEntity<DemandeDeTravail> addDemandeDeTravail(@RequestBody DemandeDeTravail demandeDeTravail) {
       int equipementId = demandeDeTravail.getEquipementId();
        Optional<Equipement> optionalEquipement = equipementService.getEquipementById(equipementId);
        if (optionalEquipement.isPresent()) {
            Equipement equipement = optionalEquipement.get();
            equipement.setStatusEquipement(StatusEquipement.En_panne);
            Equipement updatedEquipement = equipementService.saveEquipement(equipement);
            equipement.setStatusEquipement(updatedEquipement.getStatusEquipement());
            DemandeDeTravail savedDemandeDeTravail = demandeDeTravailService.saveDemandeDeTravail(demandeDeTravail);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedDemandeDeTravail);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<DemandeDeTravail> updateDemandeDeTravailStatus(@PathVariable int id, @RequestParam StatusDT newStatusDT) {
        Optional<DemandeDeTravail> optionalDemandeDeTravail = demandeDeTravailService.getDemandeDeTravailByID(id);
        if (optionalDemandeDeTravail.isPresent()) {
            DemandeDeTravail DemandeDeTravail = optionalDemandeDeTravail.get();
            DemandeDeTravail.setStatusDT(newStatusDT);
            if (newStatusDT == StatusDT.NonApprouve) {
                DemandeDeTravail.getEquipements().forEach(equipement -> {
                    equipement.setStatusEquipement(StatusEquipement.Fonctionnel);
                    equipementService.saveEquipement(equipement);
                });
            }
            DemandeDeTravail updatedDemandeDeTravail = demandeDeTravailService.saveDemandeDeTravail(DemandeDeTravail);
            return ResponseEntity.ok(updatedDemandeDeTravail);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
