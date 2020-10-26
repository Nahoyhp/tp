package seedu.address.model.person.exceptions;

public class DuplicateExerciseException extends RuntimeException {
    public DuplicateExerciseException() {
        super("Operation would result in duplicate exercise");
    }
}
