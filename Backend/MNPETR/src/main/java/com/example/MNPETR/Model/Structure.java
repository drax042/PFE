package com.example.MNPETR.Model;

import jakarta.persistence.*;
import lombok.*;


import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table (name = "structure")
public class Structure {

    @Id
    @Column(name = "nom_structure")
    private String NomStructure; // Using camelCase for consistency

    @OneToMany(mappedBy = "structure") // mappedBy points to the attribute in Maintenancier
    private Set<Maintenancier> maintenanciers; // Set to handle multiple maintenanciers

    @OneToMany (mappedBy = "structure")
    private Set<Employe> employes ;
}
