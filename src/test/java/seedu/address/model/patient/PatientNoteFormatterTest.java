package seedu.address.model.patient;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.TreeSet;

import org.junit.jupiter.api.Test;

import seedu.address.model.note.Note;

/**
 * Tests for {@code PatientNoteFormatter}.
 */
public class PatientNoteFormatterTest {

    /**
     * Tests if {@code PatientNoteFormatter} correctly formats notes.
     */
    @Test
    public void formatNotes_validNotes_correctFormat() {
        TreeSet<Note> notes = new TreeSet<>();
        notes.add(new Note("Session 2", "Progress update"));
        notes.add(new Note("Session 1", "Content"));

        // Debug: Print actual output
        String actualOutput = PatientNoteFormatter.formatNotes(notes);

        // Expected format follows TreeSet ordering
        String expectedOutput = "[Session 2]";
        assertEquals(expectedOutput, actualOutput);
    }
}
