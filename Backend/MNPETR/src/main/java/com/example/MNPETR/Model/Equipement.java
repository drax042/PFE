package com.example.MNPETR.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "equipement")
public class Equipement {

    @Id
    @Column(name = "id_equipement")
    private int ID_Equipement; // Using camelCase for consistency

    @Column(name = "nom_equipement")
    private String Nom_Equipement; // Using camelCase for consistency

    @Column(name = "description_equipement")
    private String Description_Equipement;

    @Column(name = "etat_equipement")
    private String Etat_Equipement; // Using camelCase for consistency

    @ManyToMany(mappedBy = "equipements")
    private Set<Piece> pieces;

    @ManyToOne
    @JoinColumn(name = "id_poste_technique")
    private PosteTechnique poste_technique;

    @ManyToOne
    @JoinColumn(name = "id_preparateur_maintenance")
    private PreparateurMaintenance preparateur_maintenance;

    @ManyToMany(mappedBy = "equipements")
    private Set<Maintenancier> maintenanciers;


}


