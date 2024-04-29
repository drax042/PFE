package com.example.MNPETR.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "Magasinier")
public class Magasinier {

    @Id
    @Column(name = "ID_Magasinier")
    private int idMagasinier;

    @Column(name = "Nom_Magasinier")
    private String nomMagasinier;

}
