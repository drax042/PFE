package com.example.MNPETR.Model;

import jakarta.persistence.*;
import lombok.*;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.util.Date;
import java.util.Set;

@Entity
@Data

@Table(name = "ordre_de_travail")
public class OrdreDeTravail {
    @Id
    @Column(name = "id_ot")
    private int ID_OT;

    @Column(name = "tot_horaire")
    private int Tot_Horaire;

    @Column(name = "duree")
    private int Duree;

    @Column(name = "date_ot")
    private Date date_OT ;

    @Column(name = "description_panne", length = 255)
    private String Description_Panne;

    @Column(name = "type_otz")
    private String type_Otz;

    @ManyToMany(mappedBy = "ordresDeTravail") // mappedBy fait référence à l'attribut dans Maintenancier
    private Set<Maintenancier> maintenanciers; // Ensemble pour gérer plusieurs Maintenancier

    @ManyToOne
    @JoinColumn (name = "id_magasinier")
    private Magasinier magasinier ;

}
