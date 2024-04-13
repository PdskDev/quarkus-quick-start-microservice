package me.nadetdev.service;

import me.nadetdev.entities.EtudiantEntity;
import me.nadetdev.model.EtudiantModel;

import java.util.List;

public interface EtudiantService {
    public List<EtudiantModel> getListeEtudiants();
    public EtudiantEntity createEtudiant(EtudiantModel etudiant);
    public EtudiantEntity updateEtudiant(EtudiantModel etudiant);
    public void deleteEtudiant(Long id);
}
