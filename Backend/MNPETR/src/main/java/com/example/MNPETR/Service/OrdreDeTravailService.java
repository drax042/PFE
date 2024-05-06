package com.example.MNPETR.Service;

import com.example.MNPETR.Model.OrdreDeTravail;
import com.example.MNPETR.Repository.OrdreDeTravailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrdreDeTravailService {
    public final OrdreDeTravailRepo ordreDeTravailRepo;
    @Autowired
    public OrdreDeTravailService(OrdreDeTravailRepo ordreDeTravailRepo) {
        this.ordreDeTravailRepo = ordreDeTravailRepo;
    }

    public List<OrdreDeTravail> getAllOrdreDeTravail() {
        return ordreDeTravailRepo.findAll();
    }

    public Optional<OrdreDeTravail> getOrdreDeTravailById(Integer ID_OT) {
        return ordreDeTravailRepo.findById(ID_OT);
    }

    public List<OrdreDeTravail> getOrdreDeTravailByDate(Date Dates_Ot) {
        return ordreDeTravailRepo.findByDateOt(Dates_Ot);
    }

    public List<OrdreDeTravail> getOrdreDeTravailByTypeOtz(String Type_Otz){
        return ordreDeTravailRepo.findByTypeOtz(Type_Otz);
    }

    public OrdreDeTravail save(OrdreDeTravail ordreDeTravail) {
        return ordreDeTravailRepo.save(ordreDeTravail);
    }

    public void delete(OrdreDeTravail ordreDeTravail) {
        ordreDeTravailRepo.delete(ordreDeTravail);
    }

}
