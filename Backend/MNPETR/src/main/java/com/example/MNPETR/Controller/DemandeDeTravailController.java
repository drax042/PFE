package com.example.MNPETR.Controller;

import com.example.MNPETR.Model.DemandeDeTravail;
import com.example.MNPETR.Model.Enum.StatusDT;
import com.example.MNPETR.Model.Enum.StatusEquipement;
import com.example.MNPETR.Model.Enum.intituleRole;
import com.example.MNPETR.Model.Equipement;
import com.example.MNPETR.Model.User;
import com.example.MNPETR.Service.*;

import com.example.MNPETR.Util.RoleChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

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
    private UserService userService;

    @Autowired
    public EquipementService equipementService;

    @Autowired
    private NotificationService notificationService;

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
        SimpleDateFormat formatter = new SimpleDateFormat( "DD/MM/YYYY");
        Date date = formatter.parse(datedt);
        List<DemandeDeTravail> demandeDeTravail = demandeDeTravailService.getDemandeDeTravailByDateDT(date);
        if (!demandeDeTravail.isEmpty()) {
            return ResponseEntity.ok(demandeDeTravail);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/status")
    public ResponseEntity<List<DemandeDeTravail>> getDemandeDeTravailByStatus(@RequestParam StatusDT status) {
        List<DemandeDeTravail> demandeDeTravails=demandeDeTravailService.getDemandeDeTravailByStatus(status);
        if (!demandeDeTravails.isEmpty()) {
            return ResponseEntity.ok(demandeDeTravails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<DemandeDeTravail> addDemandeDeTravail(@RequestBody DemandeDeTravail demandeDeTravail) {
        if (demandeDeTravail.getEquipements() != null && !demandeDeTravail.getEquipements().isEmpty()) {
            // Supposons qu'un seul équipement est associé à la demande de travail
            Equipement equipement = demandeDeTravail.getEquipements().iterator().next();
            equipement.setStatusEquipement(StatusEquipement.En_panne);
            equipementService.saveEquipement(equipement);
        } else {
            // Gérer le cas où aucun équipement n'est associé à la demande de travail
            return ResponseEntity.badRequest().body(null);
        }
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userService.findByUsername(userDetails.getUsername());
        demandeDeTravail.setUser(currentUser);

        DemandeDeTravail savedDemandeDeTravail = demandeDeTravailService.saveDemandeDeTravail(demandeDeTravail);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedDemandeDeTravail);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<DemandeDeTravail> updateDemandeDeTravailStatus(@PathVariable int id, @RequestParam StatusDT newStatusDT) {
        Optional<DemandeDeTravail> optionalDemandeDeTravail = demandeDeTravailService.getDemandeDeTravailByID(id);
        if (optionalDemandeDeTravail.isPresent()) {
            DemandeDeTravail demandeDeTravail = optionalDemandeDeTravail.get();
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User currentUser = userService.findByUsername(userDetails.getUsername());
            demandeDeTravail.setStatusDT(newStatusDT);
            if (newStatusDT == StatusDT.NonApprouve) {
                demandeDeTravail.getEquipements().forEach(equipement -> {
                    equipement.setStatusEquipement(StatusEquipement.Fonctionnel);
                    equipementService.saveEquipement(equipement);
                });
            }
            DemandeDeTravail updatedDemandeDeTravail = demandeDeTravailService.saveDemandeDeTravail(demandeDeTravail);
            String notificationContent = "La demande de travail ID: " + demandeDeTravail.getID_DT() + " a été mise à jour par l'utilisateur ID: " + currentUser.getId() + " avec le nouveau statut: " + newStatusDT;
            List<User> responsables = userService.getUsersByRole(intituleRole.responsable);
            List<User> responsablesMaintenance = userService.getUsersByRole(intituleRole.responsableMaintenance);
            for (User responsable : responsables) {
                notificationService.createNotification(notificationContent, responsable);
            }
            for (User responsableMaintenance : responsablesMaintenance) {
                notificationService.createNotification(notificationContent, responsableMaintenance);
            }
            return ResponseEntity.ok(updatedDemandeDeTravail);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
