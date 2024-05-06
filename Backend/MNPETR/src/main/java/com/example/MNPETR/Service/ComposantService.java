package com.example.MNPETR.Service;

import com.example.MNPETR.Model.Composant;
import com.example.MNPETR.Repository.ComposantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComposantService implements IComposantService {
    private final ComposantRepo composantRepo;

    @Autowired
    public ComposantService(ComposantRepo composantRepo) {
        this.composantRepo = composantRepo;
    }

    @Override
    public List<Composant> getAllComposants() {
        return composantRepo.findAll();
    }

    @Override
    public Optional<Composant> getComposantById(Integer ID_Composant) {
        return composantRepo.findById(ID_Composant);
    }

    @Override
    public List<Composant> getComposantByNomComposant(String Nom_Composant) {
        return composantRepo.findComposantByNomComposant(Nom_Composant);
    }

    @Override
    public Composant saveComposant(Composant composant) {
        return composantRepo.save(composant);
    }

    @Override
    public void deleteComposant(Composant composant) {
        composantRepo.delete(composant);
    }
}
