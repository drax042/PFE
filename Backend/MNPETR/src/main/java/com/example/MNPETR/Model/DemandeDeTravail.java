package com.example.MNPETR.Model;


import com.example.MNPETR.Model.Enum.StatusDT;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

@Table (name = "demande_de_travail")
public class DemandeDeTravail {

    @Id
    @Column (name = "id_dt")
    private int ID_DT;

    @Column (name = "date_dt")
    private Date Date_DT;

    @Column (name = "description_panne")
    private String Description_Panne;

    @Column(name = "status_dt")
    @Enumerated(EnumType.STRING)
    private StatusDT statusDT;

    @ManyToOne
    @JoinColumn(name = "id_responsable_maintenance")
    private ResponsableMaintenance responsableMaintenance;

    @ManyToOne
    @JoinColumn(name = "id_employe")
    private Employe employe;

    @OneToMany(mappedBy = "demandeDeTravail")
    private Set<Equipement> equipements;

    @Transient
    private int equipementId;


}
