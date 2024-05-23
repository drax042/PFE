package com.example.MNPETR.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", unique = true, nullable = false)
    private int id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @OneToOne
    @JoinColumn(name = "id_responsable_maintenance")
    private ResponsableMaintenance responsableMaintenance;

    @OneToOne
    @JoinColumn(name = "id_responsable")
    private Responsable responsable;

    @OneToOne
    @JoinColumn(name = "id_preparateur_maintenance")
    private PreparateurMaintenance preparateurMaintenance;

    @OneToOne
    @JoinColumn(name = "id_maintenancier")
    private Maintenancier maintenancier;

    @OneToOne
    @JoinColumn(name = "id_magasinier")
    private Magasinier magasinier;

    @OneToOne
    @JoinColumn(name = "id_employe")
    private Employe employe;

    @ManyToMany
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Roles> roles;

    @OneToMany (mappedBy = "user")
    private Set<Notification> notifications;

    @OneToMany(mappedBy = "user")
    private Set<DemandeDeTravail> demandeDeTravails;

}
