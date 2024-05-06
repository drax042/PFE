package com.example.MNPETR.Controller;

import com.example.MNPETR.Model.Piece;
import com.example.MNPETR.Service.PieceService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pieces")
public class PieceController {

    private final PieceService pieceService;

    @Autowired
    public PieceController(PieceService pieceService) {
        this.pieceService = pieceService;
    }

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

    @PostMapping
    public ResponseEntity<Piece> addPiece(@RequestBody Piece piece) {
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
