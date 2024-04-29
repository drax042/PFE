package com.example.MNPETR.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

@Table(name = "OrdreDeTravail")
public class OrdreDeTravail {
    @Id
    @Column(name = "ID_OT")
    private int ID_OT;

    @Column(name = "tot_horaire")
    private int Tot_Horaire;

    @Column(name = "duree")
    private int Duree;

    @Column(name = "description_panne")
    private String Description_Panne;

    @Column(name = "type_otz")
    private String Type_Otz;

    @Column(name = "date")
    private Date Date;
}
