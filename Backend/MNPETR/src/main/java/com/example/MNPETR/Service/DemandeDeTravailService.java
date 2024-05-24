package com.example.MNPETR.Service;

import com.example.MNPETR.Model.*;
import com.example.MNPETR.Model.Enum.StatusDT;
import com.example.MNPETR.Repository.DemandeDeTravailRepo;
import com.example.MNPETR.Repository.EmployeRepo;
import com.example.MNPETR.Repository.EquipementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DemandeDeTravailService implements IDemandeDeTravailService {

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private UserService userService;

    @Autowired
    public DemandeDeTravailRepo demandeDeTravailRepo;

    @Autowired
    private EmployeRepo employeRepo;

    @Autowired
    public EquipementRepo equipementRepo;

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
        if (demandeDeTravail.getEmploye() != null) {
            Optional<Employe> employeOpt = employeRepo.findById(demandeDeTravail.getEmploye().getID_Employe());
            if (employeOpt.isPresent()) {
                demandeDeTravail.setEmploye(employeOpt.get());
            } else {
                throw new RuntimeException("Employe non trouvé");
            }
        }
        if (demandeDeTravail.getEquipements() != null && !demandeDeTravail.getEquipements().isEmpty()) {
            Set<Equipement> validatedEquipements = new HashSet<>();
            for (Equipement equipement : demandeDeTravail.getEquipements()) {
                Optional<Equipement> equipementOpt = equipementRepo.findById(equipement.getID_Equipement());
                if (equipementOpt.isPresent()) {
                    validatedEquipements.add(equipementOpt.get());
                } else {
                    throw new RuntimeException("Equipement non trouvé");
                }
            }
            demandeDeTravail.setEquipements(validatedEquipements);
        }
        return demandeDeTravailRepo.save(demandeDeTravail);
    }

    @Override
    public List<DemandeDeTravail> getDemandeDeTravailByDateDT(Date Date_DT) {
        return demandeDeTravailRepo.findDemandeDeTravailByDate_DT(Date_DT);
    }

    @Override
    public List<DemandeDeTravail> getDemandeDeTravailByStatus(StatusDT status) {
        return demandeDeTravailRepo.findDemandeDeTravailByStatus(status);
    }
}



