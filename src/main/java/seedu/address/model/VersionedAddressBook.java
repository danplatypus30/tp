package seedu.address.model;

import static seedu.address.logic.Messages.MESSAGE_REDO_FAILURE;
import static seedu.address.logic.Messages.MESSAGE_UNDO_FAILURE;

import java.util.Stack;

import seedu.address.model.exceptions.RedoException;
import seedu.address.model.exceptions.UndoException;

/**
 * Class to store past and future snapshots of patientlist
 */
public class VersionedAddressBook {
    private final Stack<ReadOnlyAddressBook> history = new Stack<>();
    private final Stack<ReadOnlyAddressBook> future = new Stack<>();

    /**
     * Extracts future snapshots that have been undone.
     *
     * @return data in forms of ReadOnlyAddressBook.
     * @throws RedoException when future stack is empty.
     */
    public ReadOnlyAddressBook extractFutureData() throws RedoException {
        if (future.isEmpty()) {
            throw new RedoException(MESSAGE_REDO_FAILURE);
        }
        return future.pop();
    }

    /**
     * Extracts history data.
     *
     * @return Old version of data in the form of ReadOnlyAddressBook.
     * @throws UndoException when the storage is empty.
     */
    public ReadOnlyAddressBook extractOldData() throws UndoException {
        if (history.isEmpty()) {
            throw new UndoException(MESSAGE_UNDO_FAILURE);
        }
        return history.pop();
    }

    /**
     * Saves history data into history stack.
     * Data should not be null.
     */
    public void saveOldData(ReadOnlyAddressBook data) {
        assert data != null;
        history.add(data);
    }

    /**
     * Saves current data into future stack.
     * Data should not be null.
     */
    public void saveFutureData(ReadOnlyAddressBook data) {
        future.add(data);
    }

    /**
     * Clears all undone data in the future stack.
     */
    public void clearFutureData() {
        future.clear();
    }

}
