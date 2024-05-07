package com.example.MNPETR.Service;

import com.example.MNPETR.Model.OrdreDeTravail;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IOrdreDeTravailService {
    List<OrdreDeTravail> getAllOrdreDeTravail();

    Optional<OrdreDeTravail> getOrdreDeTravailById(Integer ID_OT);

    List<OrdreDeTravail> getOrdreDeTravailByDate(Date Date_OT);

    List<OrdreDeTravail> getOrdreDeTravailByTypeOtz(String Type_Otz);

    OrdreDeTravail saveOrdreDeTravail(OrdreDeTravail ordreDeTravail);

    void deleteOrdreDeTravail(OrdreDeTravail ordreDeTravail);
}
