package com.example.MNPETR.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Maintenancier {

    @Id
    @Column(name = "ID_Maintenancier") // Assuming there's a primary key
    private int ID_Maintenancier; // Using camelCase for consistency

    @Column(name = "Niveau_intervention")
    private String niveauIntervention; // Using camelCase for consistency

    @Column(name = "Domaine_technique")
    private String domaineTechnique; // Using camelCase for consistency
}
