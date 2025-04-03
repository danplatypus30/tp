package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPatients.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.exceptions.RedoException;
import seedu.address.model.exceptions.UndoException;
import seedu.address.model.patient.Patient;
import seedu.address.testutil.PatientBuilder;

public class VersionedAddressBookTest {

    @Test
    public void getFutureState_canNotRedo_failure() {
        VersionedAddressBook versionedAddressBook = new VersionedAddressBook();
        assertThrows(RedoException.class, () -> versionedAddressBook.getFutureState());
    }

    @Test
    public void getFutureState_canRedo_success() throws UndoException, RedoException {
        VersionedAddressBook versionedAddressBook = new VersionedAddressBook();
        versionedAddressBook.saveState(getTypicalAddressBook());

        AddressBook copy = new AddressBook(getTypicalAddressBook());
        Patient validPatient = new PatientBuilder().build();
        copy.addPatient(validPatient);
        versionedAddressBook.saveState(copy);

        ReadOnlyAddressBook oldState = versionedAddressBook.getOldState();
        ReadOnlyAddressBook futureState = versionedAddressBook.getFutureState();

        assertEquals(futureState, copy);
    }

    @Test
    public void getOldState_canNotUndo_failure() {
        VersionedAddressBook versionedAddressBook = new VersionedAddressBook();
        assertThrows(UndoException.class, () -> versionedAddressBook.getOldState());
    }

    @Test
    public void getOldState_canUndo_success() throws UndoException {
        VersionedAddressBook versionedAddressBook = new VersionedAddressBook();
        versionedAddressBook.saveState(getTypicalAddressBook());

        AddressBook copy = new AddressBook(getTypicalAddressBook());
        Patient validPatient = new PatientBuilder().build();
        copy.addPatient(validPatient);
        versionedAddressBook.saveState(copy);

        ReadOnlyAddressBook expected = getTypicalAddressBook();
        ReadOnlyAddressBook oldState = versionedAddressBook.getOldState();

        assertEquals(oldState, expected);
    }

}
