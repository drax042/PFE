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

@Table (name = "responsable")
public class Responsable {

    @Id
    @Column (name = "id_reponsable ")
    private int ID_Responsable ;

    @Column (name = "secteur")
    private int Secteur ;
}
