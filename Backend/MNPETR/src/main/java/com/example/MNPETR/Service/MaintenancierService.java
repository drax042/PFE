package com.example.MNPETR.Service;

import com.example.MNPETR.Model.Employe;
import com.example.MNPETR.Model.Maintenancier;
import com.example.MNPETR.Repository.MaintenancierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenancierService implements IMaintenancierService {

    public final MaintenancierRepo maintenancierRepo ;

@Autowired
    public MaintenancierService(MaintenancierRepo maintenancierRepo) {
        this.maintenancierRepo = maintenancierRepo;
    }

    @Override
    public List<Maintenancier> getAllMaintenancier() {
        return maintenancierRepo.findAll() ;
    }

    @Override
    public Optional<Maintenancier> getMaintenancierByID(Integer ID_Maintenancier){
        return maintenancierRepo.findById(ID_Maintenancier);
    }

    @Override
    public List<Maintenancier> getMaintenancierByNom_MaintenancierAndAndPrenom_Maintenancier(String nom_maintenancier, String prenom_maintenancier) {
        return maintenancierRepo.getMaintenancierByNom_MaintenancierAndAndPrenom_Maintenancier(nom_maintenancier,prenom_maintenancier);
    }

    @Override
    public List<Employe> getEmployeByEmailEmploye(String email) {
        return maintenancierRepo.getEmployeByEmailEmploye(email);
    }


}
