package com.example.MNPETR.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data

@Table(name = "piece")
public class Piece {
    @Id
    @Column(name="id_piece")
    private int ID_Piece;

    @Column(name = "nom_piece")
    private int Nom_Piece;

    @Column(name = "dscription_piece")
    private int Dscription_Piece;

    @Column(name = "quantite")
    private int Quantite;

    @ManyToOne
    @JoinColumn(name="id_magasinier")
    private Magasinier magasinier;

    @ManyToMany
    @JoinTable(name = "piece_equipement",
    joinColumns = @JoinColumn(name = "id_piece"),
    inverseJoinColumns = @JoinColumn(name = "id_equipement"))
    private Set<Equipement> equipements;

    @OneToMany (mappedBy = "pieces")
    private Set<Composant> composants;
}
