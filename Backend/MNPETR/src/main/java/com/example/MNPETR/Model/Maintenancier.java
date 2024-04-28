package com.example.MNPETR.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Maintenancier extends EmployesDeMaintenance {
    private String Niveau_intervention;
    private String Domaine_technique;

    public Maintenancier(int matricule, String niveau_intervention, String domaine_technique) {
        super(matricule) ;
        Niveau_intervention = niveau_intervention;
        Domaine_technique = domaine_technique;
    }
}
