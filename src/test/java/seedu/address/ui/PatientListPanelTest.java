package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.TypicalPatients.getTypicalPatients;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import seedu.address.model.patient.Patient;

/**
 * Tests for {@code PatientListPanel}.
 */
public class PatientListPanelTest extends ApplicationTest {

    private ObservableList<Patient> patients;
    private PatientListPanel panel;

    @Override
    public void start(Stage stage) {
        patients = FXCollections.observableList(getTypicalPatients());
        panel = new PatientListPanel(patients);

        // Attach panel to a scene so JavaFX initializes it
        StackPane root = new StackPane(panel.getRoot());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @BeforeEach
    public void setUp() {
        // JavaFX is initialized in start(Stage)
    }

    @Test
    @SuppressWarnings("unchecked")
    public void constructor_createsListCorrectly() {
        ListView<Patient> listView = (ListView<Patient>) panel.getRoot().lookup("#patientListView");

        // Ensure list items are correctly assigned
        assertEquals(patients.size(), listView.getItems().size());

        // Ensure first patient matches expected
        assertEquals(patients.get(0), listView.getItems().get(0));
    }
}
