package com.example.MNPETR.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Data

public class Maintenancier {

    @Id
    @Column(name = "id_maintenancier") // Assuming there's a primary key
    private int ID_Maintenancier;// Using camelCase for consistency

    @Column(name = "nom_maintenancier")
    private int Nom_Maintenancier;

    @Column(name = "niveau_intervention")
    private String Niveau_Intervention; // Using camelCase for consistency

    @Column(name = "domaine_technique")
    private String Domaine_Technique; // Using camelCase for consistency

    @ManyToMany
    @JoinTable(name = "ot_maintenancier", // Join table name
            joinColumns = @JoinColumn(name = "id_OT"), // Foreign key for OrdreDeTravail
            inverseJoinColumns = @JoinColumn(name = "id_maintenancier")) // Foreign key for Maintenancier
    private Set<OrdreDeTravail> ordresDeTravail; // Set to handle multiple ordresDeTravail

    // Optional annotation for a one-to-one relationship with a nullable foreign key
    @ManyToOne
    private Structure structure;

    // Getters and setters for ordresDeTravail and structure (optional with @Getter @Setter)
}
