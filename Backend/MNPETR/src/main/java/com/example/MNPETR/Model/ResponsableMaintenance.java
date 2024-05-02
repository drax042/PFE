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

@Table (name = "responsable_maintenance")
public class ResponsableMaintenance {

    @Id
    @Column (name = "id_reponsable_maintenance ")
    private int ID_Responsable_Maintenance ;

    @Column (name = "nom_responsable_maintenance")
    private String Nom_Responsable_Maintenance;

    @Column (name = "prenom_responsable_maintenance")
    private String Prenom_Responsable_Maintenance ;

    @Column (name = "email_responsable_maintenance")
    private String Email_Responsable_Maintenance ;

}
