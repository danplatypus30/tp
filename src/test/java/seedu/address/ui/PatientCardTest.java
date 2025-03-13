package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.TypicalPatients.ALICE;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import seedu.address.model.patient.Patient;

public class PatientCardTest extends ApplicationTest {

    private PatientCard patientCard;
    private Patient patient;

    @Override
    public void start(Stage stage) {
        // Initialize JavaFX application
        Platform.runLater(() -> {});
    }

    @BeforeEach
    public void setUp() {
        patient = ALICE;
        patientCard = new PatientCard(patient, 1);
    }
    @Test
    public void display_correctlyFormatsPatientDetails() {
        Platform.runLater(() -> {
            assertEquals("1. ", ((Label) patientCard.getRoot().lookup("#id")).getText());
            assertEquals(patient.getName().fullName, ((Label) patientCard.getRoot().lookup("#name")).getText());
            assertEquals(patient.getPhone().value, ((Label) patientCard.getRoot().lookup("#phone")).getText());
            assertEquals(patient.getAddress().value, ((Label) patientCard.getRoot().lookup("#address")).getText());
            assertEquals(patient.getEmail().value, ((Label) patientCard.getRoot().lookup("#email")).getText());
        });
    }
}
