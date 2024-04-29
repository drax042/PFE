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
public class Structure {

    @Id
    @Column(name = "ID_Structure") // Assuming there's a primary key
    private int idStructure; // Using camelCase for consistency

    @Column(name = "Nom_Structure")
    private String nomStructure; // Using camelCase for consistency
}

