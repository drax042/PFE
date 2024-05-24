package com.example.MNPETR.Service;

import com.example.MNPETR.Model.*;
import com.example.MNPETR.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PieceService implements IPieceService {
    private final PieceRepo pieceRepo ;
    private final MagasinierRepo magasinierRepo ;
    private final EquipementRepo equipementRepo ;
    private final ComposantRepo composantRepo ;
    private final OrdreDeTravailRepo ordreDeTravailRepo ;

    @Autowired
    public PieceService(PieceRepo pieceRepo, MagasinierRepo magasinierRepo, EquipementRepo equipementRepo, ComposantRepo composantRepo, OrdreDeTravailRepo ordreDeTravailRepo) {
        this.pieceRepo = pieceRepo;
        this.magasinierRepo = magasinierRepo;
        this.equipementRepo = equipementRepo;
        this.composantRepo = composantRepo;
        this.ordreDeTravailRepo = ordreDeTravailRepo;
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
    public Piece savePiece(Piece piece) {
        // Vérifier et définir le Magasinier s'il n'est pas nul
        if (piece.getMagasinier() != null) {
            Optional<Magasinier> magasinierOpt = magasinierRepo.findById(piece.getMagasinier().getID_Magasinier());
            if (magasinierOpt.isPresent()) {
                piece.setMagasinier(magasinierOpt.get());
            } else {
                throw new RuntimeException("Magasinier non trouvé");
            }
        }
        // Vérifier et définir les Equipements s'ils ne sont pas nuls
        if (piece.getEquipements() != null && !piece.getEquipements().isEmpty()) {
            Set<Equipement> validatedEquipements = new HashSet<>();
            for (Equipement equipement : piece.getEquipements()) {
                Optional<Equipement> equipementOpt = equipementRepo.findById(equipement.getID_Equipement());
                if (equipementOpt.isPresent()) {
                    validatedEquipements.add(equipementOpt.get());
                } else {
                    throw new RuntimeException("Equipement non trouvé");
                }
            }
            piece.setEquipements(validatedEquipements);
        }

        // Vérifier et définir les Composants s'ils ne sont pas nuls
        if (piece.getComposants() != null && !piece.getComposants().isEmpty()) {
            Set<Composant> validatedComposants = new HashSet<>();
            for (Composant composant : piece.getComposants()) {
                Optional<Composant> composantOpt = composantRepo.findById(composant.getID_Composant());
                if (composantOpt.isPresent()) {
                    validatedComposants.add(composantOpt.get());
                } else {
                    throw new RuntimeException("Composant non trouvé");
                }
            }
            piece.setComposants(validatedComposants);
        }


        // Enregistrer l'entité Piece
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