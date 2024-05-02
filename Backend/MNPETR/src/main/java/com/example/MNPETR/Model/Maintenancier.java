package com.example.MNPETR.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Maintenancier {

    @Id
    @Column(name = "id_maintenancier") // Assuming there's a primary key
    private int ID_Maintenancier;// Using camelCase for consistency

    @Column(name ="nom_maintenancier")
    private String Nom_Maintenancier;

    @Column(name ="prenom_maintenancier")
    private String Prenom_Maintenancier;

    @Column(name = "email_maintenancier")
    private String Email_Maintenancier;

    @Column(name = "niveau_intervention")
    private String Niveau_Intervention; // Using camelCase for consistency

    @Column(name = "domaine_technique")
    private String Domaine_Technique; // Using camelCase for consisten

    @ManyToOne
    @JoinColumn(name = "id_responsable_maintenance")
    private ResponsableMaintenance responsableMaintenance;

    @ManyToMany
    @JoinTable(name = "maintenancier_equipement",
    joinColumns = @JoinColumn(name = "id_maintenancier"),
    inverseJoinColumns= @JoinColumn(name = "id_equipement"))
    private Set<Equipement> equipements;
}
