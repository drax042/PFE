package com.example.MNPETR.Repository;

import com.example.MNPETR.Model.Piece;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PieceRepo extends JpaRepository<Piece, Integer> {

    @Query("SELECT piece FROM Piece piece WHERE piece.Type_Piece=:piece")
    List<Piece> findByTypePiece(String piece); //Pour trouver les pieces par Type

    @Query("SELECT piece FROM Piece piece WHERE piece.Nom_Piece=:piece")
    List<Piece> findByNamePiece(String piece);  //Pour trouver les pieces par Nom

}