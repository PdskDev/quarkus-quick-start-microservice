package me.nadetdev.service;

import static org.junit.jupiter.api.Assertions.*;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import me.nadetdev.entities.EtudiantEntity;
import me.nadetdev.model.EtudiantModel;
import org.junit.jupiter.api.Test;

import java.util.List;

@QuarkusTest
class EtudiantServiceImplTest {

  @Inject
  EtudiantServiceImpl etudiantService;

  @Test
  void testGetListeEtudiants() {
    // Validate list is returned
    List<EtudiantModel> etudiants = etudiantService.getListeEtudiants();
    assertNotNull(etudiants);

    // Validate list contains expected data
    assertFalse(etudiants.isEmpty());
    EtudiantModel etudiant = etudiants.get(0);
    assertNotNull(etudiant.getId());
    assertNotNull(etudiant.getFirstName());
    assertNotNull(etudiant.getLastName());
    assertNotNull(etudiant.isActive());
  }

  @Test
  void testCreateEtudiant() {
    // Validate new etudiant is created
    EtudiantModel newEtudiant = new EtudiantModel("Nadet", "Dev", true);
    EtudiantEntity created = etudiantService.createEtudiant(newEtudiant);
    assertNotNull(created.getId());
    assertEquals("Nadet", created.getFirstName());

    // Validate exception on null etudiant
    assertThrows(NullPointerException.class, () -> {
      etudiantService.createEtudiant(null);
    });
  }

  @Test
  void testUpdateEtudiant() {
    // Validate etudiant is updated
    EtudiantModel existing = new EtudiantModel(1L, "Nadet", "Dev", false);
    existing.setFirstName("NadetDev");
    EtudiantEntity updated = etudiantService.updateEtudiant(existing);
    assertEquals("NadetDev", updated.getFirstName());

    // Validate exception on null/invalid ID
    EtudiantModel invalid = new EtudiantModel(null, "Nadet", "Dev", true);
    assertThrows(IllegalArgumentException.class, () -> {
      etudiantService.updateEtudiant(invalid);
    });
  }

  @Test
  void testDeleteEtudiant() {
    // Validate etudiant is deleted
    Long idToDelete = 1L;
    etudiantService.deleteEtudiant(idToDelete);
    EtudiantEntity deleted = EtudiantEntity.findById(idToDelete);
    assertNull(deleted);

    // Validate exception on invalid ID
    assertThrows(IllegalArgumentException.class, () -> {
      etudiantService.deleteEtudiant(null);
    });
  }
}
