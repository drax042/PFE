package com.example.MNPETR.Repository;

import com.example.MNPETR.Model.OrdreDeTravail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrdreDeTravailRepo extends JpaRepository<OrdreDeTravail, Integer> {

    @Query("SELECT ot FROM OrdreDeTravail ot WHERE ot.Date_OT = :date_ot")
    List<OrdreDeTravail> findByDateOt(@Param("date_ot") Date date_ot);

    @Query("SELECT ot FROM OrdreDeTravail ot WHERE ot.Type_Otz = :type_otz")
    List<OrdreDeTravail> findByTypeOtz(@Param("type_otz") String type_otz);
}
