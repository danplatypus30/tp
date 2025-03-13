package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.TypicalPatients.ALICE;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import seedu.address.model.patient.Patient;

/**
 * Tests for {@code PatientCard}.
 */
public class PatientCardTest extends ApplicationTest {

    private PatientCard patientCard;
    private Patient patient;

    @Override
    public void start(Stage stage) {
        patient = ALICE;
        patientCard = new PatientCard(patient, 1);

        // Attach patientCard to a scene so JavaFX initializes it
        StackPane root = new StackPane(patientCard.getRoot());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @BeforeEach
    public void setUp() {
        // JavaFX is initialized in start(Stage)
    }

    @Test
    public void constructor_correctlyAssignsValues() {
        assertEquals("1. ", ((Label) patientCard.getRoot().lookup("#id")).getText());
        assertEquals(patient.getName().fullName, ((Label) patientCard.getRoot().lookup("#name")).getText());
        assertEquals(patient.getPhone().value, ((Label) patientCard.getRoot().lookup("#phone")).getText());
        assertEquals(patient.getAddress().value, ((Label) patientCard.getRoot().lookup("#address")).getText());
        assertEquals(patient.getEmail().value, ((Label) patientCard.getRoot().lookup("#email")).getText());
    }
}
