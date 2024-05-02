package com.example.MNPETR.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table (name = "poste_technique")
public class PosteTechnique {

    @Id
    @Column (name = "id_poste_technique")
    private  int ID_Poste_Technique ;

    @Column(name = "nom_poste_technique")
    private String Nom_Poste_Technique;

    @Column(name = "secteur")
    private String Secteur;

    @OneToMany(mappedBy = "poste_technique")
    private Set<Equipement> equipements;
}
