package com.example.MNPETR.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

@Table (name = "ResponsableDeMaintenance")
public class ResponsableDeMaintenance {

    @Id
    @Column (name = "ID_ResponsableDeMaintenance ")
    private int ID_ResponsableDeMaintenance ;
}
