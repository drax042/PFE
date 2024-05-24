package com.example.MNPETR.Repository;

import com.example.MNPETR.Model.DemandeDeTravail;
import com.example.MNPETR.Model.Enum.StatusDT;
import com.example.MNPETR.Model.OrdreDeTravail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface DemandeDeTravailRepo extends JpaRepository<DemandeDeTravail ,Integer> {
        //public  List<DemandeDeTravail> findDemandeDeTravailByDate_DT(Date Date_DT);
        @Query("SELECT dt FROM DemandeDeTravail dt WHERE dt.Date_DT = :date_dt")
        List<DemandeDeTravail> findDemandeDeTravailByDate_DT(Date date_dt);

        @Query("select dt from DemandeDeTravail dt where dt.statusDT=:status_dt")
        List<DemandeDeTravail> findDemandeDeTravailByStatus(StatusDT status_dt);


}
