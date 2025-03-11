package seedu.address.model.note;

import java.time.LocalDateTime;

/**
 * Class which encapsulates all the information and methods pertaining to notes
 * Notes have a many-to-one relationship with patients
 */
public class Note implements Comparable<Note>{
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
        this.title = title;
        this.content = content;
        this.dateTimeCreated = LocalDateTime.now();
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
