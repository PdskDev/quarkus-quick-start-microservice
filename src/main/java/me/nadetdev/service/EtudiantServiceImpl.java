package me.nadetdev.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import me.nadetdev.entities.EtudiantEntity;
import me.nadetdev.model.EtudiantModel;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class EtudiantServiceImpl implements EtudiantService {
    @Override
    public List<EtudiantModel> getListeEtudiants() {
        List<EtudiantEntity> listeEtudiantsEntity = EtudiantEntity.findAll().list();
        return listeEtudiantsEntity.stream().map(etudiantEntity -> {
            return new EtudiantModel(etudiantEntity.id, etudiantEntity.firstName, etudiantEntity.lastName, etudiantEntity.isActive);
        }).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public EtudiantEntity createEtudiant(EtudiantModel etudiant) {
        EtudiantEntity etudiantEntity = new EtudiantEntity();
        etudiantEntity.firstName = etudiant.getFirstName();
        etudiantEntity.lastName = etudiant.getLastName();
        etudiantEntity.isActive = etudiant.isActive();
        etudiantEntity.persist();
        return etudiantEntity;
    }

    @Transactional
    @Override
    public EtudiantEntity updateEtudiant(EtudiantModel etudiant) {
       EtudiantEntity etudiantEntity = EtudiantEntity.findById(etudiant.getId());
        etudiantEntity.firstName = etudiant.getFirstName();
        etudiantEntity.lastName = etudiant.getLastName();
        etudiantEntity.isActive = etudiant.isActive();
        return etudiantEntity;
    }

    @Transactional
    @Override
    public void deleteEtudiant(Long id) {
        EtudiantEntity.deleteById(id);
    }
}
