package seedu.address.ui;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import seedu.address.model.note.Note;
import seedu.address.model.patient.Patient;

/**
 * Panel that displays notes for a selected patient or all patients.
 */
public class NotesDisplayPanel extends UiPart<Region> {

    private static final String FXML = "NotesDisplayPanel.fxml";

    @FXML
    private Label patientNameLabel;

    @FXML
    private VBox notesContainer;

    /**
     * Creates a {@code NotesDisplayPanel} with empty content.
     */
    public NotesDisplayPanel() {
        super(FXML);
        reset();
    }

    /**
     * Resets the panel to its default empty state.
     */
    public void reset() {
        patientNameLabel.setText("No patient selected");
        notesContainer.getChildren().clear();
    }

    /**
     * Updates the panel with notes from all patients in the list.
     *
     * @param patients The list of patients whose notes should be displayed.
     */
    public void displayAllNotes(List<Patient> patients) {
        requireNonNull(patients);
        patientNameLabel.setText("Notes for all patients");
        notesContainer.getChildren().clear();

        boolean hasAnyNotes = false;
        int totalNoteNumber = 1;

        for (Patient patient : patients) {
            List<Note> patientNotes = patient.getNotes().stream().toList();
            if (!patientNotes.isEmpty()) {
                hasAnyNotes = true;

                // Add patient header in a box
                VBox patientHeaderBox = new VBox();
                patientHeaderBox.getStyleClass().add("patient-header-box");
                Label patientHeader = new Label(patient.getName().fullName);
                patientHeader.getStyleClass().add("patient-section-header");
                patientHeaderBox.getChildren().add(patientHeader);
                notesContainer.getChildren().add(patientHeaderBox);

                // Add patient's notes
                for (Note note : patientNotes) {
                    VBox noteBox = createNoteBox(note, totalNoteNumber++);
                    notesContainer.getChildren().add(noteBox);
                }
            }
        }

        if (!hasAnyNotes) {
            Label noNotesLabel = new Label("No notes found for any patients.");
            noNotesLabel.getStyleClass().add("note-content");
            notesContainer.getChildren().add(noNotesLabel);
        }
    }

    /**
     * Updates the panel with notes from the specified patient.
     *
     * @param patient The patient whose notes should be displayed.
     */
    public void displayNotes(Patient patient) {
        requireNonNull(patient);
        patientNameLabel.setText("Notes for " + patient.getName().fullName);

        notesContainer.getChildren().clear();
        List<Note> notesList = patient.getNotes().stream().toList();

        if (notesList.isEmpty()) {
            Label noNotesLabel = new Label("This patient has no notes.");
            noNotesLabel.getStyleClass().add("viewnotes-content");
            notesContainer.getChildren().add(noNotesLabel);
            return;
        }

        int noteNumber = 1;
        for (Note note : notesList) {
            VBox noteBox = createNoteBox(note, noteNumber++);
            notesContainer.getChildren().add(noteBox);
        }
    }

    /**
     * Updates the panel with the specific filtered note from the specified patient.
     *
     * @param patient      The patient whose notes should be displayed.
     * @param matchingNote the notes that match the keyword
     */
    public void displayNotes(Patient patient, List<Note> matchingNote) {
        requireNonNull(patient);
        patientNameLabel.setText("Notes for " + patient.getName().fullName);

        notesContainer.getChildren().clear();

        if (matchingNote.isEmpty()) {
            Label noNotesLabel = new Label("This patient has no notes.");
            noNotesLabel.getStyleClass().add("filternote-content");
            notesContainer.getChildren().add(noNotesLabel);
            return;
        }

        int noteNumber = 1;
        for (Note note : matchingNote) {
            VBox noteBox = createNoteBox(note, noteNumber++);
            notesContainer.getChildren().add(noteBox);
        }
    }

    /**
     * Creates a formatted box for displaying a single note.
     *
     * @param note       The note to display.
     * @param noteNumber The sequence number of this note.
     * @return A VBox containing the formatted note.
     */
    private VBox createNoteBox(Note note, int noteNumber) {
        VBox noteBox = new VBox(8); // Spacing between title box and content
        noteBox.getStyleClass().add("note-item");

        // Create a title container
        VBox titleBox = new VBox();
        titleBox.getStyleClass().add("note-title-box");

        // Create a horizontal box for number and title
        javafx.scene.layout.HBox titleContainer = new javafx.scene.layout.HBox(10); // 10 pixels spacing

        // Note number
        Label numberLabel = new Label("#" + noteNumber);
        numberLabel.getStyleClass().add("note-number");

        // Title with pink styling
        Label titleLabel = new Label(note.getTitle());
        titleLabel.getStyleClass().add("note-title");

        titleContainer.getChildren().addAll(numberLabel, titleLabel);
        titleBox.getChildren().add(titleContainer);

        // Content
        Label contentLabel = new Label(note.getContent());
        contentLabel.getStyleClass().add("note-content");
        contentLabel.setWrapText(true);

        // Date information in its own container
        VBox dateBox = new VBox();
        dateBox.getStyleClass().add("note-date-box");
        String formattedDateTime = note.getDateTimeCreated().format(
                java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        Label dateLabel = new Label("Created: " + formattedDateTime);
        dateLabel.getStyleClass().add("note-date");
        dateBox.getChildren().add(dateLabel);

        // Add all components to the note box
        noteBox.getChildren().addAll(titleBox, contentLabel, dateBox);
        return noteBox;
    }
}
