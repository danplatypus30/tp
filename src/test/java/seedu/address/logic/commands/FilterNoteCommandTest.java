package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.FilterNoteCommand.MESSAGE_SUCCESS;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PATIENT;
import static seedu.address.testutil.TypicalPatients.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.patient.Patient;

/**
 * Contains integration tests (interaction with the Model) for {@code FindCommand}.
 */
public class FilterNoteCommandTest {
    @Test
    public void equals() {
        FilterNoteCommand firstCommand = new FilterNoteCommand(Index.fromOneBased(2), "test1");
        FilterNoteCommand secondCommand = new FilterNoteCommand(Index.fromOneBased(1), "test2");

        //same object -> return true
        assertTrue(firstCommand.equals(firstCommand));

        //same values -> return true
        FilterNoteCommand firstCommandCopy = new FilterNoteCommand(Index.fromOneBased(2), "test1");
        assertTrue(firstCommand.equals(firstCommandCopy));

        //different types -> return false
        assertFalse(firstCommand.equals(1));

        //null -> return false
        assertFalse(firstCommand.equals(null));

        //different patient and title -> return false
        assertFalse(firstCommand.equals(secondCommand));
    }

    @Test
    public void execute_validPatientWithoutNotes_noNotesMessage() {
        Index index = Index.fromOneBased(6);
        FilterNoteCommand command = new FilterNoteCommand(index, "test");
        Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        assertThrows(CommandException.class, () -> command.execute(model));
    }

    @Test
    public void execute_validPatientWithMatchingNote_success() {
        Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        Patient patientToView = model.getFilteredPatientList().get(INDEX_FIRST_PATIENT.getZeroBased());
        String expectedNote = "Title: 4th Session with Alice" + "\nContent: Discussed progress";
        FilterNoteCommand command = new FilterNoteCommand(INDEX_FIRST_PATIENT, "Alice");
        String expectedMessage = String.format(FilterNoteCommand.MESSAGE_SUCCESS, patientToView.getName().fullName,
                expectedNote);
        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        assertCommandSuccess(command, model, expectedMessage.trim(), expectedModel);
    }

    @Test
    public void execute_invalidPatientIndex_throwsCommandException() {
        Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        Index outOfBoundsIndex = Index.fromOneBased(model.getFilteredPatientList().size() + 1);
        FilterNoteCommand command = new FilterNoteCommand(outOfBoundsIndex, "test");
        assertThrows(CommandException.class, () -> command.execute(model));
    }
}
