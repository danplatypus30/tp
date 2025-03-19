package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;

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
}
