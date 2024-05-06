package com.example.MNPETR.Service;

import com.example.MNPETR.Model.Employe;
import com.example.MNPETR.Model.Maintenancier;

import java.util.List;
import java.util.Optional;

public interface IMaintenancierService {
    List<Maintenancier> getAllMaintenancier();

    Optional<Maintenancier> getMaintenancierByID(Integer ID_Maintenancier);

    List<Maintenancier> getMaintenancierByNom_MaintenancierAndAndPrenom_Maintenancier(String nom_maintenancier, String prenom_maintenancier);

    List<Employe> getEmployeByEmailEmploye(String email);
}
