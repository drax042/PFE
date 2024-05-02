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
    private int ID_Responsable ;

    @OneToMany (mappedBy ="responsable_employe")
    private Set<Employe> employes;
}
