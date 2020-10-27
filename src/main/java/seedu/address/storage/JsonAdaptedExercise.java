package seedu.address.storage;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.exercise.Calories;
import seedu.address.model.exercise.Date;
import seedu.address.model.exercise.Description;
import seedu.address.model.exercise.Exercise;
import seedu.address.model.exercise.Muscle;
import seedu.address.model.exercise.Name;

/**
 * Jackson-friendly version of {@link Exercise}.
 */
class JsonAdaptedExercise {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Exercise's %s field is missing!";

    private final String name;
    private final String description;
    private final String date;
    private final String calories;
    private final String musclesWorked;

    /**
     * Constructs a {@code JsonAdaptedExercise} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedExercise(@JsonProperty("name") String name, @JsonProperty("phone") String description,
                               @JsonProperty("email") String date, @JsonProperty("address") String calories,
                               @JsonProperty("musclesWorked") String musclesWorked) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.calories = calories;
        this.musclesWorked = musclesWorked;
    }

    /**
     * Converts a given {@code JsonAdaptedExercise} into this class for Jackson use.
     */
    public JsonAdaptedExercise(Exercise source) {
        name = source.getName().fullName;
        description = source.getDescription().value;
        date = source.getDate().value;
        calories = source.getCalories().value;
        musclesWorked = source.getMusclesWorkedDescription();
    }

    /**
     * Converts this Jackson-friendly adapted exercise object into the model's {@code Exercise} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted exercise.
     */
    public Exercise toModelType() throws IllegalValueException {

        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (!Name.isValidName(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final Name modelName = new Name(name);

        if (description == null) {
            throw new IllegalValueException("Exercise's Description field is missing!");
        }
        if (!Description.isValidDescription(description)) {
            throw new IllegalValueException("Invalid description");
        }
        final Description modelDescription = new Description(description);

        if (date == null) {
            throw new IllegalValueException("Exercise's Date field is missing!");
        }
        if (!Date.isValidDate(date)) {
            throw new IllegalValueException("Invalid Date");
        }
        final Date modelDate = new Date(date);

        if (calories == null) {
            throw new IllegalValueException("Exercise's Calories field is missing!");
        }
        if (!Calories.isValidCalories(calories)) {
            throw new IllegalValueException("Invalid Calories");
        }
        final Calories modelCalories = new Calories(calories);

        if (musclesWorked == null) {
            throw new IllegalValueException("Exercise's Muscle field is missing!");
        }
        List<Muscle> musclesWorkedLst = Muscle.stringToMuscleList(musclesWorked);

        return new Exercise(modelName, modelDescription, modelDate, modelCalories, musclesWorkedLst);
    }
}
