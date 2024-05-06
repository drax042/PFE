package com.example.MNPETR.Repository;

import com.example.MNPETR.Model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeRepo extends JpaRepository<Employe, Integer> {
    @Query("SELECT emp FROM Employe emp WHERE emp.Nom_Employe = :nom AND emp.Prenom_Employe = :prenom")
    public List<Employe> getEmployeByNomEmployeAndPrenomEmploye(String nom, String prenom );


    @Query("select emp FROM Employe emp WHERE emp.Email_Employe = :email")
    public List<Employe> getEmployeByEmailEmploye (String email) ;
}
