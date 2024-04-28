package com.example.MNPETR.Model;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter

public class ResponsableDeMaintenance extends EmployesDeMaintenance{

    public ResponsableDeMaintenance(int matricule) {
  super(matricule);
    }
}
