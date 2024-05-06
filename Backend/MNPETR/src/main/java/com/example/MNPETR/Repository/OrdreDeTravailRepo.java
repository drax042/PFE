package com.example.MNPETR.Repository;


import com.example.MNPETR.Model.OrdreDeTravail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrdreDeTravailRepo extends JpaRepository<OrdreDeTravail, Integer> {

    List<OrdreDeTravail> findByDateOt(Date Date_OT);
    List<OrdreDeTravail> findByTypeOtz(String Type_Otz);
}
