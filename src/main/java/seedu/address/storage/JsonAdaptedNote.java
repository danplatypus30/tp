package seedu.address.storage;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.note.Note;
import seedu.address.model.tag.Tag;

/**
 * Jackson-friendly version of {@link Tag}.
 */
class JsonAdaptedNote {

    private final String title;
    private final String content;
    private final LocalDateTime dateTimeCreated;

    /**
     * Constructor for Jackson deserialization
     * Constructs a {@code JsonAdaptedNote} with the given {@code title}, {@code content} and {@code LocalDateTime}.
     */
    @JsonCreator
    public JsonAdaptedNote(@JsonProperty("title") String title,
            @JsonProperty("content") String content,
            @JsonProperty("dateTimeCreated") LocalDateTime dateTimeCreated) {
        this.title = title;
        this.content = content;
        this.dateTimeCreated = dateTimeCreated;
    }

    public JsonAdaptedNote(Note source) {
        this.title = source.getTitle();
        this.content = source.getContent();
        this.dateTimeCreated = source.getDateTimeCreated();
    }

    /**
     * Converts this Jackson-friendly adapted tag object into the model's {@code Note} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted tag.
     */
    public Note toModelType() throws IllegalValueException {
        if (!Note.isValidNote(this.title, this.content)) {
            throw new IllegalValueException(Note.TITLE_AND_CONTENT_CONSTRAINTS);
        }
        return new Note(this.title, this.content, this.dateTimeCreated);
    }

}
