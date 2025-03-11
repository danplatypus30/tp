package seedu.address.model.note;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalDateTime;

/**
 * Class which encapsulates all the information and methods pertaining to notes
 * Notes have a many-to-one relationship with patients
 */
public class Note implements Comparable<Note>{

    public static final String TITLE_AND_CONTENT_CONSTRAINTS = "Title and content cannot be empty";

    private final String title;
    private final String content;
    private final LocalDateTime dateTimeCreated;

    /**
     * Initializes a new Note object with the given title and content
     * dateTimeCreated is initialized to the current time
     * @param title title of the note
     * @param content content of the note
     */
    public Note(String title, String content) {
        requireNonNull(title);
        requireNonNull(content);
        checkArgument(isValidTitleAndContent(title, content), TITLE_AND_CONTENT_CONSTRAINTS);
        this.title = title;
        this.content = content;
        this.dateTimeCreated = LocalDateTime.now();
    }

    public boolean isValidTitleAndContent(String title, String content) {
        return !title.isEmpty() && !content.isEmpty();
    }

    /**
     * Gets title of a note
     * @return title of the note
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Gets content of a note
     * @return content of the note
     */
    public String getContent() {
        return this.content;
    }

    /**
     * Gets the date and time the note was created
     * @return LocalDateTime object, which stores the date and time the note was created
     */
    public LocalDateTime getDateTimeCreated() {
        return this.dateTimeCreated;
    }

    /**
     * Enables sorting of notes based on date and time created
     * @param other another note object to compare with
     * @return 0 if the two notes were created at the same time, a positive integer if this note was created after the other note, and a negative integer if this note was created before the other note
     */
    @Override
    public int compareTo(Note other) {
        return this.dateTimeCreated.compareTo(other.dateTimeCreated);
    }

    /**
     * Returns a string representation of the note
     */
    @Override
    public String toString() {
        return "Title: " + this.title + "\n" + "Content: " + this.content + "\n" + "Date and Time Created: "
                + this.dateTimeCreated.toString();
    }

}
