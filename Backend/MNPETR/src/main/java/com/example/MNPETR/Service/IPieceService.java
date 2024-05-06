package com.example.MNPETR.Service;

import com.example.MNPETR.Model.Piece;

import java.util.List;
import java.util.Optional;

public interface IPieceService {
    List<Piece> getAllPiece();

    Optional<Piece> getPieceById(Integer ID_Piece);

    List<Piece> getPieceByType(String Type_Piece);

    List<Piece> getPieceByName(String Nom_Piece);

    void savePiece(Piece piece);

    void deletePiece(Piece piece);


}
