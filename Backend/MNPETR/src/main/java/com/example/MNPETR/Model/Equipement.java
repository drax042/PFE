package com.example.MNPETR.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "equipement")
public class Equipement {

    @Id
    @Column(name = "id_equipement")
    private int ID_Equipement; // Using camelCase for consistency

    @Column(name = "nom_equipement")
    private String NomEquipement; // Using camelCase for consistency

    @Column(name = "etat_equipement")
    private String Etat_Equipement; // Using camelCase for consistency

    @ManyToOne
    @JoinColumn (name = "poste_technique")
    private PosteTechnique poste_technique ;

    @ManyToMany (mappedBy = "equipements")
    private Set<Piece> pieces ;


}


