package com.example.MNPETR.Controller;

import com.example.MNPETR.Model.OrdreDeTravail;
import com.example.MNPETR.Service.OrdreDeTravailService;
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
@RequestMapping("/ordreDeTravails")
public class OrdreDeTravailController {
    @Autowired
    private OrdreDeTravailService ordreDeTravailService;

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

    @GetMapping("/date")
    public ResponseEntity<List<OrdreDeTravail>> getOrdreDeTravailByDate(@PathVariable String date_ot) throws ParseException {
        SimpleDateFormat formateur = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formateur.parse(date_ot);
        List<OrdreDeTravail> ordreDeTravail = ordreDeTravailService.getOrdreDeTravailByDate(date);
        if (!ordreDeTravail.isEmpty()) {
            return ResponseEntity.ok(ordreDeTravail);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<OrdreDeTravail> addOrdreDeTravail(@RequestBody OrdreDeTravail ordreDeTravail) {
        OrdreDeTravail savedOrdreDeTravail = ordreDeTravailService.saveOrdreDeTravail(ordreDeTravail);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrdreDeTravail);
    }
}