package com.example.MNPETR.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data

@Table (name = "preparateur_maintenace")
public class PreparateurMaintenance {

    @Id
    @Column(name = "id_preparateur_maintenance") // Assuming there's a primary key
    private int ID_Preparateur_Maintenance;// Using camelCase for consistency

    @Column(name = "nom_preparateur_maintenance")
    private int Nom_Preparateur_Maintenance;

    @Column (name = "prenom_preparateur_maintenance")
    private String Prenom_Preparateur_Maintenance ;

    @Column (name = "email_preparateur_maintenance")
    private String Email_Preparateur_Maintenance ;


    @OneToMany (mappedBy ="preparateur_maintenance")
    private Set<Equipement> equipements ;
}
