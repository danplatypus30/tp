package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.note.Note;
import seedu.address.model.patient.Patient;

/**
 * A utility class containing a list of {@code Patient} objects to be used in
 * tests.
 */
public class TypicalPatients {

    public static final Patient ALICE = new PatientBuilder().withName("Alice Pauline")
            .withAddress("123, Jurong West Ave 6, #08-111")
            .withPhone("94351253")
            .withTags("friends")
            .withNotes(
                    new Note("4th Session with Alice",
                            "Discussed progress",
                            LocalDateTime.parse("2023-03-11T12:00:00")))
            .build();
    public static final Patient BENSON = new PatientBuilder().withName("Benson Meier")
            .withAddress("311, Clementi Ave 2, #02-25")
            .withPhone("98765432")
            .withTags("owesMoney", "friends")
            .withNotes(
                    new Note("Benson is a piece of work",
                            "He has many issues",
                            LocalDateTime.parse("2025-03-11T12:00:00")))
            .build();
    public static final Patient CARL = new PatientBuilder().withName("Carl Kurz").withPhone("95352563")
            .withAddress("wall street").build();
    public static final Patient DANIEL = new PatientBuilder().withName("Daniel Meier")
            .withPhone("87652533")
            .withAddress("10th street")
            .withTags("friends")
            .withNotes(
                    new Note("Daniel owes me money",
                            "He owes me $4000",
                            LocalDateTime.parse("2025-03-12T12:00:00")))
            .build();
    public static final Patient ELLE = new PatientBuilder().withName("Elle Meyer").withPhone("9482224")
            .withAddress("michegan ave").build();
    public static final Patient FIONA = new PatientBuilder().withName("Fiona Kunz").withPhone("9482427")
            .withAddress("little tokyo").build();
    public static final Patient GEORGE = new PatientBuilder().withName("George Best").withPhone("9482442")
            .withAddress("4th street").build();

    // Manually added
    public static final Patient HOON = new PatientBuilder().withName("Hoon Meier").withPhone("8482424")
            .withAddress("little india").build();
    public static final Patient IDA = new PatientBuilder().withName("Ida Mueller").withPhone("8482131")
            .withAddress("chicago ave").build();

    // Manually added - Patient's details found in {@code CommandTestUtil}
    public static final Patient AMY = new PatientBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
            .withAddress(VALID_ADDRESS_AMY).withTags(VALID_TAG_FRIEND).build();
    public static final Patient BOB = new PatientBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
            .withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND)
            .build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalPatients() {
    } // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical patients.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Patient patient : getTypicalPatients()) {
            ab.addPatient(patient);
        }
        return ab;
    }

    public static List<Patient> getTypicalPatients() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
