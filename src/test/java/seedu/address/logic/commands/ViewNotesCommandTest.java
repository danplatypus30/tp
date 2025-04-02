package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
    public void execute_invalidIndex_throwsCommandException() {
        Index outOfBoundsIndex = Index.fromOneBased(model.getFilteredPatientList().size() + 1);
        ViewNotesCommand command = new ViewNotesCommand(String.valueOf(outOfBoundsIndex.getOneBased()));

        String expectedMessage = String.format(ViewNotesCommand.MESSAGE_INVALID_INDEX,
                outOfBoundsIndex.getOneBased());
        assertCommandFailure(command, model, expectedMessage);
    }

    @Test
    public void execute_invalidFormat_throwsCommandException() {
        ViewNotesCommand command = new ViewNotesCommand("invalid");
        assertCommandFailure(command, model, ViewNotesCommand.MESSAGE_INVALID_FORMAT);
    }

    @Test
    public void equals_sameValues_returnsTrue() {
        ViewNotesCommand command1 = new ViewNotesCommand("1");
        ViewNotesCommand command2 = new ViewNotesCommand("1");
        assertTrue(command1.equals(command2));

        ViewNotesCommand allCommand1 = new ViewNotesCommand("all");
        ViewNotesCommand allCommand2 = new ViewNotesCommand("all");
        assertTrue(allCommand1.equals(allCommand2));
    }

    @Test
    public void equals_differentValues_returnsFalse() {
        ViewNotesCommand command1 = new ViewNotesCommand("1");
        ViewNotesCommand command2 = new ViewNotesCommand("2");
        ViewNotesCommand allCommand = new ViewNotesCommand("all");

        assertFalse(command1.equals(command2));
        assertFalse(command1.equals(allCommand));
        assertFalse(command2.equals(allCommand));
        assertFalse(command1.equals(null));
        assertFalse(command1.equals(new ClearCommand()));
    }

    @Test
    public void getParameter_returnsCorrectParameter() {
        String parameter = "1";
        ViewNotesCommand command = new ViewNotesCommand(parameter);
        assertEquals(parameter, command.getParameter());

        ViewNotesCommand allCommand = new ViewNotesCommand(ViewNotesCommand.ALL_PARAMETER);
        assertEquals(ViewNotesCommand.ALL_PARAMETER, allCommand.getParameter());
    }
}
