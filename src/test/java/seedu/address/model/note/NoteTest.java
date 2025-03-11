package seedu.address.model.note;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class NoteTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Note(null, null));
    }

    @Test
    public void constructor_invalidTitleAndContent_throwsIllegalArgumentException() {
        String invalidTitle = "";
        String invalidContent = "";
        assertThrows(IllegalArgumentException.class, () -> new Note(invalidTitle, invalidContent));
    }
    
}
