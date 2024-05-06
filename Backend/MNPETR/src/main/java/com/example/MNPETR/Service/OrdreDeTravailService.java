package com.example.MNPETR.Service;

import com.example.MNPETR.Model.OrdreDeTravail;
import com.example.MNPETR.Repository.OrdreDeTravailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrdreDeTravailService implements IOrdreDeTravailService {
    public final OrdreDeTravailRepo ordreDeTravailRepo;
    @Autowired
    public OrdreDeTravailService(OrdreDeTravailRepo ordreDeTravailRepo) {
        this.ordreDeTravailRepo = ordreDeTravailRepo;
    }

    @Override
    public List<OrdreDeTravail> getAllOrdreDeTravail() {
        return ordreDeTravailRepo.findAll();
    }

    @Override
    public Optional<OrdreDeTravail> getOrdreDeTravailById(Integer ID_OT) {
        return ordreDeTravailRepo.findById(ID_OT);
    }

    @Override
    public List<OrdreDeTravail> getOrdreDeTravailByDate(Date Date_OT) {
        return ordreDeTravailRepo.findByDateOt(Date_OT);
    }

    @Override
    public List<OrdreDeTravail> getOrdreDeTravailByTypeOtz(String Type_Otz){
        return ordreDeTravailRepo.findByTypeOtz(Type_Otz);
    }

    @Override
    public OrdreDeTravail save(OrdreDeTravail ordreDeTravail) {
        return ordreDeTravailRepo.save(ordreDeTravail);
    }

    @Override
    public void delete(OrdreDeTravail ordreDeTravail) {
        ordreDeTravailRepo.delete(ordreDeTravail);
    }

}
