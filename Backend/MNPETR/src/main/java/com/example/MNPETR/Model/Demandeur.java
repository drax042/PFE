package com.example.MNPETR.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table (name = "Demandeur")
public class Demandeur {
    @Id
    @Column (name = "ID_DemandeurDT")
    private int ID_DemandeurDT;
    @Column (name = "NomDemandeur")
    private String NomDemandeur;
    @Column (name = "Poste")
    private String Poste;

}
