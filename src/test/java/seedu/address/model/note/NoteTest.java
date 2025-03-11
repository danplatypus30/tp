package seedu.address.model.note;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class NoteTest {

    @Test
    public void equals() {
        Note note = new Note("Title", "Content");

        // same object -> returns true
        assertTrue(note.equals(note));

        // different types -> returns false
        assertFalse(note.equals(1));

        // null -> returns false
        assertFalse(note.equals(null));

        // different Note -> returns false
        Note differentNote = new Note("Different Title", "Different Content");
        assertFalse(note.equals(differentNote));
    }
}
