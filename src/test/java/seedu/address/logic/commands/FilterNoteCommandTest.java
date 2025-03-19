package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.testutil.TypicalPatients.getTypicalAddressBook;

import java.util.Collections;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

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
    

}
