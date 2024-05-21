package com.example.MNPETR.Service;

import com.example.MNPETR.Model.Enum.StatusEquipement;
import com.example.MNPETR.Model.Equipement;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IEquipementService {
    List<Equipement> getAllEquipements();

    Optional<Equipement> getEquipementById(int ID_Equipement);

    Equipement saveEquipement(Equipement equipement);

    List<Equipement> getEquipementByStatus(String statusEquipement);

    void deleteEquipement(Equipement equipment);

    ResponseEntity<Object> updateEquipementStatus(Integer id, StatusEquipement newStatusEquipement);
}
