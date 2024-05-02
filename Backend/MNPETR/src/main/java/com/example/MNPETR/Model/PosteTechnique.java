package com.example.MNPETR.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity


@Table (name = "poste_technique")
public class PosteTechnique {

    @Id
    @Column (name = "id_poste_Technique")
    private  int ID_Poste_Technique ;
    @Column (name ="secteur")
    private int Secteur ;

    @OneToMany (mappedBy = "poste_technique")
    private Set<Equipement> equipements ;
}
