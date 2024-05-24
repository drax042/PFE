package com.example.MNPETR.Model;

import com.example.MNPETR.Model.Enum.StatusEquipement;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipement")
    private int ID_Equipement; // Using camelCase for consistency

    @Column(name = "nom_equipement")
    private String Nom_Equipement; // Using camelCase for consistency

    @Column(name = "description_equipement")
    private String Description_Equipement;

    @Column(name = "status_equipement")
    private StatusEquipement statusEquipement;

    @ManyToMany(mappedBy = "equipements") //cbon
    private Set<Piece> pieces;

    @ManyToOne
    @JoinColumn(name = "id_poste_technique")
    private PosteTechnique poste_technique;

    @ManyToOne
    @JoinColumn(name = "id_preparateur_maintenance")
    private PreparateurMaintenance preparateur_maintenance;

    @ManyToMany(mappedBy = "equipements")
    private Set<Maintenancier> maintenanciers;

    @ManyToOne
    @JoinColumn(name = "id_dt")
    private DemandeDeTravail demandeDeTravail;

    @ManyToOne
    @JoinColumn(name = "id_ot")
    private OrdreDeTravail ordreDeTravail;

}


