package com.example.MNPETR.Repository;

import com.example.MNPETR.Model.Piece;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PieceRepo extends JpaRepository<Piece,Integer>{

        @Query("select piece from  Piece piece WHERE piece.Type_Piece =:type_piece")
        List<Piece> findPieceByTypePiece(String type_piece);

        @Query("select piece From Piece piece where piece.Nom_Piece =:nom_piece")
        List<Piece> findPieceByNomPiece(String nom_piece) ;

}
