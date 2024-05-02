package com.example.MNPETR.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Set;


@Entity
@Data
public class Structure {

    @Id
    @Column(name = "nom_structure")
    private String Nom_Structure; // Using camelCase for consistency

    @OneToMany(mappedBy = "structure")
    private Set<Employe> employes;
}

