package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.Messages.MESSAGE_PATIENTS_LISTED_OVERVIEW;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.FilterNoteCommand.MESSAGE_INVALID_INDEX;
import static seedu.address.testutil.TypicalPatients.CARL;
import static seedu.address.testutil.TypicalPatients.ELLE;
import static seedu.address.testutil.TypicalPatients.FIONA;
import static seedu.address.testutil.TypicalPatients.getTypicalAddressBook;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.patient.Patient;

/**
 * Contains integration tests (interaction with the Model) for {@code FindCommand}.
 */
public class FilterNoteCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void equals() {
        FilterNoteCommand firstCommand = new FilterNoteCommand(Index.fromOneBased(0), "test1");
        FilterNoteCommand secondCommand = new FilterNoteCommand(Index.fromOneBased(1), "test2");

        //same object -> return true
        assertTrue(firstCommand.equals(firstCommand));

        //same values -> return true
        FilterNoteCommand firstCommandCopy = new FilterNoteCommand(Index.fromOneBased(0), "test1");
        assertTrue(firstCommand.equals(firstCommandCopy));

        //different types -> return false
        assertFalse(firstCommand.equals(1));

        //null -> return false
        assertFalse(firstCommand.equals(null));

        //different patient and title -> return false
        assertFalse(firstCommand.equals(secondCommand));
    }

}
