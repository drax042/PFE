package com.example.MNPETR.Repository;


import com.example.MNPETR.Model.Enum.StatusEquipement;
import com.example.MNPETR.Model.Enum.StatusOT;
import com.example.MNPETR.Model.OrdreDeTravail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrdreDeTravailRepo extends JpaRepository<OrdreDeTravail, Integer> {

    @Query("SELECT ot FROM OrdreDeTravail ot WHERE ot.Date_OT=:date_ot")
    List<OrdreDeTravail> findByDateOt(Date date_ot);

    @Query("SELECT ot FROM OrdreDeTravail ot WHERE ot.Type_Otz=:type_ot")
    List<OrdreDeTravail> findByTypeOtz(String type_ot);

    @Query("select ot from OrdreDeTravail ot where ot.statusOT=:status_ot")
    List<OrdreDeTravail> findOrdreDeTravailByStatus(StatusOT status_ot);
}
