package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NOTE_TITLE;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PATIENT;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.FilterNoteCommand;
public class FilterNoteCommandParserTest {
    private FilterNoteCommandParser testParser = new FilterNoteCommandParser();
    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(testParser, "     ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FilterNoteCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_correctIndex_success() {
        String userInput = INDEX_FIRST_PATIENT.getOneBased() + " " + PREFIX_NOTE_TITLE + "test";
        FilterNoteCommand expectedCommand = new FilterNoteCommand(INDEX_FIRST_PATIENT, "test");
        assertParseSuccess(testParser, userInput, expectedCommand);
    }

    @Test
    public void parse_missingTitle_failure() {
        String userInput = INDEX_FIRST_PATIENT.getOneBased() + "";
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, FilterNoteCommand.MESSAGE_USAGE);
        assertParseFailure(testParser, userInput, expectedMessage);
    }



}
