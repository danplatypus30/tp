package seedu.address.logic.commands;

import static seedu.address.logic.parser.CliSyntax.PREFIX_NOTE_TITLE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NOTE_CONTENT;

import seedu.address.model.Model;

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
    public static final String MESSAGE_NOT_IMPLEMENTED_YET = "Note command not implemented yet";

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult("Note command executed");
    }
}
