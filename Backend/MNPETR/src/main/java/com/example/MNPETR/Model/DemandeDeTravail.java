package com.example.MNPETR.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter

@Table (name = "demande_de_travail")
public class DemandeDeTravail {

    @Id
    @Column (name = "id_dt")
    private int ID_DT;
    @Column (name = "date_heure")
    private Date Date_Heure;
    @Column (name = "description _panne")
    private String Description_Panne;



}
