package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.ViewNotesCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new ViewNotesCommand object.
 */
public class ViewNotesCommandParser implements Parser<ViewNotesCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the
     * ViewNotesCommand
     * and returns a ViewNotesCommand object for execution.
     *
     * @throws ParseException if the user input does not conform to the expected
     *                        format
     */
    public ViewNotesCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();

        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewNotesCommand.MESSAGE_USAGE));
        }

        // Check if the argument is "all"
        if (trimmedArgs.equalsIgnoreCase(ViewNotesCommand.ALL_PARAMETER)) {
            return new ViewNotesCommand(ViewNotesCommand.ALL_PARAMETER);
        }

        try {
            Index index = ParserUtil.parseIndex(trimmedArgs);
            return new ViewNotesCommand(String.valueOf(index.getOneBased()));
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewNotesCommand.MESSAGE_USAGE), pe);
        }
    }
}
