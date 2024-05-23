package com.example.MNPETR.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "preparateur_maintenance")
public class PreparateurMaintenance {

    @Id
    @Column(name = "id_preparateur_maintenance", unique = true, nullable = false)
    private int ID_Preparateur_Maintenance;

    @Column(name ="nom_preparateur_maintenance")
    private String Nom_Preparateur_Maintenance;

    @Column (name = "prenom_preparateur_maintenance")
    private String Prenom_Preparateur_Maintenance ;

    @Column (name = "email_preparateur_maintenance")
    private String Email_Preparateur_Maintenance ;


    /*@OneToMany (mappedBy ="preparateur_maintenance")
    private Set<Equipement> equipements ;*/

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;

}
