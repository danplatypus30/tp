package seedu.address.model.patient;

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
     * Formats a set of notes into a single string, sorted by creation date.
     *
     * @param notes The set of notes to format.
     * @return A formatted string of note titles enclosed in square brackets, separated by spaces.
     */
    public static String formatNotes(Set<Note> notes) {
        TreeSet<Note> sortedNotes = new TreeSet<>(notes); // TreeSet automatically orders elements
        return sortedNotes.stream()
                .map(note -> "[" + note.getTitle() + "]")
                .collect(Collectors.joining(" "));
    }
}
