package com.example.MNPETR.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor


@Table(name ="composant")
public class Composant {

        @Id
        @Column(name ="id_composant")
        private int ID_Composant ;
        @Column (name = "nom_composant")
        private String Nom_Composant ;
        @Column (name = "description_composant")
        private String Description_Composant ;

@ManyToOne
@JoinColumn(name = "id_piece")
        private Piece piece ;

}
