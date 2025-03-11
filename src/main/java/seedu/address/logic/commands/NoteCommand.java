package seedu.address.logic.commands;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NOTE_CONTENT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NOTE_TITLE;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.note.Note;

/**
 * Adds a note to a patient in the address book.
 */
public class NoteCommand extends Command {
    public static final String COMMAND_WORD = "note";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a new note for the patient identified "
            + "by the index number used in the displayed patient list.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + PREFIX_NOTE_TITLE + "[NOTE TITLE] "
            + PREFIX_NOTE_CONTENT + "[NOTE CONTENT]\n"
            + "Example: " + COMMAND_WORD + " 1"
            + PREFIX_NOTE_TITLE + "Patient has allergies!"
            + PREFIX_NOTE_CONTENT + "Allergies include:\n - Penicillin\n - Nuts";
    private static final String MESSAGE_ARGUMENTS = "Index: %1$d, Note Title: %2$s, Note Content: %3$s";

    private final Index index;
    private final Note note;

    /**
     * Creates a NoteCommand to add the specified {@code Note}
     * @param index index of the patient in the filtered patient list
     * @param title title of the note
     * @param content content of the note
     */
    public NoteCommand(Index index, Note note) {
        requireAllNonNull(index, note);
        this.index = index;
        this.note = note;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        throw new CommandException(String.format(MESSAGE_ARGUMENTS, index.getOneBased(), this.note.getTitle(),
                this.note.getContent()));
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
