package com.example.MNPETR.Controller;

import com.example.MNPETR.Model.Equipement;
import com.example.MNPETR.Model.Piece;
import com.example.MNPETR.Repository.EquipementRepo;
import com.example.MNPETR.Service.PieceService;
import com.example.MNPETR.Service.UserService;
import org.apache.coyote.Response;
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
@RequestMapping("/pieces")
//@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class PieceController {

    @Autowired
    private PieceService pieceService;

    @Autowired
    private UserService userService;

    @Autowired
    private EquipementRepo equipementRepo;

    @GetMapping
    public List<Piece> getAllPieces() {
        return pieceService.getAllPiece();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Piece> getPieceById(@PathVariable Integer id) {
        Optional<Piece> piece = pieceService.getPieceById(id);
        if (piece.isPresent()) {
            return ResponseEntity.ok(piece.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/nom/{nom}")
    public List<Piece> getPieceByNom(@PathVariable String nom) {
        return pieceService.getPieceByName(nom);
    }


    @PostMapping("/create")
    public ResponseEntity<Piece> addPiece(@RequestBody Piece piece) {

        Set<Equipement> equipements = piece.getEquipements().stream()
                .map(e -> equipementRepo.findById(e.getID_Equipement()).orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
        piece.setEquipements(equipements);
        Piece addedPiece = pieceService.savePiece(piece);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedPiece);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePiece(@PathVariable Integer id) {
        Optional<Piece> existingPiece = pieceService.getPieceById(id);
        if (existingPiece.isPresent()) {
            pieceService.deletePiece(existingPiece.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}