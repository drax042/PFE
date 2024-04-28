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

    public Maintenancier(int Matricule, String Niveau_intervention, String Domaine_technique) {
        super(Matricule);
        this.Niveau_intervention = Niveau_intervention;
        this.Domaine_technique = Domaine_technique;
    }
}
