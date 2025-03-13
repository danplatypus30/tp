package seedu.address.ui;

import java.util.Comparator;
import java.util.stream.Collectors;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import seedu.address.model.patient.Patient;

/**
 * A UI component that displays information of a {@code Patient}.
 */
public class PatientCard extends UiPart<Region> {

    private static final String FXML = "PatientListCard.fxml";

    public final Patient patient;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label phone;
    @FXML
    private Label address;
    @FXML
    private Label email;
    @FXML
    private FlowPane tags;
    @FXML
    private VBox notes;

    /**
     * Creates a {@code PatientCard} with the given {@code Patient} and index to display.
     *
     * @param patient The patient whose details should be displayed.
     * @param displayedIndex The index of the patient in the list.
     */
    public PatientCard(Patient patient, int displayedIndex) {
        super(FXML);
        this.patient = patient;
        id.setText(displayedIndex + ". ");
        name.setText(patient.getName().fullName);
        phone.setText(patient.getPhone().value);
        address.setText(patient.getAddress().value);
        email.setText(patient.getEmail().value);

        // Display tags
        patient.getTags().stream()
                .sorted(Comparator.comparing(tag -> tag.tagName))
                .forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));

        // Display only note titles inside square brackets
        String noteTitles = patient.getNotes().stream()
                .sorted(Comparator.comparing(note -> note.getDateTimeCreated()))
                .map(note -> "[" + note.getTitle() + "]")
                .collect(Collectors.joining(" "));

        // Set text dynamically
        Label notesLabel = new Label(noteTitles);
        notesLabel.setWrapText(true);
        notes.getChildren().add(notesLabel);
    }

    /**
     * Retrieves the displayed index text.
     *
     * @return The index as a string.
     */
    public String getDisplayedIndexText() {
        return id.getText();
    }

    /**
     * Retrieves the patient's name text.
     *
     * @return The patient's name.
     */
    public String getPatientNameText() {
        return name.getText();
    }

    /**
     * Retrieves the patient's phone number text.
     *
     * @return The phone number.
     */
    public String getPhoneText() {
        return phone.getText();
    }

    /**
     * Retrieves the patient's address text.
     *
     * @return The address.
     */
    public String getAddressText() {
        return address.getText();
    }

    /**
     * Retrieves the patient's email text.
     *
     * @return The email.
     */
    public String getEmailText() {
        return email.getText();
    }

    /**
     * Retrieves the formatted tags as a space-separated string.
     *
     * @return The formatted tag string.
     */
    public String getFormattedTags() {
        return tags.getChildren().stream()
                .map(node -> ((Label) node).getText())
                .collect(Collectors.joining(" "));
    }

    /**
     * Retrieves the formatted notes as a space-separated string.
     *
     * @return The formatted note titles.
     */
    public String getFormattedNotes() {
        return notes.getChildren().stream()
                .map(node -> ((Label) node).getText())
                .collect(Collectors.joining(" "));
    }
}
