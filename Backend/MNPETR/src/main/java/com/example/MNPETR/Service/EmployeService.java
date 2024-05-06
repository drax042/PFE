package com.example.MNPETR.Service;

import com.example.MNPETR.Model.Employe;
import com.example.MNPETR.Repository.EmployeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeService implements IEmployeService {
    private final EmployeRepo employeRepo ;
    @Autowired
    public EmployeService(EmployeRepo employeRepo) {
        this.employeRepo = employeRepo;
    }
@Override
    public List<Employe> getAllemploye(){
        return employeRepo.findAll() ;
    }
    @Override
    public Optional<Employe> getEmployeById(Integer ID_Employe) {
        return employeRepo.findById(ID_Employe) ;
    }
@Override
    public void saveEmploye (Employe employe){
        employeRepo.save(employe);
    }
@Override
    public void deleteEmploye (Employe employe) {
        employeRepo.delete(employe);
    }

    @Query
    public List<Employe> getEmployeByNomEmployeaAndPrenomEmploye   (String Nom_Employe, String Prenom_Employe ) {
        return employeRepo.getEmployeByNomEmployeAndPrenomEmploye (Nom_Employe, Prenom_Employe) ;
    }



    public List<Employe> getEmployeByEmailEmploye (String Email_Employe) {
        return employeRepo.getEmployeByEmailEmploye(Email_Employe) ;
    }


}
