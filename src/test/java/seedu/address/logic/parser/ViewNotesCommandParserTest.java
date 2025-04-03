package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.Messages.MESSAGE_SPECIAL_CHARACTERS;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PATIENT;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.ViewNotesCommand;

public class ViewNotesCommandParserTest {
    private ViewNotesCommandParser parser = new ViewNotesCommandParser();

    @Test
    public void parse_validIndex_success() {
        assertParseSuccess(parser, "1",
                new ViewNotesCommand(String.valueOf(INDEX_FIRST_PATIENT.getOneBased())));
    }

    @Test
    public void parse_validAll_success() {
        assertParseSuccess(parser, "all",
                new ViewNotesCommand(ViewNotesCommand.ALL_PARAMETER));
    }

    @Test
    public void parse_specialCharacters_throwsParseException() {
        // Test special characters
        assertParseFailure(parser, "@1",
                String.format(MESSAGE_SPECIAL_CHARACTERS, ViewNotesCommand.MESSAGE_USAGE));
        assertParseFailure(parser, "1!",
                String.format(MESSAGE_SPECIAL_CHARACTERS, ViewNotesCommand.MESSAGE_USAGE));
        assertParseFailure(parser, "#all",
                String.format(MESSAGE_SPECIAL_CHARACTERS, ViewNotesCommand.MESSAGE_USAGE));
        // Test negative numbers (contains special character '-')
        assertParseFailure(parser, "-1",
                String.format(MESSAGE_SPECIAL_CHARACTERS, ViewNotesCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        // Test non-numeric input (letters only)
        assertParseFailure(parser, "abc",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewNotesCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewNotesCommand.MESSAGE_USAGE));
        assertParseFailure(parser, "   ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewNotesCommand.MESSAGE_USAGE));
    }
}
