package com.example.MNPETR.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Set;

@Data
@Entity

public class ResponsableEmploye {
    @Id
    @Column(name = "id_responsable_employe")
    private int ID_Responsable_Employe ;

    @Column (name = "nom_responsable_employe")
    private String Nom_Responsable_Employe;

    @Column (name = "prenom_responsable_employe")
    private String Prenom_Responsable_Employe ;

    @Column (name = "email_responsable_employe")
    private String Email_Responsable_Maintenance ;

    @OneToMany (mappedBy ="responsable_employe")
    private Set<Employe> employes;
}
