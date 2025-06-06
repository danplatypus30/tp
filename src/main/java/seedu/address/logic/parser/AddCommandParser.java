package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.note.Note;
import seedu.address.model.patient.Address;
import seedu.address.model.patient.Name;
import seedu.address.model.patient.Patient;
import seedu.address.model.patient.Phone;
import seedu.address.model.tag.Tag;

/**
 * Parses input arguments and creates a new AddCommand object
 */
public class AddCommandParser implements Parser<AddCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddCommand
     * and returns an AddCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_PHONE, PREFIX_ADDRESS, PREFIX_TAG);

        if (!arePrefixesPresent(argMultimap, PREFIX_NAME, PREFIX_ADDRESS, PREFIX_PHONE)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
        }

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_NAME, PREFIX_PHONE, PREFIX_ADDRESS);
        Name name = ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get());
        Phone phone = ParserUtil.parsePhone(argMultimap.getValue(PREFIX_PHONE).get());
        Address address = ParserUtil.parseAddress(argMultimap.getValue(PREFIX_ADDRESS).get());
        Set<Tag> rawTagList = ParserUtil.parseTags(argMultimap.getAllValues(PREFIX_TAG));
        Set<Tag> tagList = filterTags(rawTagList);
        TreeSet<Note> notes = new TreeSet<>(); // add command does not allow adding notes straight away

        Patient patient = new Patient(name, phone, address, tagList, notes);

        return new AddCommand(patient);
    }

    /**
     * Filters the given set of tags to remove duplicates based on case-insensitive tag names.
     * Preserves the first occurrence of each unique tag name
     * @param rawTagList the set of tags to filter
     * @return a new set of tags with duplicates removed
     */
    protected Set<Tag> filterTags(Set<Tag> rawTagList) {
        // Use a map to track tags by lowercase name for case-insensitive comparison
        Map<String, Tag> uniqueTags = new HashMap<>();

        // Process each tag, keeping only the first instance for case-insensitive duplicates
        for (Tag tag : rawTagList) {
            String lowercaseTagName = tag.tagName.toLowerCase();
            if (!uniqueTags.containsKey(lowercaseTagName)) {
                uniqueTags.put(lowercaseTagName, tag);
            }
        }

        return new HashSet<>(uniqueTags.values());
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
