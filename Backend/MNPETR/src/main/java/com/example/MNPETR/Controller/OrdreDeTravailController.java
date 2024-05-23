package com.example.MNPETR.Controller;

import com.example.MNPETR.Model.Enum.StatusEquipement;
import com.example.MNPETR.Model.Enum.StatusOT;
import com.example.MNPETR.Model.OrdreDeTravail;
import com.example.MNPETR.Model.Piece;
import com.example.MNPETR.Service.EquipementService;
import com.example.MNPETR.Service.OrdreDeTravailService;
import com.example.MNPETR.Service.PieceService;
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

    @Autowired
    private PieceService pieceService;

    @Autowired
    private EquipementService equipementService;

    @GetMapping
    public List<OrdreDeTravail> getAllOrdreDeTravail() {
        return ordreDeTravailService.getAllOrdreDeTravail();
    }

    @GetMapping("/id")
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

    @GetMapping("/status")
    public ResponseEntity<List<OrdreDeTravail>> getOrdreDeTravailByStatus(@PathVariable String status) {
        List<OrdreDeTravail> ordreDeTravail = ordreDeTravailService.getOrdreDeTravailByStatus(status);
            if (!ordreDeTravail.isEmpty()) {
                return ResponseEntity.ok(ordreDeTravail);
            }else {
                return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<OrdreDeTravail> addOrdreDeTravail(@RequestBody OrdreDeTravail ordreDeTravail) {
        int pieceID= ordreDeTravail.getPieceID();
        int quantityNeeded= ordreDeTravail.getQuantityNeeded();
        Optional<Piece> optionalPiece = pieceService.getPieceById(pieceID);
        if (optionalPiece.isPresent()) {
            Piece piece = optionalPiece.get();
            int currentQuantity = piece.getQuantite_Piece();
            if (currentQuantity >= quantityNeeded) {
                piece.setQuantite_Piece(currentQuantity - quantityNeeded);
                pieceService.savePiece(piece);
                OrdreDeTravail savedOrdreDeTravail = ordreDeTravailService.saveOrdreDeTravail(ordreDeTravail);
                return ResponseEntity.status(HttpStatus.CREATED).body(savedOrdreDeTravail);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<OrdreDeTravail> updateOrdreDeTravailStatus(@PathVariable int id, @RequestParam StatusOT newStatusOT) {
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