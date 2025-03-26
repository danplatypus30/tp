package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.NON_EXISTENT_NOTE_TITLE;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PATIENT;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PATIENT;
import static seedu.address.testutil.TypicalPatients.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

public class DeleteNoteCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void equals() {
        final DeleteNoteCommand standardCommand =
                new DeleteNoteCommand(INDEX_FIRST_PATIENT, "4th Session with Alice");

        // same values -> returns true
        DeleteNoteCommand commandWithSameValues =
                new DeleteNoteCommand(INDEX_FIRST_PATIENT, "4th Session with Alice");
        assertTrue(standardCommand.equals(commandWithSameValues));

        // same object -> returns true
        assertTrue(standardCommand.equals(standardCommand));

        // null -> returns false
        assertFalse(standardCommand.equals(null));

        // different types -> returns false
        assertFalse(standardCommand.equals(new ClearCommand()));

        // different index -> returns false
        assertFalse(standardCommand.equals(
                new DeleteNoteCommand(INDEX_SECOND_PATIENT, "4th Session with Alice")
        ));
    }

    @Test
    public void execute_patientWithNoNotes_failure() {
        // Delete non existent note from patient -> failure
        DeleteNoteCommand deleteNoteCommand = new DeleteNoteCommand(INDEX_FIRST_PATIENT, NON_EXISTENT_NOTE_TITLE);
        String expectedMessage = String.format(DeleteNoteCommand.MESSAGE_NOTE_NOT_FOUND, NON_EXISTENT_NOTE_TITLE);

        assertCommandFailure(deleteNoteCommand, model, expectedMessage);
    }

    @Test
    public void execute_validPatientWithoutNotes_noNotesMessage() {
        DeleteNoteCommand deleteNoteCommand = new DeleteNoteCommand(INDEX_FIRST_PATIENT, "test");
        Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        assertThrows(CommandException.class, () -> deleteNoteCommand.execute(model));
    }

    @Test
    public void execute_invalidPatientIndex_throwsCommandException() {
        Index outOfBoundsIndex = Index.fromOneBased(model.getFilteredPatientList().size() + 1);
        DeleteNoteCommand deleteNoteCommand = new DeleteNoteCommand(outOfBoundsIndex, "test");
        assertThrows(CommandException.class, () -> deleteNoteCommand.execute(model));
    }

}
