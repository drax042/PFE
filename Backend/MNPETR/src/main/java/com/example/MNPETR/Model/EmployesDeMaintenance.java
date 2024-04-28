package com.example.MNPETR.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor

@ToString
public class EmployesDeMaintenance {
    private int Matricule;

    public EmployesDeMaintenance(int matricule) {
        Matricule = matricule;
    }
}
