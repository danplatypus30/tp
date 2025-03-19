package seedu.address.logic.commands;


import static org.junit.jupiter.api.Assertions.*;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.Messages.MESSAGE_PATIENTS_LISTED_OVERVIEW;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPatients.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.patient.NameContainsKeywordsPredicate;

import java.util.Arrays;
import java.util.Collections;


/**
 * Contains integration tests (interaction with the Model) for {@code FindCommand}.
 */
public class FilterNoteCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

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
    public void execute_noTitle_noNotesFound() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, FilterNoteCommand.MESSAGE_USAGE);
        FilterNoteCommand command = new FilterNoteCommand(Index.fromOneBased(1),"" );
        assertCommandSuccess(command, model, expectedMessage, model);
        assertEquals(Collections.emptyList(), model.getFilteredPatientList());
    }

    @Test
    public void execute_noIndex_noPatientFound() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, FilterNoteCommand.MESSAGE_USAGE);
        FilterNoteCommand command = new FilterNoteCommand(null,"test" );
        assertCommandSuccess(command, model, expectedMessage, model);
        assertEquals(Collections.emptyList(), model.getFilteredPatientList());
    }

}
