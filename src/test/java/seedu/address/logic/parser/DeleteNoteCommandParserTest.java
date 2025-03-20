package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.Messages.MESSAGE_INVALID_NOTE_DELETE_TITLE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NOTE_TITLE;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PATIENT;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.DeleteNoteCommand;
import seedu.address.model.note.Note;

public class DeleteNoteCommandParserTest {

    private static final String MESSAGE_INVALID_FORMAT =
            String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteNoteCommand.MESSAGE_USAGE);
    private final String nonEmptyTitle = "Some title.";
    private DeleteNoteCommandParser parser = new DeleteNoteCommandParser();

    @Test
    public void parse_indexAndTitleSpecified_success() {
        Index targetIndex = INDEX_FIRST_PATIENT;
        String userInput = targetIndex.getOneBased() + " " + PREFIX_NOTE_TITLE + nonEmptyTitle;
        DeleteNoteCommand expectedCommand = new DeleteNoteCommand(targetIndex, nonEmptyTitle);
        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_missingParts_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteNoteCommand.MESSAGE_USAGE);

        // missing all parameters
        assertParseFailure(parser, DeleteNoteCommand.COMMAND_WORD, expectedMessage);

        // missing index only (deletenote nt/Some title.)
        assertParseFailure(parser, DeleteNoteCommand.COMMAND_WORD + " " + PREFIX_NOTE_TITLE
                + nonEmptyTitle, expectedMessage);

        // missing title only (deletenote 1 nt/)
        assertParseFailure(parser, DeleteNoteCommand.COMMAND_WORD + " " + INDEX_FIRST_PATIENT
                + " " + PREFIX_NOTE_TITLE, expectedMessage);

        // missing title prefix only (deletenote 1 Some title.)
        assertParseFailure(parser, DeleteNoteCommand.COMMAND_WORD + " " + INDEX_FIRST_PATIENT
                + " " + nonEmptyTitle, expectedMessage);

        // missing title prefix and title (deletenote 1
        assertParseFailure(parser, DeleteNoteCommand.COMMAND_WORD + " " + INDEX_FIRST_PATIENT, expectedMessage);
    }
}
