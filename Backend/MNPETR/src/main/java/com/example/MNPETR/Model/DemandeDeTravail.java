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

@Table (name = "DemandeDeTravail")
public class DemandeDeTravail {

    @Id
    @Column (name = "ID_DT")
    private int ID_DT;
    @Column (name = "Date_Heure")
    private Date Date_Heure;
    @Column (name = "DescriptionPanne")
    private String Description_Panne;

}
