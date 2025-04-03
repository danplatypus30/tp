package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.Messages.MESSAGE_UNDO_FAILURE;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPatients.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.patient.Patient;
import seedu.address.testutil.PatientBuilder;

/**
 * Contains integration tests (interaction with the Model) and unit tests for UndoCommand.
 */
public class UndoCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_noStateToUndo_failure() {
        assertCommandFailure(new UndoCommand(), model, MESSAGE_UNDO_FAILURE);
    }

    @Test
    public void execute_haveStateToUndo_success() {
        ModelManager expectedUndoModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        model.saveAddressBook();
        Patient validPatient = new PatientBuilder().build();
        model.addPatient(validPatient);
        model.saveAddressBook();

        assertCommandSuccess(new UndoCommand(), model, UndoCommand.MESSAGE_SUCCESS, expectedUndoModel);
    }

    @Test
    public void equals() {
        Command command = new UndoCommand();
        Command dupliacte = new UndoCommand();
        Command redoCommand = new RedoCommand();

        // same type of objects -> return true
        assertTrue(command.equals(dupliacte));

        // different types of commands -> return false
        assertFalse(command.equals(redoCommand));
    }
}
