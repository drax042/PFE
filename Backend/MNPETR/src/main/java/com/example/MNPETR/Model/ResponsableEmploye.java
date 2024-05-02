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

@Table(name = "responsable_employe")
public class ResponsableEmploye {
    @Id
    @Column(name = "id_responsable_employe")
    private int ID_Responsable_Employe ;

    @Column (name = "nom_responsable_employe")
    private String Nom_Responsable_Employe;

    @Column (name = "prenom_responsable_employe")
    private String Prenom_Responsable_Employe ;

    @Column (name = "email_responsable_employe")
    private String Email_Responsable_Employe ;

    @OneToMany (mappedBy ="responsable_employe")
    private Set<Employe> employes;
}
