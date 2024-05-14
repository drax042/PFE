package com.example.MNPETR.Service;

import com.example.MNPETR.Model.DemandeDeTravail;
import com.example.MNPETR.Repository.DemandeDeTravailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DemandeDeTravailService implements IDemandeDeTravailService {
    private final DemandeDeTravailRepo demandeDeTravailRepo;

    @Autowired
    public DemandeDeTravailService(DemandeDeTravailRepo demandeDetravailRepo) {
        this.demandeDeTravailRepo = demandeDetravailRepo;
    }

    @Override
    public List<DemandeDeTravail> getAllDemandeDeTravail() {
        return demandeDeTravailRepo.findAll();
    }

    @Override
    public Optional<DemandeDeTravail> getDemandeDeTravailByID(Integer ID_DemandeDeTravail) {
        return demandeDeTravailRepo.findById(ID_DemandeDeTravail);
    }

    @Override
    public DemandeDeTravail saveDemandeDeTravail(DemandeDeTravail demandeDeTravail) {
       return demandeDeTravailRepo.save(demandeDeTravail);
    }

    @Override
    public List<DemandeDeTravail> getDemandeDeTravailByDateDT(Date Date_DT) {
        return demandeDeTravailRepo.findDemandeDeTravailByDate_DT(Date_DT);
    }

    @Override
    public List<DemandeDeTravail> getDemandeDeTravailByStatus(String status) {
        return demandeDeTravailRepo.findDemandeDeTravailByStatus(status);
    }
}



