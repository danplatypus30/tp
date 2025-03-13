package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PATIENT;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.ViewNotesCommand;
import seedu.address.logic.parser.exceptions.ParseException;

public class ViewNotesCommandParserTest {

    private final ViewNotesCommandParser parser = new ViewNotesCommandParser();

    @Test
    public void parse_validArgs_returnsViewNotesCommand() throws Exception {
        ViewNotesCommand command = parser.parse("1");
        assertEquals(new ViewNotesCommand(INDEX_FIRST_PATIENT), command);
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertThrows(ParseException.class, () -> parser.parse("invalid"));
        assertThrows(ParseException.class, () -> parser.parse(""));
        assertThrows(ParseException.class, () -> parser.parse("0"));
    }
}
