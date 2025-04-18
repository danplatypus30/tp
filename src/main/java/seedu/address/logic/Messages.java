package seedu.address.logic;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.parser.Prefix;
import seedu.address.model.note.Note;
import seedu.address.model.patient.Patient;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command. You can refer"
            + " to the User Guide for the correct command format! ";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_INVALID_PATIENT_DISPLAYED_INDEX =
            "Invalid index! Please provide a positive integer within"
            + " the patient list range! ";
    public static final String MESSAGE_INVALID_NOTE_DELETE_TITLE = "The note title provided is invalid";
    public static final String MESSAGE_PATIENTS_LISTED_OVERVIEW = "%1$d patients listed!";
    public static final String MESSAGE_DUPLICATE_FIELDS =
                "Multiple values specified for the following single-valued field(s): ";
    public static final String MESSAGE_DUPLICATE_PATIENT = "This patient already exists in the app. Duplicate"
            + " patient name is not allowed. ";
    public static final String MESSAGE_NOTE_NOT_FOUND = "Note Title does not exist: %1$s";
    public static final String MESSAGE_NO_NOTES = "Patient %1$s has no notes";
    public static final String MESSAGE_NOT_ADDED_NOTE = "Note must have title and content!";
    public static final String MESSAGE_NOTE_ALREADY_EXISTS = "Note with title %1$s already exists!";
    public static final String MESSAGE_INVALID_INDEX = "Invalid index! Please provide a positive integer within"
            + " the patient list range! ";
    public static final String MESSAGE_UNDO_FAILURE = "No command to undo!";
    public static final String MESSAGE_REDO_FAILURE = "No command to redo!";
    public static final String MESSAGE_SPECIAL_CHARACTERS = "Command contains special characters.\n"
                + "Only letters, numbers, and spaces are allowed.\n%1$s";
    public static final String ALPHANUMERIC_REGEX = "^[a-zA-Z0-9\\s]+$";

    /**
     * Returns an error message indicating the duplicate prefixes.
     */
    public static String getErrorMessageForDuplicatePrefixes(Prefix... duplicatePrefixes) {
        assert duplicatePrefixes.length > 0;

        Set<String> duplicateFields =
                Stream.of(duplicatePrefixes).map(Prefix::toString).collect(Collectors.toSet());

        return MESSAGE_DUPLICATE_FIELDS + String.join(" ", duplicateFields);
    }

    /**
     * Formats the {@code patient} for display to the user.
     */
    public static String format(Patient patient) {
        final StringBuilder builder = new StringBuilder();
        builder.append(patient.getName())
                .append("; Phone: ")
                .append(patient.getPhone())
                .append("; Address: ")
                .append(patient.getAddress())
                .append("; \nNotes: ")
                .append(patient.getNotes().stream().map(Note::getTitledContent).collect(Collectors.joining(", ")))
                .append("; Tags: ");
        patient.getTags().forEach(builder::append);
        return builder.toString();
    }

}
