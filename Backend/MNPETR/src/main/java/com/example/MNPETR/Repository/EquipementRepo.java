package com.example.MNPETR.Repository;

import com.example.MNPETR.Model.Equipement;
import com.example.MNPETR.Model.OrdreDeTravail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EquipementRepo extends JpaRepository<Equipement, Integer> {


    @Query("select equipement from Equipement equipement where equipement.statusEquipement=:status_equipement")
    List<Equipement> findEquipementByStatus(String status_equipement);

}
