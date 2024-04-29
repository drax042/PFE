package com.example.MNPETR.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "Equipement")
public class Equipement {

    @Id
    @Column(name = "ID_Equipement")
    private int idEquipement; // Using camelCase for consistency

    @Column(name = "Nom_Equipement")
    private String nomEquipement; // Using camelCase for consistency

    @Column(name = "Etat_Equipement")
    private String etatEquipement; // Using camelCase for consistency
}


