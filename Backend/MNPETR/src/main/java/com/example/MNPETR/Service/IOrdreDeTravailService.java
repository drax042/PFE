package com.example.MNPETR.Service;

import com.example.MNPETR.Model.Enum.StatusEquipement;
import com.example.MNPETR.Model.Enum.StatusOT;
import com.example.MNPETR.Model.Equipement;
import com.example.MNPETR.Model.OrdreDeTravail;
import com.example.MNPETR.Model.Piece;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IOrdreDeTravailService {
    List<OrdreDeTravail> getAllOrdreDeTravail();

    Optional<OrdreDeTravail> getOrdreDeTravailById(Integer ID_OT);

    List<OrdreDeTravail> getOrdreDeTravailByDate(Date Date_OT);

    List<OrdreDeTravail> getOrdreDeTravailByTypeOtz(String Type_Otz);

    OrdreDeTravail addOrdreDeTravail(OrdreDeTravail ordreDeTravail, List<Piece> pieces, Equipement equipementMaintenance);

    OrdreDeTravail saveOrdreDeTravail(OrdreDeTravail ordreDeTravail);

    List<OrdreDeTravail> getOrdreDeTravailByStatus(StatusOT statusOT);
}
