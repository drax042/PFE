package com.example.MNPETR.Controller;

import com.example.MNPETR.Model.Enum.StatusEquipement;
import com.example.MNPETR.Model.Enum.StatusOT;
import com.example.MNPETR.Model.Equipement;
import com.example.MNPETR.Model.OrdreDeTravail;
import com.example.MNPETR.Model.Piece;
import com.example.MNPETR.Repository.EquipementRepo;
import com.example.MNPETR.Service.EquipementService;
import com.example.MNPETR.Service.OrdreDeTravailService;
import com.example.MNPETR.Service.PieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/ordreDeTravails")
public class OrdreDeTravailController {
    @Autowired
    private OrdreDeTravailService ordreDeTravailService;

    @Autowired
    private PieceService pieceService;

    @Autowired
    private EquipementService equipementService;

    @Autowired
    private EquipementRepo  equipementRepo;

    @GetMapping
    public List<OrdreDeTravail> getAllOrdreDeTravail() {
        return ordreDeTravailService.getAllOrdreDeTravail();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdreDeTravail> getOrdreDeTravailById(@PathVariable Integer id) {
        Optional<OrdreDeTravail> ordreDeTravail = ordreDeTravailService.getOrdreDeTravailById(id);
        if (ordreDeTravail.isPresent()) {
            return ResponseEntity.ok(ordreDeTravail.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @GetMapping("/date")
    public ResponseEntity<List<OrdreDeTravail>> getOrdreDeTravailByDate(@RequestParam String date_ot) throws ParseException {
        SimpleDateFormat formateur = new SimpleDateFormat("DD/MM/YYYY");
        Date date = formateur.parse(date_ot);
        List<OrdreDeTravail> ordreDeTravail = ordreDeTravailService.getOrdreDeTravailByDate(date);
        if (!ordreDeTravail.isEmpty()) {
            return ResponseEntity.ok(ordreDeTravail);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/status")
    public ResponseEntity<List<OrdreDeTravail>> getOrdreDeTravailByStatus(@RequestParam StatusOT status) {
        List<OrdreDeTravail> ordreDeTravail = ordreDeTravailService.getOrdreDeTravailByStatus(status);
        if (ordreDeTravail != null && !ordreDeTravail.isEmpty()) {
            return ResponseEntity.ok(ordreDeTravail);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<OrdreDeTravail> addOrdreDeTravail(@RequestBody OrdreDeTravail ordreDeTravail) {
        try {
            Optional<Piece> optionalPiece = pieceService.getPieceById(ordreDeTravail.getPieceID());
            if (!optionalPiece.isPresent()) {
                throw new RuntimeException("Pièce non trouvée.");
            }
            Piece piece = optionalPiece.get();

            int currentQuantity = piece.getQuantite_Piece();
            if (currentQuantity < ordreDeTravail.getQuantityNeeded()) {
                throw new RuntimeException("La quantité de la pièce est insuffisante.");
            }

            piece.setQuantite_Piece(currentQuantity - ordreDeTravail.getQuantityNeeded());
            pieceService.savePiece(piece);

            Set<Equipement> equipements = ordreDeTravail.getEquipements().stream()
                    .map(equipement -> {
                        Optional<Equipement> equipementOpt = equipementService.getEquipementById(equipement.getID_Equipement());
                        return equipementOpt.orElse(null);
                    })
                    .filter(Objects::nonNull)
                    .collect(Collectors.toSet());

            OrdreDeTravail savedOrdreDeTravail = ordreDeTravailService.saveOrdreDeTravail(ordreDeTravail);

            return ResponseEntity.status(HttpStatus.CREATED).body(savedOrdreDeTravail);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<OrdreDeTravail> updateOrdreDeTravailStatus(@RequestParam int id, @RequestParam StatusOT newStatusOT) {
        Optional<OrdreDeTravail> optionalOrdreDeTravail = ordreDeTravailService.getOrdreDeTravailById(id);
        if (optionalOrdreDeTravail.isPresent()) {
            OrdreDeTravail ordreDeTravail = optionalOrdreDeTravail.get();
            ordreDeTravail.setStatusOT(newStatusOT);
            if (newStatusOT == StatusOT.termine) {
                ordreDeTravail.getEquipements().forEach(equipement -> {
                    equipement.setStatusEquipement(StatusEquipement.Fonctionnel);
                    equipementService.saveEquipement(equipement);
                });
            }
            OrdreDeTravail updatedOrdreDeTravail = ordreDeTravailService.saveOrdreDeTravail(ordreDeTravail);
            return ResponseEntity.ok(updatedOrdreDeTravail);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}