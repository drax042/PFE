package com.example.MNPETR.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

import java.util.Set;

@Entity
@Data
@Table(name = "maintenancier")
public class Maintenancier {

    @Id
    @Column(name = "id_maintenancier", unique = true, nullable = false) // Assuming there's a primary key
    private int ID_Maintenancier;

    @Column(name ="nom_maintenancier")
    private String Nom_Maintenancier;

    @Column(name ="prenom_maintenancier")
    private String Prenom_Maintenancier;

    @Column (name = "email_maintenancier")
    private String Email_Maintenanicer ;

    @Column(name = "niveau_intervention")
    private String Niveau_Intervention; // Using camelCase for consistency

    @Column(name = "domaine_technique")
    private String Domaine_Technique; // Using camelCase for consistency

    @ManyToMany
    @JoinTable(name = "ot_maintenancier", // Join table name
            joinColumns = @JoinColumn(name = "id_ot"), // Foreign key for OrdreDeTravail
            inverseJoinColumns = @JoinColumn(name = "id_maintenancier")) // Foreign key for Maintenancier
    private Set<OrdreDeTravail> ordresDeTravail; // Set to handle multiple ordresDeTravail

    @ManyToOne
    @JoinColumn(name = "id_responsable_maintenance")
    private ResponsableMaintenance responsableMaintenance;

    @ManyToOne
    @JoinColumn(name = "nom_structure")
    private Structure structure;


    @ManyToMany
    @JoinTable (name = "maintenancier_equipement",
    joinColumns  = @JoinColumn (name = "id_maintenancier"),
    inverseJoinColumns = @JoinColumn (name = "id_equipement"))
    private Set<Equipement> equipements ;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;

}


