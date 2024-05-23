package com.example.MNPETR.Service;

import com.example.MNPETR.Model.DemandeDeTravail;
import com.example.MNPETR.Model.User;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IDemandeDeTravailService {
    List<DemandeDeTravail> getAllDemandeDeTravail();

    Optional<DemandeDeTravail> getDemandeDeTravailByID(Integer ID_DemandeDeTravail);

    DemandeDeTravail saveDemandeDeTravail(DemandeDeTravail demandeDeTravail, User user);

    List<DemandeDeTravail> getDemandeDeTravailByDateDT(Date Date_DT);

    List<DemandeDeTravail> getDemandeDeTravailByStatus(String status);
}
