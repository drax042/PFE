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
    private final DemandeDeTravailRepo demandeDeTravailRepo ;

    @Autowired
    public DemandeDeTravailService(DemandeDeTravailRepo demandeDetravailRepo) {
        this.demandeDeTravailRepo = demandeDetravailRepo;
    }

    @Override
    public List<DemandeDeTravail> getAllDemandeDeTravail(){
        return demandeDeTravailRepo.findAll() ;
    }

    @Override
    public Optional<DemandeDeTravail> getDemandeDeTravailByID(Integer ID_DT){
        return demandeDeTravailRepo.findById(ID_DT) ;
    }

    @Override
    public void saveDemandeDeTravail(DemandeDeTravail demandeDeTravail){
        demandeDeTravailRepo.save(demandeDeTravail);
    }

    @Override
    public void deleteDemandeDeTravail(DemandeDeTravail demandeDeTravail){
        demandeDeTravailRepo.delete(demandeDeTravail);
    }

    @Override
    public List<DemandeDeTravail> findDemandeDeTravailByDateDT(Date Date_DT){
        return demandeDeTravailRepo.findDemandeDeTravailByDate_DT(Date_DT);
    }


}