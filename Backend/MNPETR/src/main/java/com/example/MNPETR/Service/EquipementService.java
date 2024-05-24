package com.example.MNPETR.Service;

import com.example.MNPETR.Model.Enum.StatusEquipement;
import com.example.MNPETR.Model.Equipement;
import com.example.MNPETR.Repository.EquipementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EquipementService implements IEquipementService {
    public final EquipementRepo equipementRepo;
    @Autowired
    public EquipementService(EquipementRepo equipementRepo) { //aw ja walid ÉÉÉÉÉÉÉÉÉ
        this.equipementRepo = equipementRepo;
    }

    @Override
    public List<Equipement> getAllEquipements() {
        return equipementRepo.findAll();
    }

    @Override
    public Optional<Equipement> getEquipementById(Integer ID_Equipement) {
        return equipementRepo.findById(ID_Equipement);
    }


    public List<Equipement> getEquipementByStatus(StatusEquipement statusEquipement) {
        return equipementRepo.findEquipementByStatus(statusEquipement);
    }

    @Override
    public Equipement saveEquipement(Equipement equipement) {
        return equipementRepo.save(equipement);
    }

    @Override
    public void deleteEquipement(Equipement equipment) {
        equipementRepo.delete(equipment);
    }

    @Override
    public ResponseEntity<Object> updateEquipementStatus(Integer id, StatusEquipement newStatusEquipement) {
        Optional<Equipement> optionalEquipement = equipementRepo.findById(id);
        if (optionalEquipement.isPresent()) {
            Equipement equipement = optionalEquipement.get();
            equipement.setStatusEquipement(newStatusEquipement);
            equipementRepo.save(equipement);
            return ResponseEntity.ok(equipement);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
