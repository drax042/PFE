package com.example.MNPETR.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor


@Table (name ="Piece")
public class Piece {

    @Id
    @Column (name ="id_piece")
    private int ID_Piece ;

    @Column (name = "nom_piece")
    private String Nom_Piece ;

    @Column (name = "description_piece")
    private String Description_Piece ;

    @Column (name = "quantite_piece")
    private int Quantite_Piece ;

    @OneToMany (mappedBy = "piece")
    private Set<Composant> composants ;

    @ManyToMany
    @JoinTable(name ="piece_equipement",
    joinColumns = @JoinColumn (name ="id_piece"),
    inverseJoinColumns = @JoinColumn (name = "id_equipement"))
    private Set<Equipement> equipements ;


}
