package com.example.MNPETR.Controller;

import com.example.MNPETR.Model.Maintenancier;
import com.example.MNPETR.Service.MaintenancierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/maintenanciers")
public class MaintenancierController {

    @Autowired
    public MaintenancierService maintenancierService;

    @GetMapping
    public List<Maintenancier> getAllMaintenanciers() {
        return maintenancierService.getAllMaintenancier();
    }

    @GetMapping("/id")
    public ResponseEntity<Maintenancier> getMaintenancierById(@PathVariable Integer id) {
        Optional<Maintenancier> maintenanciers= maintenancierService.getMaintenancierByID(id);
        if(maintenanciers.isPresent()) {
            return ResponseEntity.ok(maintenanciers.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
