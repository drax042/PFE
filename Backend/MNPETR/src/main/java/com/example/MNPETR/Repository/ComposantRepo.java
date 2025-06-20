package com.example.MNPETR.Repository;

import com.example.MNPETR.Model.Composant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComposantRepo extends JpaRepository<Composant,Integer> {

    @Query("SELECT composant from Composant composant WHERE composant.Nom_Composant=:nom_composant")
    List<Composant> findComposantByNomComposant(String nom_composant);

}
