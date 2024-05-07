package com.example.MNPETR.Service;

import com.example.MNPETR.Model.Equipement;

import java.util.List;
import java.util.Optional;

public interface IEquipementService {
    List<Equipement> getAllEquipements();

    Optional<Equipement> getEquipementById(Integer ID_Equipement);

    Equipement saveEquipement(Equipement equipement);

    void deleteEquipement(Equipement equipment);
}
