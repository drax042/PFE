package com.example.MNPETR.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "responsable")
public class Responsable {
    @Id
    @Column(name = "id_responsable", unique = true, nullable = false)
    private int ID_Responsable;

    @Column (name = "nom_responsable")
    private String Nom_Responsable;

    @Column (name = "prenom_responsable")
    private String Prenom_Responsable;

    @Column (name = "email_responsable")
    private String Email_Responsable;

    @OneToMany (mappedBy ="responsable")
    private Set<Employe> employes;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;

}
