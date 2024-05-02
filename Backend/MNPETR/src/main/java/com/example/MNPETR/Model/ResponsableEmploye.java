package com.example.MNPETR.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ResponsableEmploye {

    @Id
    @Column(name = "id_responsable_employe")
    private int ID_Responsable;

    @Column(name = "nom_responsable_maintenance")
    private String Nom_responsable_emoloye;

    @Column(name = "prenom_responsable_maintenance")
    private String Prenom_Responsable_Maintenance;

    @Column(name = "email_responsable_maintenance")
    private String Email_Responsable_Maintenance;

    @OneToMany(mappedBy = "responsable_employe")
    private Set<Employe> employes;
}
