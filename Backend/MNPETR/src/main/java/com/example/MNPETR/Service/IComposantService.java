package com.example.MNPETR.Service;

import com.example.MNPETR.Model.Composant;

import java.util.List;
import java.util.Optional;

public interface IComposantService {
    List<Composant> getAllComposant();

    Optional<Composant> getComposantById(int ID_Composant);

    Composant SaveComposant(Composant composant);

    void deleteComposant(Composant composant);
}
