package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PATIENT;
import static seedu.address.testutil.TypicalPatients.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.patient.Patient;

public class ViewNotesCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_validIndex_success() {
        Patient patient = model.getFilteredPatientList().get(INDEX_FIRST_PATIENT.getZeroBased());
        ViewNotesCommand command = new ViewNotesCommand(String.valueOf(INDEX_FIRST_PATIENT.getOneBased()));

        String expectedMessage = String.format(ViewNotesCommand.MESSAGE_SUCCESS, patient.getName().fullName);

        ModelManager expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());

        assertCommandSuccess(command, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_viewAll_success() {
        ViewNotesCommand command = new ViewNotesCommand(ViewNotesCommand.ALL_PARAMETER);

        String expectedMessage = ViewNotesCommand.MESSAGE_SUCCESS_ALL;

        ModelManager expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());

        assertCommandSuccess(command, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndex_failure() {
        Index outOfBoundsIndex = Index.fromOneBased(model.getFilteredPatientList().size() + 1);
        ViewNotesCommand command = new ViewNotesCommand(String.valueOf(outOfBoundsIndex.getOneBased()));

        assertCommandFailure(command, model, ViewNotesCommand.MESSAGE_USAGE);
    }
}
