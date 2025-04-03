package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.Messages.MESSAGE_REDO_FAILURE;
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
 * Contains integration tests (interaction with the Model) and unit tests for RedoCommand.
 */
public class RedoCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_noStateToRedo_failure() {
        assertCommandFailure(new RedoCommand(), model, MESSAGE_REDO_FAILURE);
    }

    @Test
    public void excute_haveStateToRedo_success() {
        ModelManager expectedUndoModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        model.saveAddressBook();
        Patient validPatient = new PatientBuilder().build();
        model.addPatient(validPatient);
        ModelManager expectedRedoModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        model.saveAddressBook();
        assertCommandSuccess(new UndoCommand(), model, UndoCommand.MESSAGE_SUCCESS, expectedUndoModel);
        assertCommandSuccess(new RedoCommand(), model, RedoCommand.MESSAGE_SUCCESS, expectedRedoModel);
    }

    @Test
    public void equals() {
        Command command = new RedoCommand();
        Command duplicate = new RedoCommand();
        Command helpCommand = new HelpCommand();

        // same type of objects -> return true
        assertTrue(command.equals(duplicate));

        // different types of objects -> return false
        assertFalse(command.equals(helpCommand));
    }
}

