package com.example.MNPETR.Model;

import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table (name = "employe")
public class Employe {
    @Id
    @Column (name = "id_employe")
    private int ID_Employe;
    @Column (name = "nom_employe")
    private String Nom_Employe;
    @Column (name = "poste")
    private String Poste;

    @ManyToOne
    @JoinColumn(name = "nom_structure")
    private Structure structure ;

    @ManyToOne
    @JoinColumn(name = "id_responsable_employe")
    private ResponsableEmploye responsable_employe ;
}
