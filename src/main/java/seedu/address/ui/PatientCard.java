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
                .map(note -> "[" + note.getTitle() + "]") // Formatting titles as [title]
                .collect(Collectors.joining(" ")); // Join titles with a space

        // Set text dynamically
        Label notesLabel = new Label(noteTitles);
        notesLabel.setWrapText(true); // Ensure wrapping if necessary
        notes.getChildren().add(notesLabel);
    }
}
