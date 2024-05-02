package com.example.MNPETR.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

@Table (name = "responsable_de_maintenance")
public class ResponsableMaintenance {

    @Id
    @Column(name = "id_responsable_maintenance ")
    private int ID_Responsable_Maintenance;

    @Column(name = "nom_responsable_maintenance")
    private String Nom_Responsable_Maintenance;

    @Column(name = "prenom_responsable_maintenance")
    private String Prenom_Responsable_Maintenance;

    @Column(name = "email_responsable_maintenance")
    private String Email_Responsable_Maintenance;

    @OneToMany(mappedBy = "responsableMaintenance")
    private Set<Maintenancier> maintenanciers;

    @OneToMany(mappedBy = "responsableMaintenance")
    private Set<OrdreDeTravail> ordreDeTravails;

    @OneToMany(mappedBy = "responsableMaintenance")
    private Set<DemandeDeTravail> demandeDeTravails;

}
