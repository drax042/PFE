package com.example.MNPETR.Controller;

import com.example.MNPETR.Model.DemandeDeTravail;
import com.example.MNPETR.Service.DemandeDeTravailService;

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
@CrossOrigin("*")
@RequestMapping("/demanedeDeTravails")
public class DemandeDeTravailController {
    @Autowired
    public  DemandeDeTravailService demandeDeTravailService;


    @GetMapping
    public List<DemandeDeTravail> getAllDemandeDeTravails() {
        return demandeDeTravailService.getAllDemandeDeTravail();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DemandeDeTravail> getDemandeDeTravail(@PathVariable Integer id) {
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


    @PostMapping
    public ResponseEntity<DemandeDeTravail> addDemandeDeTravail(@RequestBody DemandeDeTravail demandeDeTravail) {
        DemandeDeTravail savedDemandeDeTravail= demandeDeTravailService.saveDemandeDeTravail(demandeDeTravail);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDemandeDeTravail);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteDemandeDeTravail(@PathVariable Integer id) {
        Optional<DemandeDeTravail> existingDemandeDeTravail= demandeDeTravailService.getDemandeDeTravailByID(id);
        if (existingDemandeDeTravail.isPresent()) {
            demandeDeTravailService.deleteDemandeDeTravail(existingDemandeDeTravail.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
