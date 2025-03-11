package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NOTE_CONTENT_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NOTE_TITLE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NOTE_TITLE_BOB;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PATIENT;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PATIENT;
import static seedu.address.testutil.TypicalPatients.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.note.Note;


/**
 * Contains integration tests (interaction with the Model) and unit tests for
 * RemarkCommand.
 */
public class NoteCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void equals() {
        final NoteCommand standardCommand = new NoteCommand(INDEX_FIRST_PATIENT,
                new Note(VALID_NOTE_TITLE_AMY, VALID_NOTE_CONTENT_AMY));

        // same values -> returns true
        NoteCommand commandWithSameValues = new NoteCommand(INDEX_FIRST_PATIENT,
                new Note(VALID_NOTE_TITLE_AMY, VALID_NOTE_CONTENT_AMY));
        assertTrue(standardCommand.equals(commandWithSameValues));

        // same object -> returns true
        assertTrue(standardCommand.equals(standardCommand));

        // null -> returns false
        assertFalse(standardCommand.equals(null));

        // different types -> returns false
        assertFalse(standardCommand.equals(new ClearCommand()));

        // different index -> returns false
        assertFalse(standardCommand.equals(new NoteCommand(INDEX_SECOND_PATIENT,
                new Note(VALID_NOTE_TITLE_AMY, VALID_NOTE_CONTENT_AMY))));

        // different title -> returns false
        assertFalse(standardCommand.equals(new NoteCommand(INDEX_FIRST_PATIENT,
                new Note(VALID_NOTE_TITLE_BOB, VALID_NOTE_CONTENT_AMY))));
    }
}
