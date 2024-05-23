package com.example.MNPETR.Service;

import com.example.MNPETR.Model.DemandeDeTravail;
import com.example.MNPETR.Model.Enum.intituleRole;
import com.example.MNPETR.Model.User;
import com.example.MNPETR.Repository.DemandeDeTravailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DemandeDeTravailService implements IDemandeDeTravailService {

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private UserService userService;

    @Autowired
    public DemandeDeTravailRepo demandeDeTravailRepo;

    @Override
    public List<DemandeDeTravail> getAllDemandeDeTravail() {
        return demandeDeTravailRepo.findAll();
    }

    @Override
    public Optional<DemandeDeTravail> getDemandeDeTravailByID(Integer ID_DemandeDeTravail) {
        return demandeDeTravailRepo.findById(ID_DemandeDeTravail);
    }


    @Override
    public DemandeDeTravail saveDemandeDeTravail(DemandeDeTravail demandeDeTravail, User user) {
        demandeDeTravail.setUser(user);
        demandeDeTravail.setDate_DT(new Date());
        DemandeDeTravail savedDemandeDeTravail = demandeDeTravailRepo.save(demandeDeTravail);
        String notificationContent = "Nouvelle demande de travail de la part de l'utilisateur ID: " + user.getId() + " à " + demandeDeTravail.getDate_DT();
        List<User> responsables = userService.getUsersByRole(intituleRole.responsable);
        List<User> responsablesMaintenance = userService.getUsersByRole(intituleRole.responsableMaintenance);
        for (User responsable : responsables) {
            notificationService.createNotification(notificationContent, responsable);
        }

        for (User responsableMaintenance : responsablesMaintenance) {
            notificationService.createNotification(notificationContent, responsableMaintenance);
        }
        return savedDemandeDeTravail;
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



