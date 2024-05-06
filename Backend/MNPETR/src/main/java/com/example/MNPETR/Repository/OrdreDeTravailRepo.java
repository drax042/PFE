package com.example.MNPETR.Repository;


import com.example.MNPETR.Model.OrdreDeTravail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrdreDeTravailRepo extends JpaRepository<OrdreDeTravail, Integer> {

    @Query("SELECT ot FROM OrdreDeTravail ot WHERE ot.Date_OT=:ot")
    List<OrdreDeTravail> findByDateOt(Date ot);

    @Query("SELECT ot FROM OrdreDeTravail ot WHERE ot.Type_Otz=:ot")
    List<OrdreDeTravail> findByTypeOtz(String ot);
}
