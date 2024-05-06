package com.example.MNPETR.Repository;

import com.example.MNPETR.Model.Employe;
import com.example.MNPETR.Model.Maintenancier;
import com.sun.tools.javac.Main;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaintenancierRepo extends JpaRepository<Maintenancier, Integer> {

    @Query("select mnt from Maintenancier mnt Where mnt.Nom_Maintenancier =:nom_maintenancier AND mnt.Prenom_Maintenancier =:prenom_maintenancier")
    public List<Maintenancier> getMaintenancierByNom_MaintenancierAndAndPrenom_Maintenancier(String nom_maintenancier, String prenom_maintenancier) ;

    @Query("select mnt FROM Maintenancier mnt WHERE mnt.Email_Maintenanicer = :email")
    public List<Employe> getEmployeByEmailEmploye (String email) ;

}
