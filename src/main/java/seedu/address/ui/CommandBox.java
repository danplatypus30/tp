package seedu.address.ui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * The UI component that is responsible for receiving user command inputs.
 */
public class CommandBox extends UiPart<Region> {

    public static final String ERROR_STYLE_CLASS = "error";
    private static final String FXML = "CommandBox.fxml";
    private static final double PADDING = 10; // Extra padding for better spacing
    private static final double MAX_HEIGHT = 120; // Max height to prevent overflow
    private static final double MIN_HEIGHT = 30; // Min height for single line

    private final CommandExecutor commandExecutor;

    @FXML
    private TextArea commandTextArea;

    /**
     * Creates a {@code CommandBox} with the given {@code CommandExecutor}.
     */
    public CommandBox(CommandExecutor commandExecutor) {
        super(FXML);
        this.commandExecutor = commandExecutor;

        // Adjust height dynamically
        commandTextArea.textProperty().addListener((obs, oldText, newText) -> adjustHeight());

        // Executes command when enter is pressed, and prevents new lines when enter is pressed without Shift
        commandTextArea.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ENTER && !event.isShiftDown()) {
                event.consume(); // Prevent Enter from adding a new line
                setStyleToDefault();
                handleCommandEntered(); // Execute command
            }
        });
    }

    /**
     * Handles the Enter button pressed event.
     */
    @FXML
    private void handleCommandEntered() {
        String commandText = commandTextArea.getText();
        if (commandText.equals("")) {
            return;
        }

        try {
            commandExecutor.execute(commandText);
            commandTextArea.setText("");
        } catch (CommandException | ParseException e) {
            setStyleToIndicateCommandFailure();
        }
    }


    /**
     * Dynamically adjust the height of the command box based on the content.
     */
    private void adjustHeight() {
        double newHeight = computeTextHeight();
        newHeight = Math.min(MAX_HEIGHT, Math.max(MIN_HEIGHT, newHeight));

        commandTextArea.setPrefHeight(newHeight);
        commandTextArea.setMinHeight(newHeight);

        // Ensure parent layout updates dynamically
        commandTextArea.getParent().requestLayout();
    }

    /**
     * Computes the height required for the text content, considering wrapping.
     */
    private double computeTextHeight() {
        double textWidth = commandTextArea.getWidth() - 10; // Adjust for padding
        Text text = new Text(commandTextArea.getText());
        text.setFont(commandTextArea.getFont());
        text.setWrappingWidth(textWidth);

        double computedHeight = text.getLayoutBounds().getHeight() + PADDING;
        return Math.max(MIN_HEIGHT, Math.min(MAX_HEIGHT, computedHeight));
    }

    /**
     * Sets the command box style to use the default style.
     */
    private void setStyleToDefault() {
        commandTextArea.getStyleClass().remove(ERROR_STYLE_CLASS);
    }

    /**
     * Sets the command box style to indicate a failed command.
     */
    private void setStyleToIndicateCommandFailure() {
        ObservableList<String> styleClass = commandTextArea.getStyleClass();

        if (styleClass.contains(ERROR_STYLE_CLASS)) {
            return;
        }

        styleClass.add(ERROR_STYLE_CLASS);
    }

    /**
     * Represents a function that can execute commands.
     */
    @FunctionalInterface
    public interface CommandExecutor {
        /**
         * Executes the command and returns the result.
         *
         * @see seedu.address.logic.Logic#execute(String)
         */
        CommandResult execute(String commandText) throws CommandException, ParseException;
    }

}
