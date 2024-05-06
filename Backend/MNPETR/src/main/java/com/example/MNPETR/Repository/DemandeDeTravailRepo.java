package com.example.MNPETR.Repository;

import com.example.MNPETR.Model.DemandeDeTravail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DemandeDeTravailRepo extends JpaRepository<DemandeDeTravail ,Integer> {

    @Query("SELECT dt FROM DemandeDeTravail dt WHERE dt.Date_DT =:date_dt")
    List<DemandeDeTravail> findDemandeDeTravailByDate_DT(Date date_dt);

}