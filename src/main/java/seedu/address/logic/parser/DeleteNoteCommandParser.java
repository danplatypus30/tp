package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NOTE_TITLE;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.DeleteNoteCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new EditCommand object
 */
public class DeleteNoteCommandParser implements Parser<DeleteNoteCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the EditCommand
     * and returns an EditCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteNoteCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_NOTE_TITLE);

        Index index;

        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteNoteCommand.MESSAGE_USAGE), pe);
        }

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_NOTE_TITLE);

        if (argMultimap.getValue(PREFIX_NOTE_TITLE).isEmpty()) {
            throw new ParseException(DeleteNoteCommand.MESSAGE_NOTE_NOT_FOUND);
        }

        String targetTitle = argMultimap.getValue(PREFIX_NOTE_TITLE).get();
        return new DeleteNoteCommand(index, targetTitle);
    }

}

