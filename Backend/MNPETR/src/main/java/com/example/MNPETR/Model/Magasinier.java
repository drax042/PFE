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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_magasinier", unique = true, nullable = false)
    private int ID_Magasinier;

    @Column(name = "nom_magasinier")
    private String Nom_Magasinier;

    @Column (name = "prenom_magasinier")
    private String Prenom_Magasinier ;

    @Column (name = "email_magasinier")
    private String Email_Magasinier ;

    /*@OneToMany(mappedBy = "magasinier")
    private Set<Piece> pieces;*/

    /*@OneToMany (mappedBy = "magasinier")
    private Set<OrdreDeTravail> ordresDeTravail ;*/

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;

}

