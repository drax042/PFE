package com.example.MNPETR.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table (name = "employe")
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_employe", unique = true, nullable = false)
    private int ID_Employe;

    @Column (name = "nom_employe")
    private String Nom_Employe;

    @Column(name = "prenom_employe")
    private String Prenom_Employe;

    @Column(name = "email_employe")
    private String Email_Employe;

    @Column (name = "poste_employe")
    private String Poste_Employe;

    /*@OneToMany(mappedBy = "employe")
    private Set<DemandeDeTravail> demandesDeTravail;*/

    @ManyToOne
    @JoinColumn(name = "nom_structure")
    private Structure structure;

    @ManyToOne
    @JoinColumn(name = "id_responsable")
    private Responsable responsable;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;
}
