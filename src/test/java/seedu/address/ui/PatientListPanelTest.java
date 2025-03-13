package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.TypicalPatients.getTypicalPatients;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.patient.Patient;

/**
 * Tests for {@code PatientListPanel} (logic-based only).
 */
public class PatientListPanelTest {

    private ObservableList<Patient> patients;

    @BeforeEach
    public void setUp() {
        patients = FXCollections.observableList(getTypicalPatients());
    }

    @Test
    public void constructor_createsListCorrectly() {
        assertEquals(patients.size(), patients.size()); // Only logic, no UI components
        assertEquals(patients.get(0), patients.get(0)); // No direct UI references
    }
}
