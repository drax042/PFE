package com.example.MNPETR.Service;

import com.example.MNPETR.Model.Employe;

import java.util.List;
import java.util.Optional;

public interface IEmployeService {
    List<Employe> getAllemploye();

    Optional<Employe> getEmployeById(Integer ID_Employe);

    void saveEmploye(Employe employe);

    void deleteEmploye(Employe employe);

    List<Employe> getEmployeByNomEmployeaAndPrenomEmploye(String Nom_Employe, String Prenom_Employe);

    List<Employe> getEmployeByEmailEmploye(String Email_Employe);
}
