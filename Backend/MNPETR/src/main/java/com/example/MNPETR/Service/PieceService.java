package com.example.MNPETR.Service;

import com.example.MNPETR.Model.Piece;
import com.example.MNPETR.Repository.PieceRepo;
import org.springframework.beans.factory.annotation.Autowired;
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
    public  void savePiece(Piece piece){
        pieceRepo.save(piece) ;
    }

    @Override
    public void deletePiece(Piece piece) {
        pieceRepo.delete(piece);
    }


    }





