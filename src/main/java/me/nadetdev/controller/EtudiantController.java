package me.nadetdev.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import me.nadetdev.entities.EtudiantEntity;
import me.nadetdev.model.EtudiantModel;
import me.nadetdev.service.EtudiantService;

import java.util.List;

@Path("/etudiants")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EtudiantController {

    @Inject
    EtudiantService etudiantService;

    @GET
    public List<EtudiantModel> getListeEtudiants() {
        return etudiantService.getListeEtudiants();
    }

    @POST
    public EtudiantEntity createEtudiant(EtudiantModel etudiant) {
        EtudiantEntity etudiantEntity = etudiantService.createEtudiant(etudiant);
        return etudiantEntity;
    }

    @PUT
    public EtudiantEntity updateEtudiant(EtudiantModel etudiant) {
        return etudiantService.updateEtudiant(etudiant);
    }

    @DELETE
    @Path("{id}")
    public void deleteEtudiant(@PathParam("id") Long id) {
        etudiantService.deleteEtudiant(id);
    }
}
