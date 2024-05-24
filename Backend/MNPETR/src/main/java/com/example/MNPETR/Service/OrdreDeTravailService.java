package com.example.MNPETR.Service;

import com.example.MNPETR.Model.Enum.StatusOT;
import com.example.MNPETR.Model.Equipement;
import com.example.MNPETR.Model.OrdreDeTravail;
import com.example.MNPETR.Model.Piece;
import com.example.MNPETR.Repository.EquipementRepo;
import com.example.MNPETR.Repository.OrdreDeTravailRepo;
import com.example.MNPETR.Repository.PieceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OrdreDeTravailService implements IOrdreDeTravailService {
    public final OrdreDeTravailRepo ordreDeTravailRepo;
    @Autowired
    public OrdreDeTravailService(OrdreDeTravailRepo ordreDeTravailRepo) {
        this.ordreDeTravailRepo = ordreDeTravailRepo;
    }

    @Autowired
    public PieceRepo pieceRepo;

    @Autowired
    public EquipementRepo equipementRepo;

    @Override
    public List<OrdreDeTravail> getAllOrdreDeTravail() {
        return ordreDeTravailRepo.findAll();
    }

    @Override
    public Optional<OrdreDeTravail> getOrdreDeTravailById(Integer ID_OT) {
        return ordreDeTravailRepo.findById(ID_OT);
    }

    @Override
    public List<OrdreDeTravail> getOrdreDeTravailByDate(Date Date_OT) {
        return ordreDeTravailRepo.findByDateOt(Date_OT);
    }

    @Override
    public List<OrdreDeTravail> getOrdreDeTravailByTypeOtz(String Type_Otz){
        return ordreDeTravailRepo.findByTypeOtz(Type_Otz);
    }

    @Override
    public OrdreDeTravail addOrdreDeTravail(OrdreDeTravail ordreDeTravail, List<Piece> pieces, Equipement equipementMaintenance) {

        if (pieces != null && !pieces.isEmpty()) {
            Optional<Piece> piece = pieceRepo.findById(pieces.get(0).getId());
        } else {
            throw new RuntimeException("Veuillez sélectionner au moins une pièce nécessaire.");
        }

        // Vérifier si l'équipement de maintenance est spécifié et l'associer à l'ordre de travail
        if (equipementMaintenance != null) {
            Optional<Equipement> equipementOpt = equipementRepo.findById(equipementMaintenance.getID_Equipement());
            if (equipementOpt.isPresent()) {
                ordreDeTravail.setEquipements((Set<Equipement>) equipementOpt.get());
            } else {
                throw new RuntimeException("Équipement de maintenance non trouvé.");
            }
        } else {
            throw new RuntimeException("Veuillez sélectionner l'équipement nécessitant une maintenance.");
        }
        // Enregistrer l'ordre de travail avec les pièces et l'équipement associés
        return ordreDeTravailRepo.save(ordreDeTravail);
    }

    @Override
    public OrdreDeTravail saveOrdreDeTravail(OrdreDeTravail ordreDeTravail) {
        return ordreDeTravailRepo.save(ordreDeTravail);
    }
    public List<OrdreDeTravail> getOrdreDeTravailByStatus(StatusOT statusOT) {
        return ordreDeTravailRepo.findOrdreDeTravailByStatus(statusOT);
    }
}
