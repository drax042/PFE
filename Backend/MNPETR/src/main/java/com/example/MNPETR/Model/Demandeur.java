package com.example.MNPETR.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class Demandeur {
    private int ID_DemandeurDT;
    private String NomDemandeur;
    private String Poste;
    private String FilialeDemandeur;

}
