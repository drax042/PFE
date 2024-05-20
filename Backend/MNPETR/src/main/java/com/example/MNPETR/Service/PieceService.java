package com.example.MNPETR.Service;

import com.example.MNPETR.Model.Piece;
import com.example.MNPETR.Repository.PieceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PieceService implements IPieceService {
    private final PieceRepo pieceRepo ;
@Autowired
    public PieceService(PieceRepo pieceRepo) {

    this.pieceRepo = pieceRepo;
    }
@Override
    public List<Piece> getAllPiece(){
    return pieceRepo.findAll() ;
    }

    @Override
    public Optional<Piece> getPieceById(Integer ID_Piece) {
        return pieceRepo.findById(ID_Piece) ;
    }

    @Override
    public List<Piece> getPieceByType(String Type_Piece) {
        return pieceRepo.findPieceByTypePiece(Type_Piece);
    }

    @Override
    public List<Piece> getPieceByName(String Nom_Piece) {
        return pieceRepo.findPieceByNomPiece(Nom_Piece);
    }

    @Override
    public Piece savePiece(Piece piece){
        return pieceRepo.save(piece);
    }

    @Override
    public void deletePiece(Piece piece) {
        pieceRepo.delete(piece);
    }

    @Override
    public ResponseEntity<String> decreasePieceQuantity(int pieceId, int quantity) {
        Optional<Piece> optionalPiece = pieceRepo.findById(pieceId);
        if (optionalPiece.isPresent()) {
            Piece piece = optionalPiece.get();
            int currentQuantity = piece.getQuantite_Piece();
            int newQuantity = currentQuantity - quantity;
            if (newQuantity >= 0) {
                piece.setQuantite_Piece(newQuantity);
                pieceRepo.save(piece);
                return ResponseEntity.ok("La quantité de la pièce a été mise à jour avec succès.");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La quantité de la pièce ne peut pas être négative.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La pièce avec l'ID spécifié n'existe pas.");
        }
    }

    }





