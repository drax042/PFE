package com.example.MNPETR.Repository;

import com.example.MNPETR.Model.Piece;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PieceRepo extends JpaRepository<Piece, Integer> {

    List<Piece> findByTypePiece(String Type_Piece); //Pour trouver les pieces par Type
    List<Piece> findByNamePiece(String Nom_Piece);  //Pour trouver les pieces par Nom

}