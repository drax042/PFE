package com.example.MNPETR.Controller;
import com.example.MNPETR.Model.Composant;
import com.example.MNPETR.Model.DemandeDeTravail;
import com.example.MNPETR.Model.OrdreDeTravail;
import com.example.MNPETR.Service.IComposantService;
import com.example.MNPETR.Service.OrdreDeTravailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
@CrossOrigin("*")
@RequestMapping("/ordredetravail")
public class OrdreDeTravailController {

    @Autowired
    public OrdreDeTravailService ordreDeTravailService;

    @GetMapping
    public List<OrdreDeTravail> getAllOrdresDeTravail() {

        return ordreDeTravailService.getAllOrdreDeTravail();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdreDeTravail> getOrdreDeTravailById(@PathVariable int id) {
        Optional<OrdreDeTravail> ordreDeTravail = ordreDeTravailService.getOrdreDeTravailById(id);
        if (ordreDeTravail.isPresent()){
            return ResponseEntity.ok(ordreDeTravail.get()) ;
        } else
           return ResponseEntity.notFound().build() ;
    }

    /* @GetMapping("/{id}")
    public ResponseEntity<OrdreDeTravail> getOrdreDeTravailById(@PathVariable int id) {
        Optional<OrdreDeTravail> ordreDeTravail = ordreDeTravailService.getOrdreDeTravailById(id);
        return ordreDeTravail.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    } */

    @PostMapping
    public ResponseEntity<OrdreDeTravail> addOrdreDeTravail(@RequestBody OrdreDeTravail ordreDeTravail) {
        OrdreDeTravail savedOrdreDeTravail = ordreDeTravailService.saveOrdreDeTravail(ordreDeTravail);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrdreDeTravail);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteOrdreDeTravail(@PathVariable Integer id) {
        Optional<OrdreDeTravail> existingOrdreDeTravail = ordreDeTravailService.getOrdreDeTravailById(id);
        if (existingOrdreDeTravail.isPresent()) {
            ordreDeTravailService.deleteOrdreDeTravail(existingOrdreDeTravail.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }  /*
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteOrdreDeTravail(@PathVariable Integer id){
            Optional<OrdreDeTravail> existingOrdreDeTravail = ordreDeTravailService.getOrdreDeTravailById(id);
            return existingOrdreDeTravail.map(ordreDeTravail -> {
                ordreDeTravailService.deleteOrdreDeTravail(ordreDeTravail);
                return ResponseEntity.noContent().build();
            }).orElse(ResponseEntity.notFound().build());
        } */

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


}



