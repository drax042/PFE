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

@Table(name = "magasinier")
public class Magasinier {

    @Id
    @Column(name = "id_magasinier")
    private int ID_Magasinier;

    @Column(name = "nom_magasinier")
    private String Nom_Magasinier;

    @Column (name = "num_telephone")
    private int NumTelephone ;

    @OneToMany (mappedBy = "magasinier")
    private Set<OrdreDeTravail> ordresDeTravail ;


}
