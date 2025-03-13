package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.note.Note;
import seedu.address.model.patient.Patient;

/**
 * Command to view all notes associated with a specific patient.
 */
public class ViewNotesCommand extends Command {

    public static final String COMMAND_WORD = "viewnotes";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all notes for the patient identified by the index number.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 2";

    public static final String MESSAGE_SUCCESS = "Notes for %1$s:\n\n%2$s";
    public static final String MESSAGE_NO_NOTES = "Patient %1$s has no notes.";
    public static final String MESSAGE_INVALID_INDEX = "Invalid index! Please provide a positive integer within range.";

    private final Index targetIndex;

    public ViewNotesCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Patient> lastShownList = model.getFilteredPatientList();

        // Handle invalid index cases
        if (targetIndex.getZeroBased() < 0 || targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(MESSAGE_INVALID_INDEX);
        }

        Patient patientToView = lastShownList.get(targetIndex.getZeroBased());
        List<Note> notesList = patientToView.getNotes().stream().toList();

        if (notesList.isEmpty()) {
            return new CommandResult(String.format(MESSAGE_NO_NOTES, patientToView.getName().fullName));
        }

        // Format notes properly with numbering
        String formattedNotes = formatNotes(notesList);

        return new CommandResult(String.format(MESSAGE_SUCCESS, patientToView.getName().fullName, formattedNotes));
    }

    /**
     * Formats notes dynamically with numbering and proper wrapping.
     */
    private String formatNotes(List<Note> notesList) {
        StringBuilder sb = new StringBuilder();
        int noteNumber = 1;

        for (Note note : notesList) {
            sb.append(noteNumber).append(". ").append(note.getTitle()).append("\n")
                    .append("   ").append(note.getContent()) // The UI will handle wrapping
                    .append("\n\n");
            noteNumber++;
        }

        return sb.toString().trim();
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof ViewNotesCommand
                && targetIndex.equals(((ViewNotesCommand) other).targetIndex));
    }
}
