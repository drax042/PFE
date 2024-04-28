package com.example.MNPETR.Model;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor

public class Structure {
    public Structure(String nomStructure) {
        NomStructure = nomStructure;
    }

    public String getNomStructure() {
        return NomStructure;
    }

    public void setNomStructure(String nomStructure) {
        this.NomStructure = nomStructure;
    }

    String NomStructure ;
}
