package com.example.MNPETR.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table (name = "responsable_maintenance")
public class ResponsableMaintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_responsable_maintenance", unique = true, nullable = false)
    private int ID_Responsable_Maintenance;

    @Column (name = "nom_responsable_maintenance")
    private String Nom_Responsable_Maintenance;

    @Column (name = "prenom_responsable_maintenance")
    private String Prenom_Responsable_Maintenance ;

    @Column (name = "email_responsable_maintenance")
    private String Email_Responsable_Maintenance ;

    /*@OneToMany(mappedBy = "responsableMaintenance")
    private Set<Maintenancier> maintenanciers;*/

    /*@OneToMany(mappedBy = "responsableMaintenance")
    private Set<OrdreDeTravail> ordreDeTravails;*/

    /*@OneToMany(mappedBy = "responsableMaintenance")
    private Set<DemandeDeTravail> demandeDeTravails;*/

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;

}
