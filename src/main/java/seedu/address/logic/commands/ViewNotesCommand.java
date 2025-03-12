package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.stream.Collectors;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
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

    public static final String MESSAGE_SUCCESS = "Notes for %1$s:\n%2$s";
    public static final String MESSAGE_NO_NOTES = "Patient %1$s has no notes.";

    private final Index targetIndex;

    public ViewNotesCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Patient> lastShownList = model.getFilteredPatientList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PATIENT_DISPLAYED_INDEX);
        }

        Patient patientToView = lastShownList.get(targetIndex.getZeroBased());

        // Get notes as a formatted string
        List<Note> notesList = patientToView.getNotes().stream().toList();

        if (notesList.isEmpty()) {
            return new CommandResult(String.format(MESSAGE_NO_NOTES, patientToView.getName().fullName));
        }

        // Format notes into a readable string
        String formattedNotes = notesList.stream()
                .map(note -> "- [" + note.getTitle() + "] " + note.getContent())
                .collect(Collectors.joining("\n"));

        return new CommandResult(String.format(MESSAGE_SUCCESS, patientToView.getName().fullName, formattedNotes));
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof ViewNotesCommand
                && targetIndex.equals(((ViewNotesCommand) other).targetIndex));
    }
}
