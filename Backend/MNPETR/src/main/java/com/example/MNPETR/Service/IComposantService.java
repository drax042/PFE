package com.example.MNPETR.Service;

import com.example.MNPETR.Model.Composant;

import java.util.List;
import java.util.Optional;

public interface IComposantService {
    List<Composant> getAllComposants();

    Optional<Composant> getComposantById(Integer ID_Composant);

    List<Composant> getComposantByNomComposant(String Nom_Composant);

    Composant saveComposant(Composant composant);

    void deleteComposant(Composant composant);
}
