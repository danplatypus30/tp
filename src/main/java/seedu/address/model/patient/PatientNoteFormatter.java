package seedu.address.model.patient;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import seedu.address.model.note.Note;

/**
 * Utility class for formatting patient notes.
 */
public final class PatientNoteFormatter {

    /**
     * Private constructor to prevent instantiation.
     */
    private PatientNoteFormatter() {
        throw new UnsupportedOperationException("Utility class should not be instantiated");
    }

    /**
     * Formats notes dynamically with numbering and proper wrapping.
     */
    private String formatNotes(List<Note> notesList) {
        StringBuilder sb = new StringBuilder();
        int noteNumber = 1;

        for (Note note : notesList) {
            sb.append(noteNumber).append(". ").append(note.getTitle()).append("\n")
                    .append("   ").append(note.getContent()).append("\n") // The UI will handle wrapping
                    .append("   ").append(note.getDateTimeCreated().toString()).append("\n\n");
            noteNumber++;
        }

        return sb.toString().trim();
    }
}
