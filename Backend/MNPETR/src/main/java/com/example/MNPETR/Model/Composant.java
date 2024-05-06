package com.example.MNPETR.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity

@Table (name ="composant")
public class Composant {

    @Id
    @Column(name = "id_composant")
    private int ID_Composant;

    @Column(name = "nom_composant")
    private String Nom_Composant;

    @Column(name = "description_composant")
    private String Description_Composant;

    @ManyToMany
    @JoinTable(name = "composant_piece",
    joinColumns = @JoinColumn(name = "id_composant"),
    inverseJoinColumns = @JoinColumn(name = "id_piece"))
    private Set<Piece> pieces;
}
