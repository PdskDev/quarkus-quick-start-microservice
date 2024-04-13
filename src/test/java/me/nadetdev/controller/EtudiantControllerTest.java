package me.nadetdev.controller;

import static org.junit.jupiter.api.Assertions.*;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import me.nadetdev.entities.EtudiantEntity;
import me.nadetdev.model.EtudiantModel;
import me.nadetdev.service.EtudiantServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
@Transactional
public class EtudiantControllerTest {

    @InjectMock
    EtudiantServiceImpl etudiantService;

    @Test
    void testCreateEtudiant() {
        EtudiantController controller = new EtudiantController(etudiantService);
        EtudiantModel etudiantModel = new EtudiantModel("Nadet", "Dev", true);

        EtudiantEntity etudiantMock = new EtudiantEntity();
        etudiantMock.setId(10L);
        etudiantMock.setFirstName("Nadet");
        etudiantMock.setLastName("Dev");
        etudiantMock.setActive(true);

        Mockito.when(etudiantService.createEtudiant(etudiantModel)).thenReturn(etudiantMock);

        EtudiantEntity etudiant = controller.createEtudiant(etudiantModel);

        assertNotNull(etudiant);
        assertEquals("Nadet", etudiant.getFirstName());
        assertEquals("Dev", etudiant.getLastName());
    }

}

