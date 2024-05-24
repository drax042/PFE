package com.example.MNPETR.Model;

import com.example.MNPETR.Model.Enum.StatusOT;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

@Table(name = "ordre_de_travail")
public class OrdreDeTravail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ot")
    private int ID_OT;

    @Column(name = "tot_horaire")
    private int Tot_Horaire;

    @Column(name = "duree")
    private int Duree;

    @Column (name = "date_ot")
    private Date Date_OT;

    @Column(name = "description_panne")
    private String Description_Panne;

    @Column(name = "type_otz")
    private String Type_Otz;

    @Column(name = "status_ot")
    @Enumerated(EnumType.STRING)
    private StatusOT statusOT;

    @ManyToMany(mappedBy = "ordresDeTravail") // mappedBy fait référence à l'attribut dans Maintenancier
    private Set<Maintenancier> maintenanciers; // Ensemble pour gérer plusieurs Maintenancier

    @ManyToOne
    @JoinColumn(name = "id_responsable_maintenance")
    private ResponsableMaintenance responsableMaintenance;

    @ManyToOne
    @JoinColumn (name = "id_magasinier")
    private Magasinier magasinier ;

    @OneToMany (mappedBy = "ordreDeTravail")
    private Set<Equipement> equipements;

    /*@OneToMany(mappedBy = "ordreDeTravail")
    private Set<Piece> pieces;*/

    @Transient
    private int pieceID;

    @Transient
    private int quantityNeeded;

}

