package com.example.MNPETR.Service;

import com.example.MNPETR.Model.DemandeDeTravail;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IDemandeDeTravailService {
    List<DemandeDeTravail> getAllDemandeDeTravail();

    Optional<DemandeDeTravail> getDemandeDeTravailByID(Integer ID_DT);

    void saveDemandeDeTravail(DemandeDeTravail demandeDeTravail);

    void deleteDemandeDeTravail(DemandeDeTravail demandeDeTravail);

    List<DemandeDeTravail> findDemandeDeTravailByDateDT(Date Date_DT);
}
