package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.patient.Patient;

/**
 * Views notes for a specific patient or all patients in NeuroSync.
 */
public class ViewNotesCommand extends Command {

    public static final String COMMAND_WORD = "viewnotes";

    public static final String MESSAGE_SUCCESS = "Displaying notes for %1$s";
    public static final String MESSAGE_SUCCESS_ALL = "Displaying notes for all patients";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Views notes for the patient identified by the index number used in the displayed patient list "
            + "or views notes for all patients.\n"
            + "Parameters: INDEX (must be a positive integer) or 'all'\n"
            + "Example: " + COMMAND_WORD + " 1 OR " + COMMAND_WORD + " all";
    public static final String MESSAGE_INVALID_INDEX = "The patient index provided (%1$s) is invalid.\n"
            + "Please provide a positive number within the range of the patient list.\n" + MESSAGE_USAGE;
    public static final String MESSAGE_INVALID_FORMAT = "Invalid command format.\n"
            + "Please use either a positive number or 'all'.\n" + MESSAGE_USAGE;
    public static final String ALL_PARAMETER = "all";

    private static final Logger logger = LogsCenter.getLogger(ViewNotesCommand.class);

    private final String parameter;

    /**
     * Creates a ViewNotesCommand to view notes for a specific patient or all
     * patients.
     *
     * @param parameter The index of the patient or "all" to view all patients'
     *                  notes
     */
    public ViewNotesCommand(String parameter) {
        assert parameter != null : "Parameter cannot be null";
        this.parameter = parameter;
    }

    /**
     * Executes the view notes command for either a specific patient or all
     * patients.
     *
     * @param model The model containing patient data
     * @return CommandResult containing the appropriate message and patient data
     * @throws CommandException if the patient index is invalid
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        logger.info("Executing view notes command with parameter: " + parameter);

        List<Patient> lastShownList = model.getFilteredPatientList();

        if (parameter.equalsIgnoreCase(ALL_PARAMETER)) {
            logger.info("Viewing notes for all patients");
            return new CommandResult(MESSAGE_SUCCESS_ALL,
                    false, false, true,
                    "all patients",
                    null,
                    lastShownList);
        }

        try {
            Index targetIndex = Index.fromOneBased(Integer.parseInt(parameter));
            if (targetIndex.getZeroBased() >= lastShownList.size()) {
                logger.warning("Invalid index provided: " + parameter);
                throw new CommandException(String.format(MESSAGE_INVALID_INDEX, parameter));
            }

            Patient patientToView = lastShownList.get(targetIndex.getZeroBased());
            logger.info("Viewing notes for patient: " + patientToView.getName().fullName);
            return new CommandResult(String.format(MESSAGE_SUCCESS, patientToView.getName().fullName),
                    false, false, true,
                    patientToView.getName().fullName,
                    patientToView.getNotes().stream().toList(),
                    null);
        } catch (NumberFormatException e) {
            logger.warning("Invalid parameter format: " + parameter);
            throw new CommandException(MESSAGE_INVALID_FORMAT);
        }
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ViewNotesCommand // instanceof handles nulls
                        && parameter.equals(((ViewNotesCommand) other).parameter)); // state check
    }

    public String getParameter() {
        return parameter;
    }
}
