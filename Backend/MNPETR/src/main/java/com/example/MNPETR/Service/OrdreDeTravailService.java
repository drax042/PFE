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
    public OrdreDeTravail saveOrdreDeTravail(OrdreDeTravail ordreDeTravail) {
        return ordreDeTravailRepo.save(ordreDeTravail);
    }

    @Override
    public void deleteOrdreDeTravail(OrdreDeTravail ordreDeTravail) {
        ordreDeTravailRepo.delete(ordreDeTravail);
    }

    @Override
    public Boolean etatOrdreDeTravail(Integer ID_OT, boolean Termine) {
        Optional<OrdreDeTravail> ordreDeTravailOptional = ordreDeTravailRepo.findById(ID_OT);
        if (ordreDeTravailOptional.isPresent()) {
            OrdreDeTravail ordreDeTravail = ordreDeTravailOptional.get();
            ordreDeTravail.setTermine(Termine);
            ordreDeTravailRepo.save(ordreDeTravail);
            return true; // Return true to indicate successful update
        } else {
            return false; // Return false to indicate that the order with the given ID was not found
        }
    }

}
