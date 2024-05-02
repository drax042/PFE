package com.example.MNPETR.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

@Table(name = "ordre_de_travail")
public class OrdreDeTravail {
    @Id
    @Column(name = "id_ot")
    private int ID_OT;

    @Column(name = "tot_horaire")
    private int Tot_Horaire;

    @Column(name = "duree")
    private int Duree;

    @Column (name = "date_ot")
    private Date Date_OT;

    @Column(name = "description_panne")
    private String Description_Panne;

    @Column(name = "type_otz")
    private String Type_Otz;


    @ManyToOne
    @JoinColumn(name = "id_responsable_maintenance")
    private ResponsableMaintenance responsableMaintenance;


}
