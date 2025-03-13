package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PATIENT;
import static seedu.address.testutil.TypicalPatients.getTypicalAddressBook;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.note.Note;
import seedu.address.model.patient.Patient;

public class ViewNotesCommandTest {

    private Model model;
    private List<Note> notes;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        notes = new ArrayList<>();
        notes.add(new Note("Test Note", "This is a test note."));
    }
    @Test
    public void execute_validPatientWithoutNotes_noNotesMessage() {
        Index index = Index.fromOneBased(3); // Carl Kurz
        ViewNotesCommand command = new ViewNotesCommand(index);
        Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

        Patient patient = model.getFilteredPatientList().get(index.getZeroBased());

        CommandResult expectedCommandResult = new CommandResult(
                String.format(ViewNotesCommand.MESSAGE_NO_NOTES, patient.getName().fullName)
        );

        assertCommandSuccess(command, model, expectedCommandResult, model);
    }
    @Test
    public void execute_validPatientWithNotes_success() {
        Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        Patient patientToView = model.getFilteredPatientList().get(INDEX_FIRST_PATIENT.getZeroBased());

        ViewNotesCommand viewNotesCommand = new ViewNotesCommand(INDEX_FIRST_PATIENT);
        String expectedNotes = "1. 4th Session with Alice\n   Discussed progress";
        String expectedMessage = String.format(ViewNotesCommand.MESSAGE_SUCCESS, patientToView.getName().fullName,
                expectedNotes);

        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        CommandTestUtil.assertCommandSuccess(viewNotesCommand, model, expectedMessage.trim(), expectedModel);
    }

    @Test
    public void execute_invalidPatientIndex_throwsCommandException() {
        Index outOfBoundsIndex = Index.fromOneBased(model.getFilteredPatientList().size() + 1);
        ViewNotesCommand command = new ViewNotesCommand(outOfBoundsIndex);

        assertThrows(CommandException.class, () -> command.execute(model));
    }
}
