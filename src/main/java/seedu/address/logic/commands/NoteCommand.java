package seedu.address.logic.commands;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NOTE_CONTENT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NOTE_TITLE;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PATIENTS;

import java.time.LocalDateTime;
import java.util.List;
import java.util.TreeSet;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.CollectionUtil;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.note.Note;
import seedu.address.model.patient.Patient;

/**
 * Adds a note to a patient in the app.
 */
public class NoteCommand extends Command {
    public static final String COMMAND_WORD = "note";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a new note for the patient identified "
            + "by the index number used in the displayed patient list.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + PREFIX_NOTE_TITLE + "[NOTE TITLE] "
            + PREFIX_NOTE_CONTENT + "[NOTE CONTENT]\n"
            + "Example: " + COMMAND_WORD + " 1"
            + PREFIX_NOTE_TITLE + "Patient has allergies! "
            + PREFIX_NOTE_CONTENT + "Allergies include: Penicillin, Nuts";
    public static final String MESSAGE_ARGUMENTS = "Index: %1$d, Note Title: %2$s, Note Content: %3$s";
    public static final String MESSAGE_ADD_NOTE_SUCCESS = "Added note to Person: %1$s";

    private final Index index;
    private final Note note;

    /**
     * Creates a NoteCommand to add the specified {@code Note}
     *
     * @param index index of the patient in the filtered patient list
     * @param title title of the note
     * @param content content of the note
     */
    public NoteCommand(Index index, Note note) {
        requireAllNonNull(index, note);
        this.index = index;
        this.note = note;
    }

    /**
     * Executes the command to add a note to the patient at the specified index.
     * If the index is invalid or note title already exists, a CommandException is thrown.
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<Patient> lastShownList = model.getFilteredPatientList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PATIENT_DISPLAYED_INDEX);
        }

        Patient patientToEdit = lastShownList.get(index.getZeroBased());

        // Copy existing notes and add the new note
        TreeSet<Note> updatedNotes = new TreeSet<>(patientToEdit.getNotes());

        // Not allowed to create notes with the same title
        if (alreadyHasNoteTitle(updatedNotes, note)) {
            throw new CommandException(String.format(Messages.MESSAGE_NOTE_ALREADY_EXISTS, note.getTitle()));
        }

        updatedNotes.add(note);

        // Create updated patient
        Patient editedPatient = new Patient(
                patientToEdit.getName(),
                patientToEdit.getPhone(),
                patientToEdit.getAddress(),
                patientToEdit.getTags(),
                updatedNotes);

        model.setPatient(patientToEdit, editedPatient);
        model.updateFilteredPatientList(PREDICATE_SHOW_ALL_PATIENTS);

        return new CommandResult(generateSuccessMessage(editedPatient));
    }

    /**
     * Returns true if the note title already exists in the updated notes.
     * Method is case-insensitive, meaning "Note" and "note" are considered the same.
     *
     * @param updatedNotes The updated notes of the patient.
     * @param note The note to check for duplicates.
     * @return true if the note title already exists, false otherwise.
     */
    public boolean alreadyHasNoteTitle(TreeSet<Note> updatedNotes, Note note) {
        requireAllNonNull(updatedNotes, note);
        List<Note> notesList = updatedNotes.stream().toList();

        String newNoteTitle = note.getTitle().toLowerCase();
        for (Note existingNote : notesList) {
            String existingNoteTitle = existingNote.getTitle().toLowerCase();
            if (existingNoteTitle.equals(newNoteTitle)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Stores the details to add the note with. Each non-empty field value
     * will replace the corresponding field value of the note.
     */
    public static class AddNoteDescriptor {
        private String title;
        private String content;
        private LocalDateTime dateTimeCreated;

        public AddNoteDescriptor() {
        } /* Default Constructor*/

        /**
         * Returns true if at least one field is edited.
         */
        public boolean isAnyFieldEdited() {
            return CollectionUtil.isAnyNonNull(title, content, dateTimeCreated);
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }
    }

    /**
     * Generates a command execution success message when a note is added.
     *
     * @param patientToEdit The patient to which the note was added.
     * @return The success message.
     */
    private String generateSuccessMessage(Patient patientToEdit) {
        return String.format(MESSAGE_ADD_NOTE_SUCCESS, Messages.format(patientToEdit));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof NoteCommand)) {
            return false;
        }

        NoteCommand e = (NoteCommand) other;
        return index.equals(e.index)
                && this.note.getTitle().equals(e.note.getTitle())
                && this.note.getContent().equals(e.note.getContent());
    }
}
